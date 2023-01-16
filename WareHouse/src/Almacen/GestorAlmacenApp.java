package Almacen;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Scanner;
import Factura.*;
import Articulos.*;
public class GestorAlmacenApp {

	public static void run() throws IOException, ParseException {
		final int REALIZAR_VENTA=1;
		final int REALIZAR_COMPRA=2;
		final int VER_ARTICULOS_SALUDABLES=3;
		final int VER_ARTICULO_MAS_CARO=4;
		final int VER_ARTICULO_CON_MENOS_STOCK=5;
		final int SALIR=0;
		
		Scanner sc=new Scanner(System.in);
		Almacen almacen=new Almacen();
		Factura factura=new Factura();
		int opcion_menu=0;
		int num=0;
		String code="";
		String opcion="";
		
		almacen.cargarDatos();
		
		
		do {
			System.out.println("----------MENU----------");
			System.out.println(REALIZAR_VENTA+". realizar venta");
			System.out.println(REALIZAR_COMPRA+". realizar compra");
			System.out.println(VER_ARTICULOS_SALUDABLES+". ver articulos saludables");
			System.out.println(VER_ARTICULO_MAS_CARO+". ver articulo mas caro");
			System.out.println(VER_ARTICULO_CON_MENOS_STOCK+". ver articulo con menos stock que el indicado");
			System.out.println(SALIR+". salir");
			System.out.println("Escoge la opcion que quieras:");
			opcion_menu=Integer.parseInt(sc.nextLine());
			
			switch(opcion_menu) {
				case REALIZAR_VENTA:
					facturaInfo(factura, sc);
					int numLinea=1;
					do {
						crearLinea(numLinea,factura,sc,almacen);
						System.out.println("Quiere seguir introduciendo lineas? Introduzca S si quiere seguir y N si no");
						opcion=sc.nextLine();
						numLinea++;
					}while(!opcion.toUpperCase().equals("N"));
					System.out.println("Mostrando factura...");
					factura.mostrarEnPantalla();
					System.out.println("Quiere guardar la factura?");
					opcion=sc.nextLine();
					if(opcion.toLowerCase().equals("si")) {
						System.out.println("Guardando factura...");
						factura.guardarEnFichero();
						System.out.println("Se ha guardado la factura. Muchas gracias por su compra");
					}
					else {
						System.out.println("Muchas gracias por su compra");
					}
					
					break;
				case REALIZAR_COMPRA:
					System.out.println("Introduce el codigo del articulo:");
					code=sc.nextLine();
					System.out.println("Introduce cuanto quieres incrementar el stock:");
					num=Integer.parseInt(sc.nextLine());
					for(Articulo art:almacen.articuloList) {
						if(art.getCode().equals(code)) {
							almacen.articuloList.remove(art);
							art.incrementarStock(num);
							almacen.articuloList.add(art);
						}
					}
					
					
//					Revisar Iterator Concurrent modification exception
//					while(here.hasNext() && !encontrado) {
//						Articulo art = (Articulo) here.next();
//						if(art.getCode().equals(code)) {
//							if(art.getCode().equals(code)) {
//								almacen.articuloList.remove(art);
//								art.incrementarStock(num);
//								almacen.articuloList.add(art);
//							}
//						here.next();
//						}
//					}
					
					break;
				case VER_ARTICULOS_SALUDABLES:
					System.out.println("Articulos saludables:");
					for(Articulo art: almacen.articuloList) {
						if(art.saludable()) {
							System.out.println(art);
						}
					}
					break;
				case VER_ARTICULO_MAS_CARO:
					System.out.println("El articulo mas caro es "+ almacen.elMasCaro());
					break;
				case VER_ARTICULO_CON_MENOS_STOCK:
					System.out.println("Introduce un numero mayor que 0 para mostrarle los asrticulos que tienen menos stock que ese numero.");
					num=Integer.parseInt(sc.nextLine());
					for(Articulo art:almacen.articuloList) {
						if(art.getStock()<num) {
							System.out.println(art);
						}
					}
					break;
				case SALIR:
					break;
				default:
					break;
			}
		}while(opcion_menu!=SALIR);
		sc.close();
	}


	
	private static void crearLinea(int numLinea,Factura fact,Scanner sc,Almacen almacen) {
		LineaFactura linea=new LineaFactura();
		boolean encontrado=false;
		int cantidad=0;
		Articulo art=null;
		String nombre="";
		Cerveza cer=new Cerveza();
		Vino vin=new Vino();

		Refresco ref=new Refresco();
		Iterator<Articulo> here=almacen.articuloList.iterator();
		linea.setNumero(numLinea);
		System.out.println("Introduce el nombre del articulo que quieres comprar");
		nombre=sc.nextLine();
		while(here.hasNext()&& !encontrado) {
			art=(Articulo) here.next();
			if(nombre.toLowerCase().equals(art.getNombre().toLowerCase())) {
				encontrado=true;
				if(art instanceof Refresco) {
					ref=(Refresco)art;
					linea.setArticulo(ref);
				}
				else if(art instanceof Vino) {
					vin=(Vino)art;
					linea.setArticulo(vin);
				}
				else if(art instanceof Cerveza) {
					cer=(Cerveza)art;
					linea.setArticulo(cer);
				}
			}
			if(here.hasNext()){
				here.next();
			}
		}
		if(!encontrado) {
			System.out.println("No se ha encontrado el articulo en el almacen");
		}else {
			System.out.println("Introduce la cantidad del articulo que quieres comprar:");
			cantidad=Integer.parseInt(sc.nextLine());
			if(almacen.disponibilidad(cantidad, art.getCode())) {
				linea.setCantidad(cantidad);
				}
			else if(!almacen.disponibilidad(cantidad, art.getCode())) {
				System.out.println("No hay stock");
			}
			else if(art.getStock()>0 && art.getStock()<cantidad){
				linea.setCantidad(art.getStock());
				System.out.println("No hay suficiente cantidad, pero le mandaremos el stock que nos queda");
				art.setStock(0);
			}
		}
		fact.addLinea(linea);	
	}
	
	private static void facturaInfo(Factura fact, Scanner sc) throws ParseException {
		SimpleDateFormat fecha= new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Introduce el numero de la factura:");
		fact.setNumero(Integer.parseInt(sc.nextLine()));
		System.out.println("Introduce el nombre de la empresa:");
		fact.setNombreEmpresa(sc.nextLine());
		System.out.println("Introduce la fecha de hoy:");
		fact.setFecha(fecha.parse(sc.nextLine()));
		System.out.println("Introduce el concepto de la factura:");
		fact.setConcepto(sc.nextLine());
	}

}
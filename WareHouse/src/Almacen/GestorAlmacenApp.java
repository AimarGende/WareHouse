package Almacen;
import Almacen.*;
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
					realizarVenta(factura,almacen);
					System.out.println("Mostrando factura...");
					factura.mostrarEnPantalla();
					System.out.println("Guardando factura...");
					factura.guardarEnFichero();
					break;
				case REALIZAR_COMPRA:
					
					break;
				case VER_ARTICULOS_SALUDABLES:
					for(Articulo art: almacen.articuloList) {
						if(art.saludable()) {
							System.out.println(art);
						}
					}
					break;
				case VER_ARTICULO_MAS_CARO:
					almacen.elMasCaro();
					break;
				case VER_ARTICULO_CON_MENOS_STOCK:
					Articulo min=almacen.articuloList.get(0);
					for(Articulo art: almacen.articuloList) {
						if(art.getStock()<min.getStock()) {
							min=art;
						}
					}
					System.out.println(min);
					break;
				case SALIR:
					break;
				default:
					break;
			}
		}while(opcion_menu!=SALIR);
		sc.close();
	}

	private static void realizarVenta(Factura fact,Almacen almacen) throws ParseException {
		Scanner sc=new Scanner(System.in);
		String opcion="";
		SimpleDateFormat fecha= new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Introduce el numero de la factura:");
		fact.setNumero(Integer.parseInt(sc.nextLine()));
		System.out.println("Introduce la fecha de hoy:");
		fact.setFecha(fecha.parse(sc.nextLine()));
		System.out.println("Introduce el concepto de la factura:");
		fact.setConcepto(sc.nextLine());
		do {
			LineaFactura linea=crearLinea(sc, almacen);
			fact.addLinea(linea);
			System.out.println("Introduce S si quiere comprar un articulo o N si quiere dejar de comprar");
			opcion=sc.nextLine();
		}while(!opcion.equals("N"));
	}
	
	private static LineaFactura crearLinea(Scanner sc,Almacen almacen) {
		LineaFactura linea=new LineaFactura();
		boolean encontrado=false;
		int cantidad=0;
		Articulo art=null;
		String nombre="";
		Cerveza cer=new Cerveza();
		Vino vin=new Vino();
		Refresco ref=new Refresco();
		Iterator<Articulo> here=almacen.articuloList.iterator();
		System.out.println("Introduce el numero de la linea:");
		linea.setNumero(Integer.parseInt(sc.nextLine()));
		System.out.println("Introduce el nombre del articulo que quieres comprar");
		nombre=sc.nextLine();
		while(here.hasNext()&& !encontrado) {
			art=(Articulo) here.next();
			if(nombre.equals(art.getNombre())) {
				encontrado=true;
				if(art instanceof Refresco) {
					art=(Articulo)ref;
				}
				else if(art instanceof Vino) {
					art=(Articulo)vin;
				}
				else if(art instanceof Cerveza) {
					art=(Articulo)cer;
				}
			}
			here.next();
		}
		linea.setArticulo(art);
		if(!encontrado) {
			System.out.println("No se ha encontrado el articulo en el almacen");
		}
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
			System.out.println("No hay suficiente cantidad");
			art.setStock(0);
		}
		return linea;
	}


}

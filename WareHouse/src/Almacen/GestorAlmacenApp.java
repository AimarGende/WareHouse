package Almacen;
import Almacen.*;

import java.io.IOException;
import java.util.Scanner;
import Factura.*;
public class GestorAlmacenApp {

	public static void run() throws IOException {
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
					System.out.println("Mostrando factura...");
					factura.mostrarEnPantalla();
					System.out.println("Guardando factura...");
					factura.guardarEnFichero();
					break;
				case REALIZAR_COMPRA:
					
					break;
				case VER_ARTICULOS_SALUDABLES:
					break;
				case VER_ARTICULO_MAS_CARO:
					break;
				case VER_ARTICULO_CON_MENOS_STOCK:
					break;
				case SALIR:
					break;
				default:
					break;
			}
		}while(opcion_menu!=SALIR);
		sc.close();
	}
}

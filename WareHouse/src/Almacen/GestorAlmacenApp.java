package Almacen;
import Almacen.*;
import java.util.Scanner;
public class GestorAlmacenApp {

	public static void run() {
		final int REALIZAR_VENTA=1;
		final int REALIZAR_COMPRA=2;
		final int VER_ARTICULOS_SALUDABLES=3;
		final int VER_ARTICULO_MAS_CARO=4;
		final int VER_ARTICULO_CON_MENOS_STOCK=5;
		final int SALIR=0;
		
		Almacen almacen=new Almacen();
		int opcion_menu=0;
		
		do {
			switch(opcion_menu) {
				case REALIZAR_VENTA:
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
	}
}

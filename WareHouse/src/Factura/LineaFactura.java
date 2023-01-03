package Factura;
import Articulos.*;
public class LineaFactura {
	private int numero;
	private Articulo articulo;
	private int cantidad;
	
	public LineaFactura(int numero, Articulo articulo, int cantidad) {
		this.numero = numero;
		this.articulo = articulo;
		this.cantidad = cantidad;
	}

	public LineaFactura() {
		
	}
	
	
	
}

package Articulos;

public class Refresco extends Articulo {
	private String sabor;
	private boolean zumo;
	private boolean gaseoso;
	private int cantidadAzucar;
	
	public Refresco() {
		super();
	}
	
	public Refresco(String codigo, String nombre, String marca, int capacidadBotella, double precio, int stock, String sabor, boolean zumo, boolean gaseoso, int cantidadAzucar) {
		super(codigo, nombre, marca, capacidadBotella, precio, stock);
		this.sabor=sabor;
		this.zumo=zumo;
		this.gaseoso=gaseoso;
		this.cantidadAzucar=cantidadAzucar;
	}
	
	
}

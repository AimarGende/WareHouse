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

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public boolean isZumo() {
		return zumo;
	}

	public void setZumo(boolean zumo) {
		this.zumo = zumo;
	}

	public boolean isGaseoso() {
		return gaseoso;
	}

	public void setGaseoso(boolean gaseoso) {
		this.gaseoso = gaseoso;
	}

	public int getCantidadAzucar() {
		return cantidadAzucar;
	}

	public void setCantidadAzucar(int cantidadAzucar) {
		this.cantidadAzucar = cantidadAzucar;
	}
	
	public void visualizarPropiedades() {
		System.out.println(this.toString());
	}
	
	public boolean esSaludable() {
		boolean saludable=false;
		if(cantidadAzucar<20) {
			saludable=true;
		}
		return saludable;
	}
	
	
	
	
}

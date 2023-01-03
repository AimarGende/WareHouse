package Articulos;

public class Cerveza extends Articulo {
	private String origen;
	private String cereales;
	private double gradosAlcohol;
	
	public Cerveza(String code, String nombre, String marca, int capacidadBotella, double precio, int stock,
			String origen, String cereales, double gradosAlcohol) {
		super(code, nombre, marca, capacidadBotella, precio, stock);
		this.origen = origen;
		this.cereales = cereales;
		this.gradosAlcohol = gradosAlcohol;
	}

	public Cerveza() {
		super();
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getCereales() {
		return cereales;
	}

	public void setCereales(String cereales) {
		this.cereales = cereales;
	}

	public double getGradosAlcohol() {
		return gradosAlcohol;
	}

	public void setGradosAlcohol(double gradosAlcohol) {
		this.gradosAlcohol = gradosAlcohol;
	}
	
	@Override
	public String toString() {
		return "Cerveza: origen=" + origen + ", cereales=" + cereales + ", gradosAlcohol=" + gradosAlcohol +", "+super.toString();
	}

	@Override
	public void visualizarArticulo() {
		System.out.println(super.toString());
		
	}

	@Override
	public boolean saludable() {
		return false;
	}

	@Override
	public double precioTotal() {
		double precioTotal=0.0;
		precioTotal=this.getStock()*this.getPrecio();
		return precioTotal;
	}
	

	
	
}

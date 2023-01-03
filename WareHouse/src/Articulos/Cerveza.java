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

	
	
	
}

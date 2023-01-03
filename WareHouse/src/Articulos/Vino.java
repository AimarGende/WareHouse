package Articulos;

public class Vino extends Articulo {
	private String color;
	private String origen;
	private int anio;
	private String tipoDeUva;
	private double gradosAlcohol;
	
	public Vino(String code, String nombre, String marca, int capacidadBotella, double precio, int stock, String color,
			String origen, int anio, String tipoDeUva, double gradosAlcohol) {
		super(code, nombre, marca, capacidadBotella, precio, stock);
		this.color = color;
		this.origen = origen;
		this.anio = anio;
		this.tipoDeUva = tipoDeUva;
		this.gradosAlcohol = gradosAlcohol;
	}

	public Vino() {
		super();
	}
	
	
	
	
	
	
}

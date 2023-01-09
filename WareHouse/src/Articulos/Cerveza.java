package Articulos;

public class Cerveza extends Articulo implements Alcoholico {
	private String origen;
	private String cereales;
	private double gradosAlcohol;
	
	public Cerveza(String code, String nombre,String tipo, String marca, int capacidadBotella, double precio, int stock,
			String origen, String cereales, double gradosAlcohol) {
		super(code, nombre, tipo, marca, capacidadBotella, precio, stock);
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
	public void precioTotal() {
		double precioTotal=0.0;
		precioTotal=this.getPrecio()+(this.getPrecio()*21/100)+calcularTasa();
		System.out.println("El precio total del producto despues de todo es el siguiente: "+ precioTotal);
	}
	
	@Override
	public boolean esFuerte() {
		boolean fuerte=false;
		if(this.gradosAlcohol>=7){
			fuerte=true;
		}
		return fuerte;
	}
	
	@Override
	public double calcularTasa() {
		double tasa;
		if(this.esFuerte()) {
			tasa=(this.getCapacidadBotella()*TASA_BEBIDAS_FUERTES)/10000;
		}
		else {
			tasa=(this.getCapacidadBotella()*TASA_BEBIDAS_SUABES)/10000;
		}
		
		return tasa;
	}


	
	
}

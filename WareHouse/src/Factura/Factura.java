package Factura;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
	public final static int IVA=21;
	private int numero;
	private String nombreEmpresa;
	private Date fecha;
	private String concepto;
	private ArrayList<LineaFactura> lineaList;
	public Factura(int numero, String nombreEmpresa, Date fecha, String concepto, ArrayList<LineaFactura> lineaList) {
		this.numero = numero;
		this.nombreEmpresa = nombreEmpresa;
		this.fecha = fecha;
		this.concepto = concepto;
		lineaList= new ArrayList<LineaFactura>();
	}
	
	public Factura() {
		lineaList= new ArrayList<LineaFactura>();
	}
	
	
	
}

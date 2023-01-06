package Almacen;
import Articulos.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Almacen {
	ArrayList<Articulo> articuloList;
	public Almacen(){
		articuloList=new ArrayList<Articulo>();
	}
	
	public void cargarDatos() throws FileNotFoundException {
		File file=new File("Datos/articulos.txt");
		Scanner scan=new Scanner(file);
		String[] partes;
		while(scan.hasNextLine()) {
			partes=scan.nextLine().split(";");
			if(partes[2].equals("refresco")) {
				Refresco refres=new Refresco(partes[0], partes[1], partes[2], partes[3],Integer.parseInt(partes[4]), Double.parseDouble(partes[5]), Integer.parseInt(partes[6]), partes[7], Boolean.parseBoolean(partes[8]), Boolean.parseBoolean(partes[9]),Integer.parseInt(partes[10]));
				articuloList.add(refres);
			}else if(partes[2].equals("vino")) {
				Vino vin=new Vino(partes[0], partes[1], partes[2], partes[3],Integer.parseInt(partes[4]), Double.parseDouble(partes[5]), Integer.parseInt(partes[6]), partes[7], partes[8], Integer.parseInt(partes[9]), partes[10], Double.parseDouble(partes[11]));
				articuloList.add(vin);
			}else if(partes[2].equals("cerveza")){
				Cerveza cerv=new Cerveza(partes[0], partes[1], partes[2], partes[3],Integer.parseInt(partes[4]), Double.parseDouble(partes[5]), Integer.parseInt(partes[6]), partes[7], partes[8], Double.parseDouble(partes[9]));
				articuloList.add(cerv);
			}
		}
	}
}

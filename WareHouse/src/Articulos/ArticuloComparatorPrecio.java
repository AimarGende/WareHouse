package Articulos;

import java.util.Comparator;

public class ArticuloComparatorPrecio implements Comparator<Articulo>{

	@Override
	public int compare(Articulo o1, Articulo o2) {
		int i=0;
		if(o1.getPrecio()<o2.getPrecio()) {
			i=-1;
		}
		if(o1.getPrecio()>o2.getPrecio()) {
			i=1;
		}
		if(o1.getPrecio()==o2.getPrecio()) {
			i=0;
		}
		return i;
	}

}

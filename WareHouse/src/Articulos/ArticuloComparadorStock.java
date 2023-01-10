package Articulos;

import java.util.Comparator;

public class ArticuloComparadorStock implements Comparator<Articulo>{

	@Override
	public int compare(Articulo o1, Articulo o2) {
		int i=0;
		if(o1.getStock()<o2.getStock()) {
			i=-1;
		}
		if(o1.getStock()>o2.getStock()) {
			i=1;
		}
		if(o1.getStock()==o2.getStock()) {
			i=0;
		}
		return i;
	}

}

package PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class OrdenarPorNumeroCapitulos implements Comparator<Temporada> {

	@Override
	public int compare(Temporada o1, Temporada o2) {
		if(o1==null || o2==null)
			return -1;
		return -o2.getNumeroCapitulos()-o1.getNumeroCapitulos();//no recuerdo si ten�a el simbolo menos o no, pq lo cammbi�n en clase, pero en mi caso lo necesita para ordenar correctamente
	}

}

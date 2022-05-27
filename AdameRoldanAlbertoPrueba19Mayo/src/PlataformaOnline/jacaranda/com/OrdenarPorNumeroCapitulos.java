package PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class OrdenarPorNumeroCapitulos implements Comparator<Temporada> {

	@Override
	public int compare(Temporada o1, Temporada o2) {
		if(o1==null || o2==null)
			return -1;
		return o1.getNumeroCapitulos()-o2.getNumeroCapitulos();
	}

}

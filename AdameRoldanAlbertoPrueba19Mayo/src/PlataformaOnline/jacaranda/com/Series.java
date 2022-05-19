package PlataformaOnline.jacaranda.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Series {

	private HashMap<String, Serie> mapSeries;

	/**
	 * Crea el objeto que nos servirá para tener las series
	 */
	public Series() {
		mapSeries = new HashMap<String, Serie>();
	}

	/**
	 * Añade una serie a la lista de series. Si existe una serie con el mismo nombre
	 * lanza una excpetion
	 * 
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirSerie(String nombreSerie, int anno, Tema tema) throws SerieException {
		if (mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("Ya existe esa serie");
		}
		Serie serie = new Serie(nombreSerie, anno, tema);
		mapSeries.put(serie.getNombreSerie(), serie);
	}

	/**
	 * Añade una temporada a la Serie cuyo nombre se le pasa por argumento, si no
	 * existe la Serie lanza una exception
	 * 
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirTemporada(String nombreSerie, String temporada) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.annadirTemporada(temporada);
	}

	/**
	 * Añade un capítulo a la temporada de la Serie cuyo nombre se le pasa por
	 * argumento, si no existe la Serie o la temporada lanza una exception
	 * 
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirCapituloTemporada(String nombreSerie, String temporada, String capitulo) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.annadirCapituloTemporada(temporada, capitulo);

	}

	/**
	 * Valorar una temporada de la Serie cuyo nombre se le pasa por argumento, si no
	 * existe la Serie o la temporada lanza una exception
	 * 
	 * @param serie
	 * @throws SerieException
	 */
	public void valorarTemporada(String nombreSerie, String temporada, int valoracion) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.valorarTemporada(temporada, valoracion);
	}

	/**
	 * Devuelve el número de temporadas que tiene la serie que se pasa por parámetro
	 * Si no existe la serie saltará la excepción.
	 * 
	 * @param nombreSerie
	 * @return
	 * @throws SerieException
	 */

	public int numeroDeTemporadasDeUnaSerie(String nombreSerie) throws SerieException {//////////////////////
		int resultado = -1;
		if (mapSeries.containsKey(nombreSerie)) {
			Serie s = mapSeries.get(nombreSerie);
			resultado = s.numeroTemporadas();
		} else
			throw new SerieException("Esta serie no existe");
//		boolean encontrado = false;
//		Iterator<Serie> siguiente = serie
//		
		return resultado;
	}

	/**
	 * Modifica el tema de una serie. Si no se encuentra la serie o ya tenía ese
	 * tema saltará la excepción.
	 * 
	 * @param nombreSerie
	 * @param nuevoTema
	 * @throws SerieException
	 */
	public void modificarTema(String nombreSerie, Tema nuevoTema) throws SerieException {////////////////////////

		if (mapSeries.containsKey(nombreSerie)) {
			Serie s = mapSeries.get(nombreSerie);
			if (!s.getTema().equals(nuevoTema))
				s.setTema(nuevoTema);

			else {
				throw new SerieException("Esta serie ya tiene este tema.");
			}

		} else
			throw new SerieException("Esta serie no existe");

	}

	/**
	 * Devolverá un listado ordenado de forma creciente por el año de la serie. Para
	 * cada serie se mostrará su nombre, año y número de temporadas. Si no hay
	 * ninguna serie de ese tema saltará la excepción.
	 * 
	 * @param tema
	 * @return
	 * @throws SerieException
	 */
	public String listadoOrdenadoSeriesDeUnTema(Tema tema) throws SerieException {//////////////////
		StringBuilder resultado = new StringBuilder("\nLista creciente de serie por anio\n");
		ArrayList<String> claves = new ArrayList<>(this.mapSeries.keySet());

		Collections.sort(claves);

		for (String l : claves) {
			if (mapSeries.get(l).getTema().equals(tema))
				resultado.append(mapSeries.get(l).getNombreSerie() + ": " + mapSeries.get(l).getAnno() + ", "
						+ mapSeries.get(l).numeroTemporadas() + ".\n");
		}
		return resultado.toString();
	}

	public String imprimirSeries() {///////////////////////////////

		StringBuilder resultado = new StringBuilder();
		ArrayList<String> claves = new ArrayList<>(this.mapSeries.keySet());

		Collections.sort(claves);

		for (String l : claves) {
			resultado.append(l + "," + mapSeries.get(l).getAnno() + "," + mapSeries.get(l).numeroTemporadas() + "\n");
		}

		return resultado.toString();
	}

	public String imprimirTemporada() {
		StringBuilder resultado = new StringBuilder();
		ArrayList<String> claves = new ArrayList<>(this.mapSeries.keySet());

		for (String l : claves) {

			Serie s = mapSeries.get(l);

			resultado.append(mapSeries.get(l).getNombreSerie() + "," + s.imprimirTemporadas());
		}

		return resultado.toString();
	}

	public String imprimirCapitulos() {

		StringBuilder resultado = new StringBuilder();
		ArrayList<String> claves = new ArrayList<>(this.mapSeries.keySet());

		for (String l : claves) {
			Serie s = mapSeries.get(l);

			resultado.append(mapSeries.get(l).getNombreSerie() + "," +s.imprimirCapitulos()+"\n");
		}

		return resultado.toString();
	}
}

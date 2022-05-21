package PlataformaOnline.jacaranda.com;

import java.util.ArrayList;
import java.util.Collections;

public class Serie implements Comparable<Serie>{
	private static final int ANNO_MINIMO = 1900; // Sólo se almacenrará series posteriores a 1900
	private String nombreSerie; // Nombre de la serie
	private int anno; // Año de la primera temporada de la serie
	private Tema tema; // Tema de la serie
	private ArrayList<Temporada> temporadas; // Lista de las temporadas de las series.

	/**
	 * Constructor que recibe el nombre de la serie, el año de creación y el tema.
	 * Se crea la serie sin ninguna temporada
	 * 
	 * @param nombreSerie
	 * @param anno
	 * @param tema
	 * @throws SerieException: si el año es anterior a 1900 se lanzará una exception
	 */
	public Serie(String nombreSerie, int anno, Tema tema) throws SerieException {
		super();
		this.nombreSerie = nombreSerie;
		setAnno(anno);
		this.tema = tema;
		temporadas = new ArrayList<Temporada>();
	}

	/**
	 * Añade una nueva temporada. Se le pasará el nombre de la nueva temporada y se
	 * añadirá al final. Debe comprobar que no existe un temporada con ese nombre en
	 * cuyo caso saltará la excepción.
	 * 
	 * @param nombreTemporada
	 * @throws SerieException
	 */
	public void annadirTemporada(String nombreTemporada) throws SerieException {//////////////////////////////////////
		Temporada t = new Temporada(nombreTemporada);
		if (!temporadas.contains(t)) {
			
			temporadas.add(t);
		}

		else {
			throw new SerieException("Esta temporada ya existe");
		}

	}

	/**
	 * Añade un nuevo capítulo a una temporada. Se le pasará el nombre de la
	 * temporada y si la temporada no existe se lanzará una exception
	 * 
	 * @param nombreTemporada
	 * @param nombreCapitulo
	 * @throws SerieException
	 */
	public void annadirCapituloTemporada(String nombreTemporada, String nombreCapitulo) throws SerieException {
		Temporada temporada = new Temporada(nombreTemporada);
		int pos = temporadas.indexOf(temporada);
		if (pos == -1) {
			throw new SerieException("No existe la temporada");
		}
		temporadas.get(pos).annadirCapitulo(nombreCapitulo);
	}

	/**
	 * Valorar temporada. Si no exsite la temporada lanza una exception.
	 * 
	 * @param nombreTemporada
	 * @param valoracion
	 * @throws SerieException
	 */

	public void valorarTemporada(String nombreTemporada, int valoracion) throws SerieException {
		Temporada temporada = new Temporada(nombreTemporada);
		int pos = temporadas.indexOf(temporada);
		if (pos == -1) {
			throw new SerieException("No existe la temporada");
		}
		temporadas.get(pos).valorar(valoracion);

	}

	/**
	 * Devuelve un listado de las temporadas de una serie ordenadas de mayor a menor
	 * por nota media. De cada temporada se mostrará el nombre, número de capítulos
	 * y nota media
	 * 
	 * @return
	 */
	public String listadoTemporadasPorNotaMedia() {////////////////////////
		Collections.sort(temporadas);
		StringBuilder resultado = new StringBuilder("\nTemporadas ordenadas por media\n");
		for (Temporada t : temporadas) {
			resultado.append(t.getNombreTemporada() + ", " + t.getNumeroCapitulos() + " y " + t.getNotaMedia() + "\n");//hemos a�adido el \n
		}
		return resultado.toString();
	}

	/**
	 * Devuelve un listado de las temporadas de una serie ordenadas de menor a mayor
	 * por número de capítulos. De cada temporada se mostrará el nombre, número de
	 * capítulos y nota media.
	 * 
	 * @return
	 */
	public String listadoTemporadasPorNumeroDeCapitulos() {///////////////////////
		OrdenarPorNumeroCapitulos ordenar = new OrdenarPorNumeroCapitulos();
		Collections.sort(temporadas, ordenar);
		StringBuilder resultado = new StringBuilder("\nTemporadas ordenadas por numero capitulos descentende\n");
		for (Temporada t : temporadas) {
			resultado.append(t.getNombreTemporada() + ", " + t.getNumeroCapitulos() + " y " + t.getNotaMedia()+"\n");//hemos a�adido el \n
		}
		return resultado.toString();
	}

	/**
	 * Devuelve el nombre de la Serie
	 * 
	 * @return
	 */
	public String getNombreSerie() {
		return nombreSerie;
	}

	/**
	 * Asigna el nombre de la serie
	 * 
	 * @param nombreSerie
	 */
	public void setNombreSerie(String nombreSerie) {
		this.nombreSerie = nombreSerie;
	}

	/**
	 * Devuelve el año
	 * 
	 * @return
	 */
	public int getAnno() {
		return anno;
	}

	/**
	 * Asinga el año
	 * 
	 * @param anno
	 * @throws SerieException
	 */
	public void setAnno(int anno) throws SerieException {
		if (anno < ANNO_MINIMO) {
			throw new SerieException("Anno incorrecto");
		}
		this.anno = anno;
	}

	/**
	 * Devuelve el tema
	 * 
	 * @return
	 */
	public Tema getTema() {
		return tema;
	}

	/**
	 * Asinga el tema
	 * 
	 * @param tema
	 */
	public void setTema(Tema tema) {
		this.tema = tema;
	}

	/**
	 * Devuelve el número de temporadas que tiene la serie
	 * 
	 * @return
	 */
	public int numeroTemporadas() {
		return temporadas.size();
	}

	/**
	 * toString
	 */
	public String toString() {
		return "Serie " + nombreSerie + " Anno " + anno + " Tema " + tema + "Numero temporadadas " + numeroTemporadas();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreSerie == null) ? 0 : nombreSerie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		if (nombreSerie == null) {
			if (other.nombreSerie != null)
				return false;
		} else if (!nombreSerie.equals(other.nombreSerie))
			return false;
		return true;
	}

	public Temporada buscarTemporada(Temporada temporada) throws SerieException {/////////////////////////
		Temporada t = null;
		if (temporadas.contains(temporada)) {
			t = temporadas.get(temporadas.indexOf(temporada));
		} else
			throw new SerieException("Esta temporada no existe");

		return t;
	}

	@Override
	public int compareTo(Serie o) {/////////////////
		if(o==null)
			return -1;
		return o.anno-this.anno;//est� bien de esta forma, no recuerdo como lo ten�a, pq lo cambi� en clase mientras corregia
	}

	public String imprimirTemporadas() {
		StringBuilder resultado = new StringBuilder();
		for(Temporada t : temporadas) {
			resultado.append(this.nombreSerie + ", " + t.getNombreTemporada() + "," +t.getNumeroOpiniones() + ","+ t.getSumaOpiniones() + "," + t.getNumeroOpiniones()+"\n");
		}
		resultado.append("\n");
		return resultado.toString();
	}
	
	public String imprimirCapitulos() {
		StringBuilder resultado = new StringBuilder();
		for(Temporada t : temporadas) {

			resultado.append(t.imprimirCapitulos(this.nombreSerie));
		}

		return resultado.toString();
	}
	

	

}

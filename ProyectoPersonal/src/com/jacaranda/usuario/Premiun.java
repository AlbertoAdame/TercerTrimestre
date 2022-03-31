package com.jacaranda.usuario;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Premiun extends Usuario {

	private int numeroImagenesPublicadas;
	private List<Imagen> album;

	public Premiun(String login, String pass) {
		super(login, pass);
		this.numeroImagenesPublicadas = 0;
		this.album = new LinkedList<>();

	}

	public int getNumeroImagenesPublicadas() {
		return numeroImagenesPublicadas;
	}


	private boolean existeImagen(String titulo) {
		boolean resultado = false;
		Iterator<Imagen> siguiente = album.iterator();
		while (siguiente.hasNext() && !resultado) {
			Imagen i = siguiente.next();
			if (i.getTitulo().equalsIgnoreCase(titulo))
				resultado = true;
		}
		return resultado;
	}

	public boolean addImagen(String titulo) throws PremiunException {
		boolean resultado = false;
		if (titulo == null)
			throw new PremiunException("Error.El titulo es nulo");
		Imagen i;
		try {
			i = new Imagen(titulo);
		} catch (ImagenException e) {
			throw new PremiunException(e.getMessage());
		}

		if (existeImagen(titulo))
			throw new PremiunException("Esta imagen ya existe.");
		if (!album.add(i))
			throw new PremiunException("No se pudo subir la imagen");
		return resultado;
	}

	public boolean borrarImagen(String titulo) throws PremiunException {
		if (titulo == null)
			throw new PremiunException("Este titulo es nulo");

		Iterator<Imagen> siguiente = album.iterator();
		boolean encontrado = false;
		while (siguiente.hasNext() && !encontrado) {
			Imagen i = siguiente.next();
			if (i.getTitulo().equalsIgnoreCase(titulo)) {
				this.album.remove(i);
				encontrado = true;
			}

		}
		return encontrado;

	}

	public void darLike(String titulo) throws PremiunException {
//		if (titulo == null)
//			throw new PremiunException("Este titulo es nulo");
//		Iterator<Imagen> siguiente = album.iterator();
//		boolean encontrado = false;
//		while (siguiente.hasNext() && !encontrado) {
//			Imagen i = siguiente.next();
//			if (i.getTitulo().equalsIgnoreCase(titulo)) {
//				this.album.remove(i);
//				encontrado = true;
//			}
//		}
	}
	
//	public String verTodasImagenes() throws PremiunException {
//		String resultado = "";
//		Iterator<Imagen> siguiente = this.album.iterator();
//		while (siguiente.hasNext()) {
//			Imagen i = siguiente.next();
//			if (i.getNombre().equalsIgnoreCase(nombre)) {
//				resultado = i.toString();
//
//			}
//
//		}
//		return resultado;
//	}
	
	
	public String verTodasImagenes() {
		StringBuilder resultado = new StringBuilder("Listado Imagenes");

		Iterator<Imagen> siguiente = this.album.iterator();
		while (siguiente.hasNext()) {
			Imagen imagen = siguiente.next();
			resultado.append(imagen.getTitulo() + imagen.getLikes() + imagen.getFechaSubida() + "\n");
		}
		return resultado.toString();
	}

	@Override
	public String toString() {
		return "Premiun [numeroImagenesPublicadas=" + numeroImagenesPublicadas + ", " + super.toString()
				+ "]";
	}
	
	
	
	
}

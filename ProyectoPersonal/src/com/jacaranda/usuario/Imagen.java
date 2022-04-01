package com.jacaranda.usuario;

import java.time.LocalDate;
import java.util.Objects;

public class Imagen {

	private String titulo;
	private LocalDate fechaSubida;
	private int likes;

	public Imagen(String titulo) throws ImagenException {
		super();
		setTitulo(titulo);
		this.fechaSubida = LocalDate.now();
		this.likes = 0;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws ImagenException {
		if (titulo == null)
			throw new ImagenException("Error. El titulo es nulo.");
		this.titulo = titulo;
	}

	public LocalDate getFechaSubida() {
		return fechaSubida;
	}

	public int getLikes() {
		return likes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imagen other = (Imagen) obj;
		return Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return titulo + ", " + fechaSubida + ", likes= " + likes + "]";
	}

}

package com.jacaranda.mensaje;

import java.time.LocalDateTime;
import java.util.Objects;

public class Mensaje implements Comparable<Mensaje> {

	private String remitente;
	private String mensaje;
	private String destinatario;
	private LocalDateTime fecha;
	private int numero;
	private static int numeroSiguiente = 1;

	public Mensaje(String remitente, String mensaje, String destinatario) {
		super();
		this.remitente = remitente;
		this.mensaje = mensaje;
		this.destinatario = destinatario;
		this.fecha = LocalDateTime.now();
		this.numero = numeroSiguiente++;
	}

	public String getRemitente() {
		return remitente;
	}

	public String getMensaje() {
		return mensaje;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, remitente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensaje other = (Mensaje) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(remitente, other.remitente);
	}

	@Override
	public String toString() {
		return "Mensaje [remitente=" + remitente + ", mensaje=" + mensaje + ", fecha=" + fecha + "]";
	}

	@Override
	public int compareTo(Mensaje o) {

		return this.remitente.compareTo(o.remitente);
	}

}

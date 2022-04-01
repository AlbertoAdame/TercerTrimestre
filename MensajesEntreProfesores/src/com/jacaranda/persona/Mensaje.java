package com.jacaranda.persona;

import java.time.LocalDateTime;
import java.util.Objects;

public class Mensaje {
	
	private String remitente;
	private String destinatario;
	private String mensaje;
	private LocalDateTime fechaHora;
	private int numero;
	private int numeroSiguiente=1;
	
	
	public Mensaje(String remitente, String mensaje, String destinatario) {
		super();
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.mensaje = mensaje;
		this.fechaHora = LocalDateTime.now();
		this.numero=numeroSiguiente++;
	}

	public String getRemitente() {
		return remitente;
	}

	public String getMensaje() {
		return mensaje;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaHora, mensaje);
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
		return Objects.equals(fechaHora, other.fechaHora) && Objects.equals(mensaje, other.mensaje);
	}

	@Override
	public String toString() {
		return "Mensaje: "+ mensaje + "De: "+ remitente + "Texto: textoMensaje\n"
				+ " Fecha y hora: "+ fechaHora;
				
			
	}
	
	
	
	
}

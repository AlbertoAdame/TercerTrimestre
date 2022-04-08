package com.jacaranda.empleado;

import java.util.Objects;

public class Empleado {

	private int numeroEmp;
	private String nombreEmp;
	private int mesesTrabajados;
	private char directivo;

	public Empleado(int numeroEmp, String nombreEmp, int mesesTrabajados, char directivo) throws EmpleadoException {
		super();
		setNumeroEmp(numeroEmp);
		setNombreEmp(nombreEmp);
		setMesesTrabajados(mesesTrabajados);
		setDirectivo(directivo);
	}

	public String asignarPrima() {
		String resultado = "";
		if (this.mesesTrabajados >= 12 && directivo == '+')
			resultado = "P1";
		else if (this.mesesTrabajados >= 12 && directivo == '-')
			resultado = "P2";

		else if (this.mesesTrabajados < 12 && directivo == '+')
			resultado = "P3";

		else
			resultado = "P4";

		return resultado;

	}

	public int getNumeroEmp() {
		return numeroEmp;
	}

	private void setNumeroEmp(int numeroEmp) throws EmpleadoException {

		if (numeroEmp < 0 || numeroEmp > 999 || numeroEmp == 000)
			throw new EmpleadoException("Numero empleado no válido.");
		this.numeroEmp = numeroEmp;
	}

	public String getNombreEmp() {
		return nombreEmp;
	}

	private void setNombreEmp(String nombreEmp) throws EmpleadoException {
		if (nombreEmp == null)
			throw new EmpleadoException("Nombre empleado no puede ser nulo");
		if (nombreEmp.length() > 10)
			throw new EmpleadoException("No puede tener más de 10 carácteres.");

		this.nombreEmp = nombreEmp;
	}

	public int getMesesTrabajados() {
		return mesesTrabajados;
	}

	public void setMesesTrabajados(int mesesTrabajados) throws EmpleadoException {
		if (mesesTrabajados < 0) {
			throw new EmpleadoException("Los meses trabajados no pueden ser negativos");
		}
		this.mesesTrabajados = mesesTrabajados;
	}

	public char getDirectivo() {
		return directivo;
	}

	public void setDirectivo(char directivo) throws EmpleadoException {
		if (directivo != '+' || directivo != '-')
			throw new EmpleadoException("Caracter no válido");
		this.directivo = directivo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroEmp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return numeroEmp == other.numeroEmp;
	}

	@Override
	public String toString() {
		return "Empleado numero=" + numeroEmp + ", Nombre=" + nombreEmp + ", mesesTrabajados=" + mesesTrabajados
				+ ", directivo=" + directivo;
	}
	
	

}

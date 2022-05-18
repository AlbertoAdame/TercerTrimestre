package com.jacaranda.equipo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import com.jacaranda.alumno.Alumno;

public class Equipo {

	private String nombreEquipo;
	private Set<Alumno> alumnos;

	public Equipo(String equipo) throws EquipoException {
		super();
		setEquipo(equipo);
		
		this.alumnos = new HashSet<>();
	}

	public String getEquipo() {
		return nombreEquipo;
	}

	private void setEquipo(String equipo) throws EquipoException {
		if (equipo == null || equipo.isBlank())
			throw new EquipoException("Este equipo no es válido.");
		this.nombreEquipo = equipo;
	}

	public void anadirAlumno(Alumno alumno) throws EquipoException {

		if (alumnos.contains(alumno))
			throw new EquipoException("Este alumno ya existe");
		else
			alumnos.add(alumno);

	}

	public String borrarAlumno(Alumno alumno) throws EquipoException {
		boolean encontrado = false;
		if (!alumnos.contains(alumno))
			throw new EquipoException("Este alumno no existe");
		else {
			Iterator<Alumno> siguiente = alumnos.iterator();
			while (siguiente.hasNext() && !encontrado) {
				Alumno a = siguiente.next();
				if (a.equals(alumno)) {
					encontrado = true;
					alumnos.remove(alumno);
				}
			}
		}
		return "Borrado correctamente";

	}

	public Alumno encontrarAlumno(Alumno alumno) {
		boolean encontrado = false;
		Alumno resultado = null;
		if (!alumnos.contains(alumno))
			encontrado = true;
		else {
			Iterator<Alumno> siguiente = alumnos.iterator();
			while (siguiente.hasNext() && !encontrado) {
				Alumno a = siguiente.next();
//				if (a.getDni().equals(alumno.getDni()))
				if (a.equals(alumno)) {
					encontrado = true;
					resultado = a;

				}
			}
		}
		return resultado;
	}
	
	public Equipo unirEquipos(Equipo equipo) throws EquipoException {
		Equipo union = new Equipo("Union del equipo " + this.nombreEquipo + " y " + equipo.nombreEquipo);
		for(Alumno e: equipo.alumnos) {
			union.anadirAlumno(e);
		}
		
		for(Alumno e2: this.alumnos) {
			union.anadirAlumno(e2);
		}
		return union;
	}
	
	public Equipo InterseccionEquipos(Equipo equipo) throws EquipoException {
		Equipo inter = new Equipo("Union del equipo " + this.nombreEquipo + " y " + equipo.nombreEquipo);
		for(Alumno e: equipo.alumnos) {
			if (this.alumnos.contains(e))
				inter.anadirAlumno(e);
		}
		
		
		return inter;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombreEquipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(nombreEquipo, other.nombreEquipo);
	}

	@Override
	public String toString() {
		return "Equipo [nombreEquipo=" + nombreEquipo + ", alumnos=" + alumnos + "]";
	}

}

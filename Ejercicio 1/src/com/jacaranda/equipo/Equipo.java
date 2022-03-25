package com.jacaranda.equipo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.jacaranda.alumno.Alumno;

public class Equipo {
	private String nombre;
	private Set<Alumno> listado;


	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
		this.listado = new HashSet<Alumno>();

	}

	public void addAlumno(Alumno alumno) throws EquipoException {
		if (listado.contains(alumno)) {
			throw new EquipoException("Alumno ya existe");

		}
	}

	public void addAlumno2(Alumno alumno) throws EquipoException {
		if (alumno == null || listado.add(alumno) == false) {
			throw new EquipoException("Alumno nulo o no válido");

		}
	}

	public void addAlumno3(Alumno alumno) throws EquipoException {
		if (alumno == null) {
			throw new EquipoException("Alumno nulo");

		} else if (!listado.add(alumno))
			throw new EquipoException("Este alumno ya existe");
	}

	public void delAlumno(Alumno alumno) {
		this.listado.remove(alumno);
	}

	// para borrar el private hacemos:
	private boolean delUnAlumno(String nombre) {
		
		Iterator<Alumno> siguiente = this.listado.iterator();
		
		boolean encontrado = false;
		while (siguiente.hasNext()) {// ver si tiene siguiente
			Alumno a = siguiente.next();
			if (a.getNombre().equalsIgnoreCase(nombre))
				this.listado.remove(a);
			encontrado = true;
		}
		return encontrado;
	}

	public void delALumno(String nombre) {
		while (delUnAlumno(nombre) == true)
			;
	}

	public void delAlumno(String nombre) {
		Iterator<Alumno> siguiente = this.listado.iterator();
		while (siguiente.hasNext()) {// ver si tiene siguiente
			Alumno a = siguiente.next();
			if (a.getNombre().equalsIgnoreCase(nombre))
				this.listado.remove(a);
		}

//		for(Alumno a: this.listado) {
//			if(a.getNombre().equalsIgnoreCase(nombre))
//				this.listado.remove(a);Este no está bien
//		}
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", listado=" + listado + "]";
	}

	public int numAlumnos() {
		return this.listado.size();
	}

	public Equipo unionEquipo(Equipo e2) {
		Equipo resultado= new Equipo("Union: "+ this.nombre + "+ " + e2.nombre);

		//En resultado tengo todos los alumnos del equipo que lo llama
		for (Alumno a: this.listado) {
			try {
				resultado.addAlumno2(a);
			} catch (Exception e) {
				//e.printStackTrace();La quitamos pq no queremos que nos indique el mensaje, y no pasa nada
			}
			
		}
		for(Alumno a: e2.listado) {
			try {
				resultado.addAlumno2(a);
			} catch (Exception e) {
				//e.printStackTrace();La quitamos pq no queremos que nos indique el mensaje, y no pasa nada

			}
		}
		return resultado;
	}
	
	public Equipo interseccionEquipo(Equipo e2) {
		Equipo resultado = new Equipo ("Interseccion: "+ this.nombre + "+"+ e2.nombre);
		
		for(Alumno a: this.listado) {
			if(e2.listado.contains(a))
				try {
					resultado.addAlumno2(a);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
		}return resultado;
	}
	
}

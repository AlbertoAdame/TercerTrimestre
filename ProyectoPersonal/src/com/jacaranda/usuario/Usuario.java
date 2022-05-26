package com.jacaranda.usuario;

import java.util.Objects;

public abstract class Usuario {

	protected String login;
	private String pass;

	protected Usuario(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
	}

	public String getLogin() {
		return login;
	}
	
	
	

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPass(String pass) {//será public pq necesito cambiar información en el main de las cuentas
		this.pass = pass;
	}

	public boolean cambiarPass(String pass, String nuevaPass) {
		boolean resultado = false;
		if (pass != null && nuevaPass != null) {
			if (this.pass.equals(nuevaPass)) {
				this.pass = pass;
				resultado = true;
			}

		}
		return resultado;

	}

	public boolean iniciarSesion(String contrasenia, String login) {
		boolean resultado = false;
		if ((contrasenia != null && this.pass.equals(contrasenia))
				&& (login != null && this.login.equalsIgnoreCase(login)))
			resultado = true;
		return resultado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(login);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(login, other.login);
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", pass=" + pass + "]";
	}
	
	

}

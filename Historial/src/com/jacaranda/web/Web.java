package com.jacaranda.web;

import java.time.LocalDateTime;
import java.util.Objects;

public class Web {
	
	private String url;
	private LocalDateTime hora;

	public Web(String url) {
		super();
		this.url = url;
		this.hora=LocalDateTime.now();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) throws WebException {
		if (url==null) {
			throw new WebException("Error web nula");
		}
	}

	public LocalDateTime getHora() {
		return hora;
	}


	@Override
	public int hashCode() {
		return Objects.hash(hora, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Web other = (Web) obj;
		return Objects.equals(hora, other.hora) && Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return "\n" + url + ", " + hora;
	}

}
package com.jacaranda.web;

import java.time.LocalDateTime;
import java.util.Objects;

public class Web {

	private String url;
	private LocalDateTime fecha;

	public Web(String url) {
		super();
		this.url = url;
		this.fecha = LocalDateTime.now();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) throws WebException {
		if (url == null || url.isBlank())
			throw new WebException("Esta web es nula o vacía");
		this.url = url;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, url);
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
		return Objects.equals(fecha, other.fecha) && Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return url + ", " + fecha + "\n";
	}

}

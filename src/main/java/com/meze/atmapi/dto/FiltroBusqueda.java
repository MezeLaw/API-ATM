package com.meze.atmapi.dto;

public class FiltroBusqueda {

	private String provincia;
	private String ciudad;
	private String codigoPostal;
	private int extraccionDeseada;

	public FiltroBusqueda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FiltroBusqueda(String provincia, String ciudad, String codigoPostal, int extraccionDeseada) {
		super();
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.extraccionDeseada = extraccionDeseada;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public int getExtraccionDeseada() {
		return extraccionDeseada;
	}

	public void setExtraccionDeseada(int extraccionDeseada) {
		this.extraccionDeseada = extraccionDeseada;
	}

}

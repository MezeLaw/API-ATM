package com.meze.atmapi.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CajeroAutomatico implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("Id")
	private String id;
	@JsonProperty("Name")
	private String nombre;
	@JsonProperty("Hour_Start")
	private String horaInicio;
	@JsonProperty("Hour_End")
	private String horaFin;
	@JsonProperty("Language_List")
	private String listaLenguajes;
	@JsonProperty("Accessibility")
	private boolean accesibilidad;
	@JsonProperty("Amount_Left")
	private int montoDisponible;
	@JsonProperty("ATM_Type")
	private String tipoATM;
	@JsonProperty("Street_Name")
	private String direccionCalle;
	@JsonProperty("Street_Number")
	private String direccionNumero;
	@JsonProperty("City")
	private String ciudad;
	@JsonProperty("State")
	private String provincia;
	@JsonProperty("Zip")
	private String codigoPostal;
	@JsonProperty("Lat")
	private String latitud;
	@JsonProperty("Lng")
	private String longitud;

	public CajeroAutomatico() {

	}

	public CajeroAutomatico(String id, String nombre, String horaInicio, String horaFin, String listaLenguajes,
			boolean accesibilidad, int montoDisponible, String tipoATM, String direccionCalle, String direccionNumero,
			String ciudad, String provincia, String codigoPostal, String latitud, String longitud) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.listaLenguajes = listaLenguajes;
		this.accesibilidad = accesibilidad;
		this.montoDisponible = montoDisponible;
		this.tipoATM = tipoATM;
		this.direccionCalle = direccionCalle;
		this.direccionNumero = direccionNumero;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public String getListaLenguajes() {
		return listaLenguajes;
	}

	public void setListaLenguajes(String listaLenguajes) {
		this.listaLenguajes = listaLenguajes;
	}

	public boolean isAccesibilidad() {
		return accesibilidad;
	}

	public void setAccesibilidad(boolean accesibilidad) {
		this.accesibilidad = accesibilidad;
	}

	public int getMontoDisponible() {
		return montoDisponible;
	}

	public void setMontoDisponible(int montoDisponible) {
		this.montoDisponible = montoDisponible;
	}

	public String getTipoATM() {
		return tipoATM;
	}

	public void setTipoATM(String tipoATM) {
		this.tipoATM = tipoATM;
	}

	public String getDireccionCalle() {
		return direccionCalle;
	}

	public void setDireccionCalle(String direccionCalle) {
		this.direccionCalle = direccionCalle;
	}

	public String getDireccionNumero() {
		return direccionNumero;
	}

	public void setDireccionNumero(String direccionNumero) {
		this.direccionNumero = direccionNumero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

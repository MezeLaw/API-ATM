package com.meze.atmapi.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CajeroAutomatico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/***
	 * 
	 * 
	 * "Id": "S1ABM008D", "Name": "BANCO MACRO", "Hour_Start": "0:00", "Hour_End":
	 * "23:59:59 ", "Language_List": "Español / English", "Accessibility": false,
	 * "Amount_Left": 900000, "ATM_Type": "Solo Extracción", "Street_Name": "PERITO
	 * MORENO 102", "Street_Number": "", "City": "GODOY CRUZ", "State": "MENDOZA",
	 * "Zip": "", "Lat": "-32.927113", "Lng": "-68.78382"
	 * 
	 * 
	 **/

	private String Id;
	private String Name;
	private String Hour_Start;
	private String Hour_End;
	private String Language_List;
	private boolean Accessibility;
	private int Amount_Left;
	private String ATM_Type;
	private String Street_Name;
	private String Street_Number;
	private String City;
	private String State;
	private String Zip;
	private String Lat;
	private String Lng;

	public CajeroAutomatico() {

	}

//	public CajeroAutomatico(String id, String nombre, String horaInicio, String horaFin, String lenguajesLista,
//			boolean accesibilidad, int dineroDisponible, String tipoAtm, String direccionCalle, String direccionNumero,
//			String ciudad, String provincia, String cp, String lat, String lng) {
//		this.Id = id;
//		this.Name = nombre;
//		this.Hour_Start = horaInicio;
//		this.Hour_End = horaFin;
//		this.Language_List = lenguajesLista;
//		this.Accessibility = accesibilidad;
//		this.Amount_Left = dineroDisponible;
//		this.ATM_Type = tipoAtm;
//		this.Street_Name = direccionCalle;
//		this.Street_Number = direccionNumero;
//		this.City = ciudad;
//		this.State = provincia;
//		this.Zip = cp;
//		this.Lat = lat;
//		this.Lng = lng;
//	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getHour_Start() {
		return Hour_Start;
	}

	public void setHour_Start(String hour_Start) {
		Hour_Start = hour_Start;
	}

	public String getHour_End() {
		return Hour_End;
	}

	public void setHour_End(String hour_End) {
		Hour_End = hour_End;
	}

	public String getLanguage_List() {
		return Language_List;
	}

	public void setLanguage_List(String language_List) {
		Language_List = language_List;
	}

	public boolean isAccessibility() {
		return Accessibility;
	}

	public void setAccessibility(boolean accessibility) {
		Accessibility = accessibility;
	}

	public int getAmount_Left() {
		return Amount_Left;
	}

	public void setAmount_Left(int amount_Left) {
		Amount_Left = amount_Left;
	}

	public String getATM_Type() {
		return ATM_Type;
	}

	public void setATM_Type(String aTM_Type) {
		ATM_Type = aTM_Type;
	}

	public String getStreet_Name() {
		return Street_Name;
	}

	public void setStreet_Name(String street_Name) {
		Street_Name = street_Name;
	}

	public String getStreet_Number() {
		return Street_Number;
	}

	public void setStreet_Number(String street_Number) {
		Street_Number = street_Number;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZip() {
		return Zip;
	}

	public void setZip(String zip) {
		Zip = zip;
	}

	public String getLat() {
		return Lat;
	}

	public void setLat(String lat) {
		Lat = lat;
	}

	public String getLng() {
		return Lng;
	}

	public void setLng(String lng) {
		Lng = lng;
	}

}

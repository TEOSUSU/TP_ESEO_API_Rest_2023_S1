package com.dto;

public class Ville {
	
	private String codePostal;
	private String nomCommune;
	private String codeCommune;
	private String libelleAcheminement;
	private String ligne;
	private String longitude;
	private String latitude;
	
	public String getCodePostal() {
		return this.codePostal;
	}
	
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	public String getNomCommune() {
		return this.nomCommune;
	}
	
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}
	
	public String getligne() {
		return this.ligne;
	}
	
	public void setLigne(String ligne) {
		this.ligne = ligne;
	}
	
	public String getCodeCommune() {
		return this.codeCommune;
	}
	
	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}
	
	public String getLibelleAcheminement() {
		return this.libelleAcheminement;
	}
	
	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}
	
	public String getLongitude() {
		return this.longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getLatitude() {
		return this.latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
}

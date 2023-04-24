package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {

	public ArrayList<Ville> findAllVilles();

	public ArrayList<Ville> findAllVillesOrderByName();

	public ArrayList<Ville> findAllVillesOrderByPostalCode();
	
	public Ville getVilleByCodeCommune(String codeCommuneINSEE);

	public void insertVille(Ville ville);

	public void actualiserVilleByCodePostal(Ville ville, String codePostalAModifier);

	public void supprimerVilleByNomAndCode(String codePostals, String codeCommune);

}

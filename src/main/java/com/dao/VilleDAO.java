package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {

	public ArrayList<Ville> findAllVilles();

	public ArrayList<Ville> findAllVillesOrderByName();

	public ArrayList<Ville> findAllVillesOrderByPostalCode();
	
	public Ville getVilleByCodeCommune(String codeCommuneINSEE);

	public void insertVille(String codePostal, String nomCommune, String codeCommune, String libelleAcheminement,
			String ligne, String latitude, String longitude);

	public void actualiserVilleByCodePostal(String codePostal, String nomCommune, String codeCommune,
			String libelleAcheminement, String ligne, String latitude, String longitude, String codePostalAModifier);

	public void supprimerVilleByNomAndCode(String codePostals, String codeCommune);

}

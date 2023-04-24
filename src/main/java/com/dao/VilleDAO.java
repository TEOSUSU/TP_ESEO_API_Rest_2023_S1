package com.dao;

import java.util.List;

import com.dto.Ville;

public interface VilleDAO {

	public List<Ville> findAllVilles();

	public List<Ville> findAllVillesOrderByName();

	public List<Ville> findAllVillesOrderByPostalCode();
	
	public Ville getVilleByCodeCommune(String codeCommuneINSEE);

	public void insertVille(Ville ville);

	public void actualiserVilleByCodePostal(Ville ville, String codePostalAModifier);

	public void supprimerVilleByNomAndCode(String codePostals, String codeCommune);

}

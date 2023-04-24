package com.blo;

import java.util.List;

import com.dto.Ville;

public interface VilleBLO {

	public List<Ville> getInfoVilles(String codePostal);

	public List<Ville> getInfoVilleOrderByName();

	public List<Ville> getInfoVilleOrderByPostalCode();
	
	public Ville getVilleByCodeCommune(String codeCommuneINSEE);

	public void insertVille(Ville ville);

	public void actualiserVilleByCodePostal(Ville ville, String codePostalAModifier);
	
	public void supprimerVilleByNomAndCode(String codePostal, String codeCommune);

}

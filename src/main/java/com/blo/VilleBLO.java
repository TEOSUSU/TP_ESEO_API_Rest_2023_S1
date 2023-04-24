package com.blo;

import java.util.ArrayList;
import com.dto.Ville;

public interface VilleBLO {

	public ArrayList<Ville> getInfoVilles(String codePostal);

	public ArrayList<Ville> getInfoVilleOrderByName();

	public ArrayList<Ville> getInfoVilleOrderByPostalCode();
	
	public Ville getVilleByCodeCommune(String codeCommuneINSEE);

	public void insertVille(Ville ville);

	public void actualiserVilleByCodePostal(Ville ville, String codePostalAModifier);
	
	public void supprimerVilleByNomAndCode(String codePostal, String codeCommune);

}

package com.blo;

import java.util.ArrayList;
import com.dto.Ville;

public interface VilleBLO {

	public ArrayList<Ville> getInfoVilles(String codePostal);

	public ArrayList<Ville> getInfoVilleOrderByName();

	public ArrayList<Ville> getInfoVilleOrderByPostalCode();
	
	public Ville getVilleByCodeCommune(String codeCommuneINSEE);

	public void insertVille(String codePostal, String nomCommune, String codeCommune, String libelleAcheminement,
			String ligne, String longitude, String latitude);

	public void actualiserVilleByCodePostal(Ville ville, String codePostalAModifier);
	
	public void supprimerVilleByNomAndCode(String codePostal, String codeCommune);

}

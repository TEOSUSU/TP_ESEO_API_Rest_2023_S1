package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;

	public ArrayList<Ville> getInfoVilles(String codePostal) {

		ArrayList<Ville> listVille = villeDAO.findAllVilles();
		return listVille;
	}

	public ArrayList<Ville> getInfoVilleOrderByName() {
		return villeDAO.findAllVillesOrderByName();
	}

	public ArrayList<Ville> getInfoVilleOrderByPostalCode() {
		return villeDAO.findAllVillesOrderByPostalCode();
	}

	public Ville getVilleByCodeCommune(String codeCommuneINSEE) {
		return villeDAO.getVilleByCodeCommune(codeCommuneINSEE);
	}

	public void insertVille(String codePostal, String nomCommune, String codeCommune, String libelleAcheminement,
			String ligne, String longitude, String latitude) {
		villeDAO.insertVille(codePostal, nomCommune, codeCommune, libelleAcheminement, ligne, longitude, latitude);
	}

	public void actualiserVilleByCodePostal(String codePostal, String nomCommune, String codeCommune,
			String libelleAcheminement, String ligne, String longitude, String latitude, String codePostalAModifier) {
		villeDAO.actualiserVilleByCodePostal(codePostal, nomCommune, codeCommune, libelleAcheminement, ligne, longitude,
				latitude, codePostalAModifier);
	}

	public void supprimerVilleByNomAndCode(String codePostal, String codeCommune) {
		villeDAO.supprimerVilleByNomAndCode(codePostal, codeCommune);
	}

}

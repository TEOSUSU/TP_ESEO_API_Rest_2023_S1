package com.blo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;

	public List<Ville> getInfoVilles(String codePostal) {
		return villeDAO.findAllVilles();
	}

	public List<Ville> getInfoVilleOrderByName() {
		return villeDAO.findAllVillesOrderByName();
	}

	public List<Ville> getInfoVilleOrderByPostalCode() {
		return villeDAO.findAllVillesOrderByPostalCode();
	}

	public Ville getVilleByCodeCommune(String codeCommuneINSEE) {
		return villeDAO.getVilleByCodeCommune(codeCommuneINSEE);
	}

	public void insertVille(Ville ville) {
		villeDAO.insertVille(ville);
	}

	public void actualiserVilleByCodePostal(Ville ville, String codePostalAModifier) {
		villeDAO.actualiserVilleByCodePostal(ville, codePostalAModifier);
	}

	public void supprimerVilleByNomAndCode(String codePostal, String codeCommune) {
		villeDAO.supprimerVilleByNomAndCode(codePostal, codeCommune);
	}

}

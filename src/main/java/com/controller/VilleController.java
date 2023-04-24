package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
public class VilleController {

	@Autowired
	VilleBLO villeBLO;

	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "name") String name,
			@RequestParam(required = false, value = "orderByName") String orderByName,
			@RequestParam(required = false, value = "orderByPostalCode") String orderByPostalCode,
			@RequestParam(required = false, value = "codeCommuneINSEE") String codeCommuneINSEE) {
		ArrayList<Ville> villeList = new ArrayList<>();

		if (name != null) {
			villeList = villeBLO.getInfoVilles(name);
		}
		if (orderByName != null && orderByName.equals("yes")) {
			villeList = villeBLO.getInfoVilleOrderByName();
		}
		if (orderByPostalCode != null && orderByPostalCode.equals("yes")) {
			villeList = villeBLO.getInfoVilleOrderByPostalCode();
		}if (codeCommuneINSEE != null) {
			villeList.add(villeBLO.getVilleByCodeCommune(codeCommuneINSEE));
		} else {
			villeList = villeBLO.getInfoVilles(name);
		}

		return villeList;
	}

	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	@ResponseBody
	public void appelPost(@RequestParam(required = false, value = "codePostal") String codePostal,
			@RequestParam(required = false, value = "nomCommune") String nomCommune,
			@RequestParam(required = false, value = "codeCommune") String codeCommune,
			@RequestParam(required = false, value = "libelleAcheminement") String libelleAcheminement,
			@RequestParam(required = false, value = "ligne") String ligne,
			@RequestParam(required = false, value = "longitude") String longitude,
			@RequestParam(required = false, value = "latitude") String latitude) {
		villeBLO.insertVille(codePostal, nomCommune, codeCommune, libelleAcheminement, ligne, longitude, latitude);
	}

	@RequestMapping(value = "/ville", method = RequestMethod.PUT)
	@ResponseBody
	public void appelPut(@RequestParam(required = false, value = "codePostal") String codePostal,
			@RequestParam(required = false, value = "nomCommune") String nomCommune,
			@RequestParam(required = false, value = "codeCommune") String codeCommune,
			@RequestParam(required = false, value = "libelleAcheminement") String libelleAcheminement,
			@RequestParam(required = false, value = "ligne") String ligne,
			@RequestParam(required = false, value = "longitude") String longitude,
			@RequestParam(required = false, value = "latitude") String latitude,
			@RequestParam(required = false, value = "codePostalActualiser") String codePostalAActualiser) {
		villeBLO.actualiserVilleByCodePostal(codePostal, nomCommune, codeCommune, libelleAcheminement, ligne, longitude,
				latitude, codePostalAActualiser);
	}

	@RequestMapping(value = "/ville", method = RequestMethod.DELETE)
	@ResponseBody
	public void appelDelete(@RequestParam(required = false, value = "codePostal") String codePostal,
			@RequestParam(required = false, value = "codeCommune") String codeCommune) {
		villeBLO.supprimerVilleByNomAndCode(codePostal, codeCommune);
	}

}

package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	private DaoFactory daoFactory = DaoFactory.getInstance();

	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> listVille = new ArrayList<Ville>();

		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM ville_france");
			resultat = statement.executeQuery();

			while (resultat.next()) {
				String codeCommune = resultat.getString("Code_commune_INSEE");
				String nomCommune = resultat.getString("Nom_commune");
				String codePostal = resultat.getString("Code_postal");
				String libelleAcheminement = resultat.getString("Libelle_acheminement");
				String ligne5 = resultat.getString("ligne_5");
				String latitude = resultat.getString("latitude");
				String longitude = resultat.getString("longitude");

				Ville ville = new Ville();
				ville.setCodeCommune(codeCommune);
				ville.setNomCommune(nomCommune);
				ville.setCodePostal(codePostal);
				ville.setLibelleAcheminement(libelleAcheminement);
				ville.setLigne(ligne5);
				ville.setLatitude(latitude);
				ville.setLongitude(longitude);

				listVille.add(ville);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listVille;
	}

}

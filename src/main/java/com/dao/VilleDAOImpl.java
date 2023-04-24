package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	private DaoFactory daoFactory = DaoFactory.getInstance();
	private static final Logger logger = LoggerFactory.getLogger(DaoFactory.class);

	private void loggerError(SQLException e) {
		logger.error("Erreur lors de l'exécution", e);
	}

	private void finallyGetCatchBlock(PreparedStatement statement, Connection connexion, ResultSet resultat) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				loggerError(e);
			}
		}
		if (connexion != null) {
			try {
				connexion.close();
			} catch (SQLException e) {
				loggerError(e);
			}
		}
		if (resultat != null) {
			try {
				resultat.close();
			} catch (SQLException e) {
				loggerError(e);
			}
		}
	}

	private void finallyNotGetCatchBlock(PreparedStatement statement, Connection connexion) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				loggerError(e);
			}
		}
		if (connexion != null) {
			try {
				connexion.close();
			} catch (SQLException e) {
				loggerError(e);
			}
		}
	}

	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> listVille = new ArrayList<>();
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			try {
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
				loggerError(e);
			}
		} catch (SQLException e) {
			loggerError(e);
		} finally {
			finallyGetCatchBlock(statement, connexion, resultat);
		}
		return listVille;
	}

	public ArrayList<Ville> findAllVillesOrderByName() {
		ArrayList<Ville> listVille = new ArrayList<Ville>();

		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			try {
				statement = connexion.prepareStatement("SELECT * FROM ville_france ORDER BY Nom_commune");
				resultat = statement.executeQuery();

				while (resultat.next()) {
					String codeCommune = resultat.getString("Code_commune_INSEE");
					String nomCommune = resultat.getString("Nom_commune");
					String codePostal = resultat.getString("Code_postal");
					String libelleAcheminement = resultat.getString("Libelle_acheminement");
					String ligne5 = resultat.getString("Ligne_5");
					String latitude = resultat.getString("Latitude");
					String longitude = resultat.getString("Longitude");

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
				loggerError(e);
			}
		} catch (SQLException e) {
			loggerError(e);
		} finally {
			finallyGetCatchBlock(statement, connexion, resultat);
		}
		return listVille;
	}

	public Ville getVilleByCodeCommune(String codeCommuneINSEE) {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null;

		Ville ville = new Ville();

		try {
			connexion = daoFactory.getConnection();
			try {
				statement = connexion.prepareStatement("SELECT * FROM ville_france WHERE Code_commune_INSEE = ?");
				statement.setString(1, codeCommuneINSEE);
				resultat = statement.executeQuery();

				while (resultat.next()) {
					String codeCommune = resultat.getString("Code_commune_INSEE");
					String nomCommune = resultat.getString("Nom_commune");
					String codePostal = resultat.getString("Code_postal");
					String libelleAcheminement = resultat.getString("Libelle_acheminement");
					String ligne5 = resultat.getString("Ligne_5");
					String latitude = resultat.getString("Latitude");
					String longitude = resultat.getString("Longitude");

					ville.setCodeCommune(codeCommune);
					ville.setNomCommune(nomCommune);
					ville.setCodePostal(codePostal);
					ville.setLibelleAcheminement(libelleAcheminement);
					ville.setLigne(ligne5);
					ville.setLatitude(latitude);
					ville.setLongitude(longitude);
				}
			} catch (SQLException e) {
				loggerError(e);
			}
		} catch (SQLException e) {
			loggerError(e);
		} finally {
			finallyGetCatchBlock(statement, connexion, resultat);
		}
		return ville;
	}

	public ArrayList<Ville> findAllVillesOrderByPostalCode() {
		ArrayList<Ville> listVille = new ArrayList<Ville>();

		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			try {
				statement = connexion.prepareStatement("SELECT * FROM ville_france ORDER BY Code_Postal ASC");
				resultat = statement.executeQuery();

				while (resultat.next()) {
					String codeCommune = resultat.getString("Code_commune_INSEE");
					String nomCommune = resultat.getString("Nom_commune");
					String codePostal = resultat.getString("Code_postal");
					String libelleAcheminement = resultat.getString("Libelle_acheminement");
					String ligne5 = resultat.getString("Ligne_5");
					String latitude = resultat.getString("Latitude");
					String longitude = resultat.getString("Longitude");

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
				loggerError(e);
			}
		} catch (SQLException e) {
			loggerError(e);
		} finally {
			finallyGetCatchBlock(statement, connexion, resultat);
		}
		return listVille;
	}

	public void insertVille(String codePostal, String nomCommune, String codeCommune, String libelleAcheminement,
			String ligne, String latitude, String longitude) {
		Connection connexion = null;
		PreparedStatement statement = null;

		try {
			connexion = daoFactory.getConnection();
			try {
				statement = connexion.prepareStatement(
						"INSERT INTO ville_france (Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude) "
								+ "VALUES (?, ?, ?, ?, ?, ?, ?);");
				statement.setString(1, codeCommune);
				statement.setString(2, nomCommune);
				statement.setString(3, codePostal);
				statement.setString(4, libelleAcheminement);
				statement.setString(5, ligne);
				statement.setString(6, latitude);
				statement.setString(7, longitude);
				statement.executeUpdate();
			} catch (SQLException e) {
				loggerError(e);
			}
		} catch (SQLException e) {
			loggerError(e);
		} finally {
			finallyNotGetCatchBlock(statement, connexion);
		}
	}

	public void actualiserVilleByCodePostal(String codePostal, String nomCommune, String codeCommune,
			String libelleAcheminement, String ligne, String latitude, String longitude, String codePostalAModifier) {
		Connection connexion = null;
		PreparedStatement statement = null;

		try {
			connexion = daoFactory.getConnection();
			try {
				statement = connexion.prepareStatement(
						"UPDATE ville_france SET Code_commune_INSEE=?, Nom_commune=?, Code_postal=?, Libelle_acheminement=?, Ligne_5=?, Latitude=?, Longitude=? WHERE Code_postal=?;");
				statement.setString(1, codeCommune);
				statement.setString(2, nomCommune);
				statement.setString(3, codePostal);
				statement.setString(4, libelleAcheminement);
				statement.setString(5, ligne);
				statement.setString(6, latitude);
				statement.setString(7, longitude);
				statement.setString(8, codePostalAModifier);
				statement.executeUpdate();

			} catch (SQLException e) {
				loggerError(e);
			}
		} catch (SQLException e) {
			loggerError(e);
		} finally {
			finallyNotGetCatchBlock(statement, connexion);
		}
	}

	public void supprimerVilleByNomAndCode(String codePostal, String codeCommune) {
		Connection connexion = null;
		PreparedStatement statement = null;

		try {
			connexion = daoFactory.getConnection();
			try {
				statement = connexion
						.prepareStatement("DELETE FROM ville_france WHERE Code_postal=? AND Code_commune_INSEE=?");
				statement.setString(1, codePostal);
				statement.setString(2, codeCommune);
				statement.executeUpdate();
			} catch (SQLException e) {
				loggerError(e);
			}
		} catch (SQLException e) {
			loggerError(e);
		} finally {
			finallyNotGetCatchBlock(statement, connexion);
		}
	}

}

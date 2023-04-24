package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		finallyNotGetCatchBlock(statement, connexion);
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

	private Ville getStringVille(ResultSet resultat, Ville ville) throws SQLException {
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

		return ville;
	}

	public List<Ville> findAllVilles() {
		List<Ville> listVille = new ArrayList<>();
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			findAllVillesStatement(statement, connexion, resultat, listVille);
		} catch (SQLException e) {
			loggerError(e);
		} finally {
			finallyGetCatchBlock(statement, connexion, resultat);
		}
		return listVille;
	}

	public List<Ville> findAllVillesOrderByName() {
		List<Ville> listVille = new ArrayList<>();

		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			findAllVilleOrderByNameStatement(statement, connexion, resultat, listVille);
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
			findAllVilleOrderByCodeCommuneStatement(statement, connexion, resultat, ville, codeCommuneINSEE);
		} catch (SQLException e) {
			loggerError(e);
		} finally {
			finallyGetCatchBlock(statement, connexion, resultat);
		}
		return ville;
	}

	public List<Ville> findAllVillesOrderByPostalCode() {
		List<Ville> listVille = new ArrayList<>();

		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			findAllVilleOrderByCodePostalStatement(statement, connexion, resultat, listVille);
		} catch (SQLException e) {
			loggerError(e);
		} finally {
			finallyGetCatchBlock(statement, connexion, resultat);
		}
		return listVille;
	}

	public void insertVille(Ville ville) {
		Connection connexion = null;
		PreparedStatement statement = null;

		try {
			connexion = daoFactory.getConnection();
			insertVilleStatement(statement, connexion, ville);
		} catch (SQLException e) {
			loggerError(e);
		} finally {
			finallyNotGetCatchBlock(statement, connexion);
		}
	}

	public void actualiserVilleByCodePostal(Ville ville, String codePostalAModifier) {
		Connection connexion = null;
		PreparedStatement statement = null;

		try {
			connexion = daoFactory.getConnection();
			updateVilleStatement(statement, connexion, ville, codePostalAModifier);
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
			deleteVilleStatement(statement, connexion, codePostal, codeCommune);
		} catch (SQLException e) {
			loggerError(e);
		} finally {
			finallyNotGetCatchBlock(statement, connexion);
		}
	}

	private List<Ville> findAllVillesStatement(PreparedStatement statement, Connection connexion,
			ResultSet resultat, List<Ville> listVille) {
		try {
			statement = connexion.prepareStatement("SELECT * FROM ville_france");
			resultat = statement.executeQuery();

			while (resultat.next()) {
				Ville ville = new Ville();
				ville = getStringVille(resultat, ville);
				listVille.add(ville);
			}
		} catch (SQLException e) {
			loggerError(e);
		}
		return listVille;
	}

	private List<Ville> findAllVilleOrderByNameStatement(PreparedStatement statement, Connection connexion,
			ResultSet resultat, List<Ville> listVille) {
		try {
			statement = connexion.prepareStatement("SELECT * FROM ville_france ORDER BY Nom_commune");
			resultat = statement.executeQuery();

			while (resultat.next()) {
				Ville ville = new Ville();
				ville = getStringVille(resultat, ville);
				listVille.add(ville);
			}
		} catch (SQLException e) {
			loggerError(e);
		}
		return listVille;
	}

	private Ville findAllVilleOrderByCodeCommuneStatement(PreparedStatement statement, Connection connexion,
			ResultSet resultat, Ville ville, String codeCommuneINSEE) {
		try {
			statement = connexion.prepareStatement("SELECT * FROM ville_france WHERE Code_commune_INSEE = ?");
			statement.setString(1, codeCommuneINSEE);
			resultat = statement.executeQuery();

			while (resultat.next()) {
				ville = getStringVille(resultat, ville);
			}
		} catch (SQLException e) {
			loggerError(e);
		}
		return ville;
	}

	private List<Ville> findAllVilleOrderByCodePostalStatement(PreparedStatement statement, Connection connexion,
			ResultSet resultat, List<Ville> listVille) {
		try {
			statement = connexion.prepareStatement("SELECT * FROM ville_france ORDER BY Code_Postal ASC");
			resultat = statement.executeQuery();

			while (resultat.next()) {
				Ville ville = new Ville();
				ville = getStringVille(resultat, ville);
				listVille.add(ville);
			}
		} catch (SQLException e) {
			loggerError(e);
		}
		return listVille;
	}

	private void insertVilleStatement(PreparedStatement statement, Connection connexion, Ville ville) {
		try {
			statement = connexion.prepareStatement(
					"INSERT INTO ville_france (Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?);");
			statement.setString(1, ville.getCodeCommune());
			statement.setString(2, ville.getNomCommune());
			statement.setString(3, ville.getCodePostal());
			statement.setString(4, ville.getLibelleAcheminement());
			statement.setString(5, ville.getligne());
			statement.setString(6, ville.getLatitude());
			statement.setString(7, ville.getLongitude());
			statement.executeUpdate();
		} catch (SQLException e) {
			loggerError(e);
		}
	}

	private void updateVilleStatement(PreparedStatement statement, Connection connexion, Ville ville,
			String codePostalAModifier) {
		try {
			statement = connexion.prepareStatement(
					"UPDATE ville_france SET Code_commune_INSEE=?, Nom_commune=?, Code_postal=?, Libelle_acheminement=?, Ligne_5=?, Latitude=?, Longitude=? WHERE Code_postal=?;");
			statement.setString(1, ville.getCodeCommune());
			statement.setString(2, ville.getNomCommune());
			statement.setString(3, ville.getCodePostal());
			statement.setString(4, ville.getLibelleAcheminement());
			statement.setString(5, ville.getligne());
			statement.setString(6, ville.getLatitude());
			statement.setString(7, ville.getLongitude());
			statement.setString(8, codePostalAModifier);
			statement.executeUpdate();

		} catch (SQLException e) {
			loggerError(e);
		}
	}

	private void deleteVilleStatement(PreparedStatement statement, Connection connexion, String codePostal,
			String codeCommune) {
		try {
			statement = connexion
					.prepareStatement("DELETE FROM ville_france WHERE Code_postal=? AND Code_commune_INSEE=?");
			statement.setString(1, codePostal);
			statement.setString(2, codeCommune);
			statement.executeUpdate();
		} catch (SQLException e) {
			loggerError(e);
		}
	}
}

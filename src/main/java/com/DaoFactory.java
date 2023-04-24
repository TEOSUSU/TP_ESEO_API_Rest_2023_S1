package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoFactory {
	private String url;
	private String username;
	private String password;
	private static final Logger logger = LoggerFactory.getLogger(DaoFactory.class);
	
	DaoFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public static DaoFactory getInstance() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error("Erreur lors de l'exécution", e);
		}
		return new DaoFactory("jdbc:mysql://localhost:3306/twic", "root", "");
	}

	public Connection getConnection() throws SQLException {
		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection(url, username, password);
			connexion.setAutoCommit(false);
			
		}catch(SQLException e) {
			logger.error("Erreur lors de l'exécution", e);
		}
		return connexion;
	}

	// Récupération du Dao Ville
	public VilleDAO getVilleDao() {
		return new VilleDAOImpl();
	}
}
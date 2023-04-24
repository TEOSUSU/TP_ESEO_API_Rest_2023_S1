package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
	private String url;
	private String username;
	private String password;

	DaoFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public static DaoFactory getInstance() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return new DaoFactory("jdbc:mysql://localhost:3306/twic", "root", "");
	}

	public Connection getConnection() throws SQLException {
		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection(url, username, password);
			connexion.setAutoCommit(false);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return connexion;
	}

	// Récupération du Dao Ville
	public VilleDAO getVilleDao() {
		return new VilleDAOImpl();
	}
}
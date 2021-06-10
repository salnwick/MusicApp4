package dao;

import java.sql.Connection;

import dao.DBConnection;

public class ArtistsDao {

	private Connection connection;
	
	public ArtistsDao() {
		connection = DBConnection.getInstance().getConnection();
	
	}
}
package dao;

import java.sql.Connection;

import dao.DBConnection;

public class AlbumsDao {

	private Connection connection;
	
	public AlbumsDao() {
		connection = DBConnection.getInstance().getConnection();
	
	}
}
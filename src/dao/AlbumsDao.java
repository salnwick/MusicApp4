package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DBConnection;
import entity.Albums;
import entity.Tracks;

public class AlbumsDao {

	private Connection connection;
	private final String ALL_ALBUMS_QUERY = "select * from albums;";
	
	public AlbumsDao() {
		connection = DBConnection.getInstance().getConnection();
	}

	public List<Albums> getAlbums() throws SQLException{
		List<Albums> outinfo = new ArrayList<>();
		ResultSet rs = connection.prepareStatement(ALL_ALBUMS_QUERY).executeQuery();
		while (rs.next()) {
			outinfo.add(new Albums(rs.getInt("album_id"), rs.getString("album")));
	}
		return outinfo;
	}
}
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Albums;


public class AlbumsDao {

	
	private Connection connection;
	private final String ALL_ALBUMS_QUERY = "select * from albums;";
	private final String CREATE_ALBUM_QUERY = "insert into Albums (album, artist_id) values (?, ?);";
	private final String DELETE_ALBUMS_BY_ALBUM_ID_QUERY = "Delete From Albums WHERE album_id = ?";
	
	public AlbumsDao() {
		connection = DBConnection.getConnection();
		
	}

	public List<Albums> getAlbums() throws SQLException{
		List<Albums> outinfo = new ArrayList<>();
		ResultSet rs = connection.prepareStatement(ALL_ALBUMS_QUERY).executeQuery();
		while (rs.next()) {
			outinfo.add(new Albums(rs.getInt("album_id"), rs.getString("album")));
	}
		return outinfo;
	}

	public void createAlbum(String name, int artistId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_ALBUM_QUERY);
		ps.setString(1, name);
		ps.setInt(2, artistId);
		ps.executeUpdate();
	}
	
	public void deleteAlbum(int album_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_ALBUMS_BY_ALBUM_ID_QUERY);
		ps.setInt(1, album_id);
		ps.executeUpdate();
	}
}
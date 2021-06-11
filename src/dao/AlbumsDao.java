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
	private final String DISPLAY_ALBUMS_QUERY = "select * from albums;";
	private final String CREATE_ALBUM_QUERY = "insert into Albums (album, artist_id) values (?, ?);";
	private final String UPDATE_ALBUM_QUERY = "update albums set album = ? where album_id = ?;";
	private final String DELETE_ALBUM_QUERY = "Delete From Albums WHERE album_id = ?;";
	
	public AlbumsDao() {
		connection = DBConnection.getConnection();
		
	}

	public List<Albums> getAlbums() throws SQLException{
		List<Albums> outinfo = new ArrayList<>();
		ResultSet rs = connection.prepareStatement(DISPLAY_ALBUMS_QUERY).executeQuery();
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
	
	public void updateAlbum(String name, Integer id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_ALBUM_QUERY);
		ps.setString(1, name);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	
	public void deleteAlbum(int album_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_ALBUM_QUERY);
		ps.setInt(1, album_id);
		ps.executeUpdate();
	}
	
	public void close() {
		DBConnection.getInstance().closeConnection();
	}
}
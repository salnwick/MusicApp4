package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Artists;

public class ArtistsDao {

	private Connection connection;
	private final String DISPLAY_ARTISTS_QUERY = "select * from artists;";
	private final String CREATE_ARTIST_QUERY = "insert into Artists (artist) values (?);";
	private final String UPDATE_ARTIST_QUERY = "update artists set artist = ? where artist_id = ?;";
	private final String DELETE_ARTIST_QUERY = "Delete From Artists WHERE artist_id = ?;";
	
	public ArtistsDao() {
		connection = DBConnection.getConnection();
	
	}
	public List<Artists> getArtists() throws SQLException{
		List<Artists> outstuff = new ArrayList<>();
		ResultSet rs = connection.prepareStatement(DISPLAY_ARTISTS_QUERY).executeQuery();
		while (rs.next()) {
			outstuff.add(new Artists(rs.getInt("artist_id"), rs.getString("artist")));
	}
		return outstuff;
	}
	
	public void createArtist(String name) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_ARTIST_QUERY);
		ps.setString(1, name);
		ps.executeUpdate();
	}
	
	public void updateArtist(String name, Integer id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_ARTIST_QUERY);
		ps.setString(1, name);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	
	public void deleteArtist(int artist_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_ARTIST_QUERY);
		ps.setInt(1, artist_id);
		ps.executeUpdate();
	}
	
	public void close() {
		DBConnection.getInstance().closeConnection();
		}
}
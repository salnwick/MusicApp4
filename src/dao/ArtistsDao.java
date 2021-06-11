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
	private final String ALL_ARTISTS_QUERY = "select * from artists;";
	private final String CREATE_ARTIST_QUERY = "insert into Artists (artist) values (?);";
	private final String DELETE_ARTIST_BY_ARTIST_ID_QUERY = "Delete From Artists WHERE artist_id = ?";
	
	public ArtistsDao() {
		connection = DBConnection.getConnection();
	
	}
	public List<Artists> getArtists() throws SQLException{
		List<Artists> outstuff = new ArrayList<>();
		ResultSet rs = connection.prepareStatement(ALL_ARTISTS_QUERY).executeQuery();
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
	public void deleteArtist(int artist_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_ARTIST_BY_ARTIST_ID_QUERY);
		ps.setInt(1, artist_id);
		ps.executeUpdate();
	}
}
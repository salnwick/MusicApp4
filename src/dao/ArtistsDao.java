package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DBConnection;
import entity.Albums;
import entity.Artists;

public class ArtistsDao {

	private Connection connection;
	private final String ALL_ARTISTS_QUERY = "select * from artists;";
	private final String CREATE_ARTIST_QUERY = "insert into Artists (artist) values (?);";
	
	public ArtistsDao() {
		connection = DBConnection.getInstance().getConnection();
	
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
}
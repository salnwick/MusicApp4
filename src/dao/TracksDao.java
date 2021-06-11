package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Tracks;

public class TracksDao {
	
	private Connection connection;
	private final String ALL_TRACKS_QUERY = "select * from tracks";
	private final String CREATE_TRACK_QUERY = "insert into Tracks (track, album_id, artist_id) values (?, ?, ?);";
	private final String DELETE_TRACKS_BY_TRACK_ID_QUERY = "Delete From Tracks WHERE track_id = ?";
	
	public TracksDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Tracks> getTracks() throws SQLException {
		List<Tracks> out = new ArrayList<>();
		ResultSet rs = connection.prepareStatement(ALL_TRACKS_QUERY).executeQuery();
		while (rs.next()) {
			out.add(new Tracks(rs.getInt("track_id"), rs.getString("track")));
		}
		return out;
	}
	
	public void createTrack(String name, Integer id, Integer arid) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_TRACK_QUERY);
		ps.setString(1, name);
		ps.setInt(2, id);
		ps.setInt(3, arid);
		ps.executeUpdate();
	}
	
	public void deleteTrack(int track_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_TRACKS_BY_TRACK_ID_QUERY);
		ps.setInt(1, track_id);
		ps.executeUpdate();
	}
		
	public void close() {
	DBConnection.getInstance().closeConnection();
	}
}
package entity;

import java.util.List;

import entity.Albums;
import entity.Tracks;

public class Artists {
	private int artist_id;
	private String artist;
	private List<Albums> albums;
	private List<Tracks> tracks;
	
	public Artists(int artist_id, String artist) {
		this.setArtist_id(artist_id);
		this.setArtist(artist);
	}

	public int getArtist_id() {
		return artist_id;
	}

	public void setArtist_id(int artist_id) {
		this.artist_id = artist_id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public List<Albums> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Albums> albums) {
		this.albums = albums;
	}

	public List<Tracks> getTracks() {
		return tracks;
	}

	public void setTracks(List<Tracks> tracks) {
		this.tracks = tracks;
	}

}
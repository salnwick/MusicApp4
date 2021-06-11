package entity;

import java.util.List;

public class Artists {
	private int artist_id;
	private String artist;
	
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
}
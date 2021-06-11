package entity;

import java.util.List;

public class Albums {
	private int album_id;
	private String album;
	private List<Tracks> tracks;
	
	public Albums(int album_id, String album) {
		this.setAlbum_id(album_id);
		this.setAlbum(album);
	}

	public int getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public List<Tracks> getTracks() {
		return tracks;
	}

	public void setTracks(List<Tracks> tracks) {
		this.tracks = tracks;
	}
}
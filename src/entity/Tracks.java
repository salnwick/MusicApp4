package entity;

public class Tracks {
	private int track_id;
	private String track;
	
	public Tracks(int track_id, String track) {
		this.setTrack_id(track_id);
		this.setTrack(track);
	}

	public int getTrack_id() {
		return track_id;
	}

	public void setTrack_id(int track_id) {
		this.track_id = track_id;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}
}
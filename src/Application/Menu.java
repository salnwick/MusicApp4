package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.AlbumsDao;
import dao.ArtistsDao;
import dao.TracksDao;
import entity.Albums;
import entity.Artists;
import entity.Tracks;

public class Menu {

	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Artists",
			"Display Albums",
			"Display Tracks",
			"Add New Artist",
			"Add New Album",
			"Add New Track",
			"Update Album",
			"Update Artist",
			"Update Track",
			"Delete Album",
			"Delete Artist",
			"Delete Track"
			);
	private	TracksDao tracksDao = new TracksDao();	
	private AlbumsDao albumsDao = new AlbumsDao();
	private ArtistsDao artistsDao = new ArtistsDao();
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
		try {		
			if (selection.equals("1")) {
					displayArtists();
			} else if (selection.equals("2")) {
					displayAlbums();
			} else if (selection.equals("3")) {
					displayTracks();	
			} else if (selection.equals("4")) {
//					addArtist();
			} else if (selection.equals("5")) {
//					addAlbum();
			} else if (selection.equals("6")) {
//					addTrack();
			} else if (selection.equals("7")) {
//					updateAlbum();
			}else if (selection.equals("8")) {
//					UpdateArtist();
			} else if (selection.equals("9")) {
//					UpdateTrack();
			}else if (selection.equals("10")) {
//					deleteAlbum();
			}else if (selection.equals("11")) {
//					deleteArtist();
			}else if (selection.equals("12")) {
//					deleteTrack();
			}else selection = "-1";
			}catch (SQLException e) {
				e.printStackTrace();
				end();
			}
			System.out.println("Please press enter to continue...");
			scanner.nextLine();
		} while (!selection.equals("-1"));
		end();
	}
		
	
	private void printMenu() {
		System.out.println("Select an Option:\n-----------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	
	}
	
	private void displayArtists() throws SQLException {
		List<Artists> myArtists = artistsDao.getArtists();
		System.out.println("All Artists:\n------------------------");
		for (Artists ar:myArtists) {
			System.out.println(ar.getArtist_id() + " " + ar.getArtist());
		}
	}
	
	private void displayAlbums() throws SQLException {
		List<Albums> myAlbums = albumsDao.getAlbums();
		System.out.println("All Albums:\n------------------------");
		for (Albums a:myAlbums) {
			System.out.println(a.getAlbum_id() + " " + a.getAlbum());
		}
	}
	
	private void displayTracks() throws SQLException {
		List<Tracks> myTracks = tracksDao.getTracks();
		System.out.println("All Tracks:\n-------------------------");
		for (Tracks t:myTracks) {
			System.out.println(t.getTrack_id() + " " + t.getTrack());
		}
	}
	
	public void end() {
		System.out.println("Bye!");
		scanner.close();
		tracksDao.close();	
	}
}
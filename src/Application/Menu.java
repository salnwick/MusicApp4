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
			"Update Artist Name",
			"Update Album Name",
			"Update Track Name",
			"Delete Artist",
			"Delete Album",
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
					addArtist();
			} else if (selection.equals("5")) {
					addAlbum();
			} else if (selection.equals("6")) {
					addTrack();
			} else if (selection.equals("7")) {
					updateArtist();
			}else if (selection.equals("8")) {
					updateAlbum();
			} else if (selection.equals("9")) {
					updateTrack();
			}else if (selection.equals("10")) {
					deleteArtist();
			}else if (selection.equals("11")) {
					deleteAlbum();
			}else if (selection.equals("12")) {
					deleteTrack();
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
	
	private void addArtist() throws SQLException {
		System.out.print("Enter Name of Artist: ");
		String name = scanner.nextLine();
		artistsDao.createArtist(name);
	}
	
	private void addAlbum() throws SQLException {
		System.out.print("Enter Name of Album: ");
		String name = scanner.nextLine();
		System.out.print("Please enter Artist ID for Album: ");
		displayArtists();
		String artistId = scanner.nextLine();
		Integer id = null;
		try {
			id = Integer.parseInt(artistId);
		}catch (NumberFormatException e) {
			System.out.println("Please enter an ID number....");
			return;
		}
		albumsDao.createAlbum(name, id);
	}
	
	private void addTrack() throws SQLException {
		System.out.print("Enter Name of Track: ");
		String name = scanner.nextLine();
		System.out.print("Please enter Album ID for Track: ");
		displayAlbums();
		String albumId = scanner.nextLine();
		Integer id = null;
		try {
			id = Integer.parseInt(albumId);
		}catch (NumberFormatException e) {
			System.out.println("Please enter an ID number....");
			return;
		}
		System.out.print("Please enter Artist ID for Track: ");
		displayArtists();
		String artistId = scanner.nextLine();
		Integer arid = null;
		try {
			arid = Integer.parseInt(artistId);
		}catch (NumberFormatException e) {
			System.out.println("Please enter an ID number....");
			return;
		}
		tracksDao.createTrack(name, id, arid);
	}
	
	private void updateArtist() throws SQLException {
		System.out.println("Which Artist ID would you like to update? ");
		displayArtists();
		String artistId = scanner.nextLine();
		Integer id = null;
		try {
			id = Integer.parseInt(artistId);
		}catch (NumberFormatException e) {
			System.out.println("Please enter an ID number....");
			return;
		}
		System.out.print("Enter new Artist Name: ");
		String name = scanner.nextLine();
		artistsDao.updateArtist(name, id);
	}
	
	private void updateAlbum() throws SQLException {
		System.out.println("Which Album ID would you like to update? ");
		displayAlbums();
		String albumId = scanner.nextLine();
		Integer id = null;
		try {
			id = Integer.parseInt(albumId);
		}catch (NumberFormatException e) {
			System.out.println("Please enter an ID number....");
			return;
		}
		System.out.print("Enter new Album Name: ");
		String name = scanner.nextLine();
		albumsDao.updateAlbum(name, id);
	}
	
	private void updateTrack() throws SQLException {
		System.out.println("Which Track ID would you like to update? ");
		displayTracks();
		String trackId = scanner.nextLine();
		Integer id = null;
		try {
			id = Integer.parseInt(trackId);
		}catch (NumberFormatException e) {
			System.out.println("Please enter an ID number....");
			return;
		}
		System.out.print("Enter new Track Name: ");
		String name = scanner.nextLine();
		tracksDao.updateTrack(name, id);
	}
	
	private void deleteArtist() throws SQLException {
		System.out.print("Enter Artist Id to delete:");
		int artist_id = Integer.parseInt(scanner.nextLine());
		artistsDao.deleteArtist(artist_id);
	}
	
	private void deleteAlbum() throws SQLException {
		System.out.print("Enter Album ID to delete:");
		int album_id = Integer.parseInt(scanner.nextLine());
		albumsDao.deleteAlbum(album_id);
	}

	private void deleteTrack() throws SQLException {
		System.out.print("Enter make id to delete:");
		int track_id = Integer.parseInt(scanner.nextLine());
		tracksDao.deleteTrack(track_id);
	}


	
	public void end() {
		System.out.println("Bye!");
		scanner.close();
		artistsDao.close();
	}
	
}
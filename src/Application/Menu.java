package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.TracksDao;
import entity.Tracks;

public class Menu {

	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display all Tracks",
			"Display Tracks by Artist",
			"Display Tracks by Album",
			"Add New Artist",
			"Add New Album",
			"Add New Track",
			"Update Track",
			"Delete Track"
			);
	private	TracksDao tracksDao = new TracksDao();	
	
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
		try {		
			if (selection.equals("1")) {
					displayAllTracks();
			} else if (selection.equals("2")) {
//					displayByAlbum();
			} else if (selection.equals("3")) {
//					displayByArtist();	
			} else if (selection.equals("4")) {
//					addArtist();
			} else if (selection.equals("5")) {
//					addAlbum();
			} else if (selection.equals("6")) {
//					addTrack();
			} else if (selection.equals("7")) {
//					updateTrack();
			}else if (selection.equals("8")) {
//					deleteTrack();
			} else selection = "-1";
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
	
	private void displayAllTracks() throws SQLException {
		List<Tracks> myTracks = tracksDao.getAllTracks();
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
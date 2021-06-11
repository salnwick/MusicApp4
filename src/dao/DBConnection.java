package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DBConnection {

private static Scanner input = new Scanner(System.in);
	
	public final static String URL = "jdbc:mysql://localhost:3306/music";
	public final static String Username = "root";
	private static String Password;
	
	private static DBConnection instance = new DBConnection();
	private static Connection connection;
	
	private DBConnection() {}
	
	public static DBConnection getInstance() {
		return instance;
	}
	
	public static Connection getConnection() {
		if (connection == null) {
			try {
				System.out.println("Please Enter Password");
				Password = input.nextLine();
				connection = DriverManager.getConnection(URL, Username, Password);
				System.out.println("Connection Successful!!!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} return connection;
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection = null;
		}
	}

}
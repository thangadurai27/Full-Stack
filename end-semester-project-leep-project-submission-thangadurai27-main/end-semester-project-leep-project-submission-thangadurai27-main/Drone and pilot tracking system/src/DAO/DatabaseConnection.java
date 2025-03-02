package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/DroneTrackingSystem"; // URL for MySQL database
    private static final String USER = "root";  // MySQL username
    private static final String PASSWORD = "1234";  // MySQL password

    private static Connection connection = null;

    // Private constructor to prevent instantiation
    private DatabaseConnection() {}

    // Method to get a connection to the database
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish the connection to the database
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connection established successfully.");
            } catch (ClassNotFoundException e) {
                System.err.println("MySQL JDBC Driver not found.");
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Method to close the connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed successfully.");
            } catch (SQLException e) {
                System.err.println("Error closing the connection.");
                e.printStackTrace();
            }
        }
    }
}

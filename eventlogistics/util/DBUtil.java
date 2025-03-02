package com.eventlogistics.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    // Ensure the database name is correct
    private static final String URL = "jdbc:mysql://localhost:3306/logistics_management"; // Update to your database name
    private static final String USER = "root"; // Replace with your DB username (e.g., root or your username)
    private static final String PASSWORD = "W7301@jqir#"; // Replace with your DB password

    // Method to get a connection to the database
    public static Connection getConnection() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection established successfully.");
            return connection;
        } catch (SQLException e) {
            System.err.println("Error establishing connection: " + e.getMessage());
            throw e; // Rethrow the exception to be handled elsewhere
        }
    }
}

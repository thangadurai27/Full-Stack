package com.eventlogistics.dao;

import com.eventlogistics.model.Session;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessionDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/logistics_management"; // Your DB URL
    private static final String DB_USERNAME = "root"; // Your DB username
    private static final String DB_PASSWORD = "W7301@jqir#"; // Your DB password

    private Connection connection;

    public SessionDAO() {
        try {
            // Register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection established successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error establishing connection: " + e.getMessage());
        }
    }

    // Add session to the database
    public void addSession(Session session) {
        String query = "INSERT INTO session (session_name, session_time, event_id) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, session.getSessionName());
            preparedStatement.setString(2, session.getSessionTime());
            preparedStatement.setInt(3, session.getEventId());

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Session added successfully.");
            } else {
                System.out.println("Failed to add session.");
            }
        } catch (SQLException e) {
            System.err.println("Error adding session: " + e.getMessage());
        }
    }

    // View all sessions
    public void viewSessions() {
        String query = "SELECT * FROM session";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Session ID: " + resultSet.getInt("session_id"));
                System.out.println("Session Name: " + resultSet.getString("session_name"));
                System.out.println("Session Time: " + resultSet.getString("session_time"));
                System.out.println("Event ID: " + resultSet.getInt("event_id"));
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            System.err.println("Error fetching sessions: " + e.getMessage());
        }
    }

    // Update session
    public void updateSession(int sessionId, Session updatedSession) {
        String query = "UPDATE session SET session_name = ?, session_time = ?, event_id = ? WHERE session_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, updatedSession.getSessionName());
            preparedStatement.setString(2, updatedSession.getSessionTime());
            preparedStatement.setInt(3, updatedSession.getEventId());
            preparedStatement.setInt(4, sessionId);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Session updated successfully.");
            } else {
                System.out.println("Failed to update session.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating session: " + e.getMessage());
        }
    }

    // Delete session
    public void deleteSession(int sessionId) {
        String query = "DELETE FROM session WHERE session_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, sessionId);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Session deleted successfully.");
            } else {
                System.out.println("Failed to delete session.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting session: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

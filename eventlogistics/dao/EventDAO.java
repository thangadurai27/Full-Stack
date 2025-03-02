package com.eventlogistics.dao;

import com.eventlogistics.model.Event;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/logistics_management"; // Your DB URL
    private static final String DB_USERNAME = "root"; // Your DB username
    private static final String DB_PASSWORD = "W7301@jqir#"; // Your DB password

    private Connection connection;

    public EventDAO() {
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

    // Add event to the database
    public void addEvent(Event event) {
        String query = "INSERT INTO event (event_name, event_date, event_location) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, event.getEventName());
            preparedStatement.setString(2, event.getEventDate());
            preparedStatement.setString(3, event.getEventLocation());

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Event added successfully.");
            } else {
                System.out.println("Failed to add event.");
            }
        } catch (SQLException e) {
            System.err.println("Error adding event: " + e.getMessage());
        }
    }

    // View all events
    public void viewEvents() {
        String query = "SELECT * FROM event";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Event ID: " + resultSet.getInt("event_id"));
                System.out.println("Event Name: " + resultSet.getString("event_name"));
                System.out.println("Event Date: " + resultSet.getString("event_date"));
                System.out.println("Event Location: " + resultSet.getString("event_location"));
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            System.err.println("Error fetching events: " + e.getMessage());
        }
    }

    // Update event
    public void updateEvent(int eventId, Event updatedEvent) {
        String query = "UPDATE event SET event_name = ?, event_date = ?, event_location = ? WHERE event_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, updatedEvent.getEventName());
            preparedStatement.setString(2, updatedEvent.getEventDate());
            preparedStatement.setString(3, updatedEvent.getEventLocation());
            preparedStatement.setInt(4, eventId);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Event updated successfully.");
            } else {
                System.out.println("Failed to update event.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating event: " + e.getMessage());
        }
    }

    // Delete event
    public void deleteEvent(int eventId) {
        String query = "DELETE FROM event WHERE event_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, eventId);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Event deleted successfully.");
            } else {
                System.out.println("Failed to delete event.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting event: " + e.getMessage());
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

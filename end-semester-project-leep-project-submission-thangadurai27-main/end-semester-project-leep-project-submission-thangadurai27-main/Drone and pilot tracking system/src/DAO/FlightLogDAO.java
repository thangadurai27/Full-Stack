package DAO;

import Model.FlightLog;

import java.sql.*;

public class FlightLogDAO {
    private Connection connection;

    public FlightLogDAO(Connection connection) {
        this.connection = connection;
    }

    public void addFlightLog(FlightLog flightLog) {
        String query = "INSERT INTO flightlogs (drone_id, pilot_id, start_time, end_time, location) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, flightLog.getDroneId());
            stmt.setInt(2, flightLog.getPilotId());
            stmt.setTimestamp(3, flightLog.getStartTime());
            stmt.setTimestamp(4, flightLog.getEndTime());
            stmt.setString(5, flightLog.getLocation());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

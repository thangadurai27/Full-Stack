package DAO;

import Model.Pilot;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PilotDAO {
    private Connection connection;

    public PilotDAO(Connection connection) {
        this.connection = connection;
    }

    // Add a pilot
    public void addPilot(Pilot pilot) {
        String query = "INSERT INTO pilots (name, license_number, experience, certifications) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, pilot.getName());
            statement.setString(2, pilot.getLicenseNumber());
            statement.setInt(3, pilot.getExperience());
            statement.setString(4, pilot.getCertifications());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all pilots
    public List<Pilot> getAllPilots() {
        List<Pilot> pilots = new ArrayList<>();
        String query = "SELECT * FROM pilots";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String licenseNumber = resultSet.getString("license_number");
                int experience = resultSet.getInt("experience");
                String certifications = resultSet.getString("certifications");
                Pilot pilot = new Pilot(name, licenseNumber, experience, certifications);
                pilots.add(pilot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pilots;
    }

    // Generate Pilot Hours Report
    public void generatePilotHoursReport() {
        String query = "SELECT p.name, SUM(TIMESTAMPDIFF(HOUR, f.start_time, f.end_time)) AS total_hours " +
                       "FROM pilots p JOIN flight_logs f ON p.id = f.pilot_id " +
                       "GROUP BY p.id";

        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            System.out.println("Pilot Hours Report:");
            while (resultSet.next()) {
                String pilotName = resultSet.getString("name");
                int totalHours = resultSet.getInt("total_hours");
                System.out.println("Pilot: " + pilotName + ", Total Hours: " + totalHours);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

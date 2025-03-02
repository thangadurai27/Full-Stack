package DAO;

import Model.MaintenanceRecord;
import java.sql.*;

public class MaintenanceRecordDAO {
    private Connection connection;

    public MaintenanceRecordDAO(Connection connection) {
        this.connection = connection;
    }

    // Add a maintenance record
    public void addMaintenanceRecord(MaintenanceRecord maintenanceRecord) {
        String query = "INSERT INTO maintenance_records (drone_id, maintenance_date, description) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maintenanceRecord.getDroneId());
            statement.setDate(2, maintenanceRecord.getMaintenanceDate());
            statement.setString(3, maintenanceRecord.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Generate Maintenance Schedule Report
    public void generateMaintenanceScheduleReport() {
        String query = "SELECT d.serial_number, mr.maintenance_date, mr.description " +
                       "FROM maintenance_records mr JOIN drones d ON mr.drone_id = d.id " +
                       "ORDER BY mr.maintenance_date DESC";

        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            System.out.println("Maintenance Schedule Report:");
            while (resultSet.next()) {
                String serialNumber = resultSet.getString("serial_number");
                Date maintenanceDate = resultSet.getDate("maintenance_date");
                String description = resultSet.getString("description");
                System.out.println("Drone: " + serialNumber + ", Maintenance Date: " + maintenanceDate + ", Description: " + description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

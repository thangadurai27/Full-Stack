package DAO;

import Model.Drone;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DroneDAO {
    private Connection connection;

    public DroneDAO(Connection connection) {
        this.connection = connection;
    }

    // Add a drone
    public void addDrone(Drone drone) {
        String query = "INSERT INTO drones (serial_number, model, manufacturer, last_maintenance) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, drone.getSerialNumber());
            statement.setString(2, drone.getModel());
            statement.setString(3, drone.getManufacturer());
            statement.setDate(4, drone.getLastMaintenance());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all drones
    public List<Drone> getAllDrones() {
        List<Drone> drones = new ArrayList<>();
        String query = "SELECT * FROM drones";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                String serialNumber = resultSet.getString("serial_number");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                Date lastMaintenance = resultSet.getDate("last_maintenance");
                Drone drone = new Drone(serialNumber, model, manufacturer, lastMaintenance);
                drones.add(drone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drones;
    }

    // Generate Drone Utilization Report
    public void generateDroneUtilizationReport() {
        String query = "SELECT d.serial_number, COUNT(f.id) AS flights_count " +
                       "FROM drones d LEFT JOIN flight_logs f ON d.id = f.drone_id " +
                       "GROUP BY d.id";

        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            System.out.println("Drone Utilization Report:");
            while (resultSet.next()) {
                String serialNumber = resultSet.getString("serial_number");
                int flightCount = resultSet.getInt("flights_count");
                System.out.println("Drone Serial: " + serialNumber + ", Flights Count: " + flightCount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

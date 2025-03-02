package Main;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import DAO.DroneDAO;
import DAO.PilotDAO;
import DAO.FlightLogDAO;
import DAO.MaintenanceRecordDAO;
import Model.Drone;
import Model.Pilot;
import Model.FlightLog;
import Model.MaintenanceRecord;

public class Main {
    private static Connection connection;

    public static void main(String[] args) {
        try {
            // Establish database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DroneTrackingSystem", "root", "1234");

            try (Scanner scanner = new Scanner(System.in)) {
                DroneDAO droneDAO = new DroneDAO(connection);
                PilotDAO pilotDAO = new PilotDAO(connection);
                FlightLogDAO flightLogDAO = new FlightLogDAO(connection);
                MaintenanceRecordDAO maintenanceRecordDAO = new MaintenanceRecordDAO(connection);

                while (true) {
                    System.out.println("Drone Tracking and Pilot Tracking System");
                    System.out.println("1. Add Drone");
                    System.out.println("2. Add Pilot");
                    System.out.println("3. View Drones");
                    System.out.println("4. View Pilots");
                    System.out.println("5. Log Flight");
                    System.out.println("6. Add Maintenance Record");
                    System.out.println("7. Generate Reports");
                    System.out.println("8. Exit");
                    System.out.print("Choose an option: ");

                    int option = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    switch (option) {
                        case 1:
                            System.out.print("Enter Drone Serial Number: ");
                            String serialNumber = scanner.nextLine();
                            System.out.print("Enter Drone Model: ");
                            String model = scanner.nextLine();
                            System.out.print("Enter Drone Manufacturer: ");
                            String manufacturer = scanner.nextLine();
                            System.out.print("Enter Last Maintenance Date (YYYY-MM-DD): ");
                            Date lastMaintenance = Date.valueOf(scanner.nextLine());

                            Drone drone = new Drone(serialNumber, model, manufacturer, lastMaintenance);
                            droneDAO.addDrone(drone);
                            System.out.println("Drone added successfully!");
                            break;

                        case 2:
                            System.out.print("Enter Pilot Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter License Number: ");
                            String licenseNumber = scanner.nextLine();
                            System.out.print("Enter Pilot Experience (in years): ");
                            int experience = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter Certifications: ");
                            String certifications = scanner.nextLine();

                            Pilot pilot = new Pilot(name, licenseNumber, experience, certifications);
                            pilotDAO.addPilot(pilot);
                            System.out.println("Pilot added successfully!");
                            break;

                        case 3:
                            List<Drone> drones = droneDAO.getAllDrones();
                            System.out.println("List of Drones:");
                            for (Drone d : drones) {
                                System.out.println(d.getSerialNumber() + " - " + d.getModel());
                            }
                            break;

                        case 4:
                            List<Pilot> pilots = pilotDAO.getAllPilots();
                            System.out.println("List of Pilots:");
                            for (Pilot p : pilots) {
                                System.out.println(p.getName() + " - " + p.getLicenseNumber());
                            }
                            break;

                        case 5:
                            System.out.print("Enter Drone ID: ");
                            int droneId = scanner.nextInt();
                            System.out.print("Enter Pilot ID: ");
                            int pilotId = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter Flight Start Time (YYYY-MM-DD HH:MM:SS): ");
                            String startTime = scanner.nextLine();
                            System.out.print("Enter Flight End Time (YYYY-MM-DD HH:MM:SS): ");
                            String endTime = scanner.nextLine();
                            System.out.print("Enter Flight Location: ");
                            String location = scanner.nextLine();

                            FlightLog flightLog = new FlightLog(droneId, pilotId, Timestamp.valueOf(startTime), Timestamp.valueOf(endTime), location);
                            flightLogDAO.addFlightLog(flightLog);
                            System.out.println("Flight log added successfully!");
                            break;

                        case 6:
                            System.out.print("Enter Drone ID for Maintenance: ");
                            int maintenanceDroneId = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter Maintenance Date (YYYY-MM-DD): ");
                            String maintenanceDate = scanner.nextLine();
                            System.out.print("Enter Maintenance Description: ");
                            String description = scanner.nextLine();

                            MaintenanceRecord maintenanceRecord = new MaintenanceRecord(maintenanceDroneId, Date.valueOf(maintenanceDate), description);
                            maintenanceRecordDAO.addMaintenanceRecord(maintenanceRecord);
                            System.out.println("Maintenance record added successfully!");
                            break;

                        case 7:
                            System.out.println("Generate Reports:");
                            System.out.println("1. Drone Utilization Report");
                            System.out.println("2. Pilot Hours Report");
                            System.out.println("3. Maintenance Schedule Report");
                            System.out.print("Choose a report: ");
                            int reportOption = scanner.nextInt();
                            scanner.nextLine();  // Consume newline

                            switch (reportOption) {
                                case 1:
                                    System.out.println("Drone Utilization Report:");
                                    droneDAO.generateDroneUtilizationReport();
                                    break;
                                case 2:
                                    System.out.println("Pilot Hours Report:");
                                    pilotDAO.generatePilotHoursReport();
                                    break;
                                case 3:
                                    System.out.println("Maintenance Schedule Report:");
                                    maintenanceRecordDAO.generateMaintenanceScheduleReport();
                                    break;
                                default:
                                    System.out.println("Invalid option.");
                            }
                            break;

                        case 8:
                            System.out.println("Exiting system...");
                            connection.close();
                            return;

                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

-- Creating the Database
drop DATABASE DroneTrackingSystem;
CREATE DATABASE DroneTrackingSystem;
USE DroneTrackingSystem;

-- Creating Drones Table
CREATE TABLE drones (
    drone_id INT AUTO_INCREMENT PRIMARY KEY,
    serial_number VARCHAR(255),
    model VARCHAR(255),
    manufacturer VARCHAR(255),
    last_maintenance DATE
);


-- Creating Pilots Table
CREATE TABLE IF NOT EXISTS Pilots (
    pilot_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    license_number VARCHAR(50) NOT NULL,
    experience INT NOT NULL,
    certifications VARCHAR(255)
);

-- Creating FlightLogs Table
CREATE TABLE IF NOT EXISTS FlightLogs (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    drone_id INT,
    pilot_id INT,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    location VARCHAR(100),
    FOREIGN KEY (drone_id) REFERENCES Drones(drone_id) ON DELETE CASCADE,
    FOREIGN KEY (pilot_id) REFERENCES Pilots(pilot_id) ON DELETE CASCADE
);

-- Creating MaintenanceRecords Table
CREATE TABLE IF NOT EXISTS maintenance_records (
    maintenance_id INT AUTO_INCREMENT PRIMARY KEY,
    drone_id INT,
    maintenance_date DATE,
    description VARCHAR(255),
    FOREIGN KEY (drone_id) REFERENCES drones(drone_id) ON DELETE CASCADE
);



-- Example of updating a drone's last maintenance date
UPDATE Drones
SET last_maintenance = '2024-11-10'
WHERE drone_id = 1;

-- Example of updating a pilot's experience
UPDATE Pilots
SET experience = 6
WHERE pilot_id = 2;

-- Example of inserting a new drone
INSERT INTO Drones (serial_number, model, manufacturer, last_maintenance)
VALUES ('SN123456', 'ModelX', 'DroneCorp', '2024-10-15');

-- Example of inserting a new pilot
INSERT INTO Pilots (name, license_number, experience, certifications)
VALUES ('John Doe', 'L12345', 5, 'Certified Drone Pilot');

-- Example of inserting a flight log
INSERT INTO FlightLogs (drone_id, pilot_id, start_time, end_time, location)
VALUES (1, 1, '2024-11-14 08:00:00', '2024-11-14 10:00:00', 'Los Angeles');

-- Example of inserting a maintenance record
INSERT INTO MaintenanceRecords (drone_id, maintenance_date, description)
VALUES (1, '2024-11-01', 'Replaced propellers and updated firmware');


select*from Drones;

select*from Pilots;

select*from FlightLogs;

select*from MaintenanceRecords;



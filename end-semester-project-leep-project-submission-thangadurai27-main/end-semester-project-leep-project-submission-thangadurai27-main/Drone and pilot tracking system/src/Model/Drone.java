package Model;

import java.sql.Date;

public class Drone {
    private int droneId;
    private String serialNumber;
    private String model;
    private String manufacturer;
    private Date lastMaintenance;

    public Drone(String serialNumber, String model, String manufacturer, Date lastMaintenance) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.manufacturer = manufacturer;
        this.lastMaintenance = lastMaintenance;
    }

    public Drone(int droneId, String serialNumber, String model, String manufacturer, Date lastMaintenance) {
        this.droneId = droneId;
        this.serialNumber = serialNumber;
        this.model = model;
        this.manufacturer = manufacturer;
        this.lastMaintenance = lastMaintenance;
    }

    public int getDroneId() {
        return droneId;
    }

    public void setDroneId(int droneId) {
        this.droneId = droneId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getLastMaintenance() {
        return lastMaintenance;
    }

    public void setLastMaintenance(Date lastMaintenance) {
        this.lastMaintenance = lastMaintenance;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "droneId=" + droneId +
                ", serialNumber='" + serialNumber + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", lastMaintenance=" + lastMaintenance +
                '}';
    }
}

package Model;

import java.sql.Date;

public class MaintenanceRecord {
    private int recordId;
    private int droneId;
    private Date maintenanceDate;
    private String description;

    public MaintenanceRecord(int droneId, Date maintenanceDate, String description) {
        this.droneId = droneId;
        this.maintenanceDate = maintenanceDate;
        this.description = description;
    }

    public MaintenanceRecord(int recordId, int droneId, Date maintenanceDate, String description) {
        this.recordId = recordId;
        this.droneId = droneId;
        this.maintenanceDate = maintenanceDate;
        this.description = description;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getDroneId() {
        return droneId;
    }

    public void setDroneId(int droneId) {
        this.droneId = droneId;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MaintenanceRecord{" +
                "recordId=" + recordId +
                ", droneId=" + droneId +
                ", maintenanceDate=" + maintenanceDate +
                ", description='" + description + '\'' +
                '}';
    }
}

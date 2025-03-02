package Model;

import java.sql.Timestamp;

public class FlightLog {
    private int flightId;
    private int droneId;
    private int pilotId;
    private Timestamp startTime;
    private Timestamp endTime;
    private String location;

    public FlightLog(int droneId, int pilotId, Timestamp startTime, Timestamp endTime, String location) {
        this.droneId = droneId;
        this.pilotId = pilotId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
    }

    public FlightLog(int flightId, int droneId, int pilotId, Timestamp startTime, Timestamp endTime, String location) {
        this.flightId = flightId;
        this.droneId = droneId;
        this.pilotId = pilotId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getDroneId() {
        return droneId;
    }

    public void setDroneId(int droneId) {
        this.droneId = droneId;
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "FlightLog{" +
                "flightId=" + flightId +
                ", droneId=" + droneId +
                ", pilotId=" + pilotId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", location='" + location + '\'' +
                '}';
    }
}

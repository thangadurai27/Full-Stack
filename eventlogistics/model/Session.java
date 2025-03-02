package com.eventlogistics.model;

public class Session {

    private String sessionName;
    private String sessionTime;
    private int eventId;

    // Constructor
    public Session(String sessionName, String sessionTime, int eventId) {
        this.sessionName = sessionName;
        this.sessionTime = sessionTime;
        this.eventId = eventId;
    }

    // Getters and Setters
    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(String sessionTime) {
        this.sessionTime = sessionTime;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}

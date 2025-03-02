package com.eventlogistics.service;

import com.eventlogistics.dao.SessionDAO;
import com.eventlogistics.model.Session;

public class SessionService {

    private SessionDAO sessionDAO;

    public SessionService() {
        this.sessionDAO = new SessionDAO();
    }

    // Method to add session
    public void addSession(String sessionName, String sessionTime, int eventId) {
        Session session = new Session(sessionName, sessionTime, eventId);
        sessionDAO.addSession(session);
    }

    // Method to view all sessions
    public void viewSessions() {
        // Logic to retrieve and display sessions
        sessionDAO.viewSessions();
    }

    // Method to update session
    public void updateSession(int sessionId, String newSessionName, String newSessionTime, int newEventId) {
        Session updatedSession = new Session(newSessionName, newSessionTime, newEventId);
        sessionDAO.updateSession(sessionId, updatedSession);
    }

    // Method to delete session
    public void deleteSession(int sessionId) {
        sessionDAO.deleteSession(sessionId);
    }
}

package com.eventlogistics.service;

import com.eventlogistics.dao.EventDAO;
import com.eventlogistics.model.Event;
import java.util.Scanner;

public class EventService {

    private EventDAO eventDAO;

    public EventService() {
        this.eventDAO = new EventDAO();
    }

    // Method to add event
    public void addEvent(String eventName, String eventDate, String eventLocation) {
        Event event = new Event(eventName, eventDate, eventLocation);
        eventDAO.addEvent(event);
    }

    // Method to view all events (example, you may modify based on your database design)
    public void viewEvents() {
        // Logic to retrieve and display events
        eventDAO.viewEvents();
    }

    // Method to update event
    public void updateEvent(int eventId, String newEventName, String newEventDate, String newEventLocation) {
        Event updatedEvent = new Event(newEventName, newEventDate, newEventLocation);
        eventDAO.updateEvent(eventId, updatedEvent);
    }

    // Method to delete event
    public void deleteEvent(int eventId) {
        eventDAO.deleteEvent(eventId);
    }
}

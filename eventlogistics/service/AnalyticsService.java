  /* package com.eventlogistics.service;

import com.eventlogistics.model.Feedback;
import com.eventlogistics.model.Event;
import com.eventlogistics.model.Session;
import java.util.*;
import java.util.stream.Collectors;

public class AnalyticsService {
    
    private List<Feedback> feedbackList;
    private List<Event> eventList;
    private List<Session> sessionList;
    
    // Constructor that initializes feedback, event, and session lists
    public AnalyticsService() {
        this.feedbackList = new ArrayList<>();
        this.eventList = new ArrayList<>();
        this.sessionList = new ArrayList<>();
    }

    // Generate an analytics report based on feedback for a specific event
    public void generateReport(int eventId) {
        Optional<Event> event = eventList.stream()
           .filter(e -> e.getId() == eventId)
            .findFirst();

        if (event.isPresent()) {
            List<Feedback> eventFeedback = feedbackList.stream()
                .filter(f -> f.getEventId() == eventId)
                .collect(Collectors.toList());

            if (!eventFeedback.isEmpty()) {
                double averageRating = eventFeedback.stream()
                    .mapToInt(Feedback::getRating)
                    .average()
                    .orElse(0);

                System.out.println("Analytics Report for Event: " + event.get().getName());
                System.out.println("Total Feedback: " + eventFeedback.size());
                System.out.println("Average Rating: " + averageRating);
            } else {
                System.out.println("No feedback available for this event.");
            }
        } else {
            System.out.println("Event not found.");
        }
    }

    // View generated analytics report
    public void viewAnalyticsReport() {
        for (Event event : eventList) {
            generateReport(event.getId());
        }
    }

    // Generate common feedback topics based on frequent keywords or phrases
    public void generateCommonFeedbackTopics() {
        Map<String, Integer> topicCount = new HashMap<>();

        for (Feedback feedback : feedbackList) {
            String[] words = feedback.getComments().split(" ");
            for (String word : words) {
                topicCount.put(word, topicCount.getOrDefault(word, 0) + 1);
            }
        }

        // Sort topics by frequency
        topicCount.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .limit(5)  // Display top 5 most common topics
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " mentions"));
    }

    // Real-time reporting - current ratings and feedback count
    public void realTimeReport(int eventId) {
        Optional<Event> event = eventList.stream()
            .filter(e -> e.getId() == eventId)
            .findFirst();

        if (event.isPresent()) {
            List<Feedback> eventFeedback = feedbackList.stream()
                .filter(f -> f.getEventId() == eventId)
                .collect(Collectors.toList());

            double averageRating = eventFeedback.stream()
                .mapToInt(Feedback::getRating)
                .average()
                .orElse(0);

            System.out.println("Real-time Report for Event: " + event.get().getName());
            System.out.println("Total Feedback: " + eventFeedback.size());
            System.out.println("Average Rating: " + averageRating);
        } else {
            System.out.println("Event not found.");
        }
    }

    // Methods to add feedback, events, and sessions to the lists (for testing)
    public void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
    }

    public void addEvent(Event event) {
        eventList.add(event);
    }

    public void addSession(Session session) {
        sessionList.add(session);
    }
}
   */
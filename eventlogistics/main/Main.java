package com.eventlogistics.main;

import com.eventlogistics.service.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       
        
        Connection connection = null;
        ParticipantService participantService=null;

        try {
            // 1. Connect to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logistics_management","root", "W7301@jqir#");

            // 2. Pass the connection to ParticipantService
            participantService = new ParticipantService(connection);

            // Use participantService here for your operations

        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        } 
    
    
    Scanner scanner = new Scanner(System.in);
        
    // Initialize service classes for different operations
        EventService eventService = new EventService();
       
        FeedbackService feedbackService = new FeedbackService();
      /*  AnalyticsService analyticsService = new AnalyticsService();*/
        SessionService sessionService = new SessionService();

        int choice = 0;
        do {
            System.out.println("\nEvent Logistics Management System");
            System.out.println("1. Event Management");
            System.out.println("2. Participant Management");
            System.out.println("3. Feedback Management");
          /*  System.out.println("4. Analytics");*/
            System.out.println("5. Session Management");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    // Event Management Submenu
                    int eventChoice = 0;
                    do {
                        System.out.println("\nEvent Management");
                        System.out.println("1. Add Event");
                        System.out.println("2. View Events");
                        System.out.println("3. Update Event");
                        System.out.println("4. Delete Event");
                        System.out.println("5. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        
                        eventChoice = scanner.nextInt();
                        scanner.nextLine();  // Consume newline character
                        
                        switch (eventChoice) {
                            case 1:
                                // Add Event
                                System.out.print("Enter event name: ");
                                String eventName = scanner.nextLine();
                                System.out.print("Enter event date (YYYY-MM-DD): ");
                                String eventDate = scanner.nextLine();
                                System.out.print("Enter event location: ");
                                String eventLocation = scanner.nextLine();
                                eventService.addEvent(eventName, eventDate, eventLocation);
                                break;
                                
                            case 2:
                                // View Events
                                eventService.viewEvents();
                                break;
                                
                            case 3:
                                // Update Event
                                System.out.print("Enter event ID to update: ");
                                int updateEventId = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Enter new event name: ");
                                String newEventName = scanner.nextLine();
                                System.out.print("Enter new event date (YYYY-MM-DD): ");
                                String newEventDate = scanner.nextLine();
                                System.out.print("Enter new event location: ");
                                String newEventLocation = scanner.nextLine();
                                eventService.updateEvent(updateEventId, newEventName, newEventDate, newEventLocation);
                                break;

                            case 4:
                                // Delete Event
                                System.out.print("Enter event ID to delete: ");
                                int deleteEventId = scanner.nextInt();
                                eventService.deleteEvent(deleteEventId);
                                break;

                            case 5:
                                System.out.println("Returning to main menu.");
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (eventChoice != 5);
                    break;

                case 2:
                    // Participant Management
                    int participantChoice = 0;
                    do {
                        System.out.println("\nParticipant Management");
                        System.out.println("1. Add Participant");
                        System.out.println("2. View Participants");
                        System.out.println("3. Update Participant");
                        System.out.println("4. Delete Participant");
                        System.out.println("5. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        
                        participantChoice = scanner.nextInt();
                        scanner.nextLine();  // Consume newline character
                        
                        switch (participantChoice) {
                            case 1:
                                // Add Participant
                                System.out.print("Enter participant first name: ");
                                String firstName = scanner.nextLine();
                                System.out.print("Enter participant last name: ");
                                String lastName = scanner.nextLine();
                                System.out.print("Enter participant email: ");
                                String email = scanner.nextLine();
                                participantService.addParticipant(firstName, lastName, email);
                                break;
                            case 2:
                                // View Participants
                                participantService.viewParticipants();
                                break;
                            case 3:
                                // Update Participant
                                System.out.print("Enter participant ID to update: ");
                                int participantId = scanner.nextInt();
                                scanner.nextLine();  // Consume newline character
                                System.out.print("Enter new first name: ");
                                String newFirstName = scanner.nextLine();
                                System.out.print("Enter new last name: ");
                                String newLastName = scanner.nextLine();
                                System.out.print("Enter new email: ");
                                String newEmail = scanner.nextLine();
                                participantService.updateParticipant(participantId, newFirstName, newLastName, newEmail);
                                break;
                            case 4:
                                // Delete Participant
                                System.out.print("Enter participant ID to delete: ");
                                int deleteParticipantId = scanner.nextInt();
                                participantService.deleteParticipant(deleteParticipantId);
                                break;
                            case 5:
                                System.out.println("Returning to main menu.");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (participantChoice != 5);
                    break;


                case 3:
                    // Feedback Management Submenu
                    int feedbackChoice = 0;
                    do {
                        System.out.println("\nFeedback Management");
                        System.out.println("1. Submit Feedback");
                        System.out.println("2. View Feedback");
                        System.out.println("3. Update Feedback");
                        System.out.println("4. Delete Feedback");
                        System.out.println("5. Back to Main Menu");
                        System.out.print("Enter your choice: ");

                        feedbackChoice = scanner.nextInt();
                        scanner.nextLine();  // Consume newline character

                        switch (feedbackChoice) {
                            case 1:
                                // Submit Feedback
                                System.out.print("Enter participant ID: ");
                                int participantId = scanner.nextInt();
                                scanner.nextLine();  // Consume newline character
                                System.out.print("Enter event ID (or session/speaker ID): ");
                                int itemId = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Enter rating (1-5): ");
                                int rating = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Enter comments: ");
                                String comments = scanner.nextLine();
                                feedbackService.submitFeedback(participantId, itemId, rating, comments);
                                break;

                            case 2:
                                // View Feedback
                                System.out.print("Enter event/session/speaker ID to view feedback: ");
                                int viewItemId = scanner.nextInt();
                                feedbackService.viewFeedback(viewItemId);
                                break;

                            case 3:
                                // Update Feedback
                                System.out.print("Enter feedback ID to update: ");
                                int feedbackId = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Enter new rating (1-5): ");
                                int newRating = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Enter new comments: ");
                                String newComments = scanner.nextLine();
                                feedbackService.updateFeedback(feedbackId, newRating, newComments);
                                break;

                            case 4:
                                // Delete Feedback
                                System.out.print("Enter feedback ID to delete: ");
                                int deleteFeedbackId = scanner.nextInt();
                                feedbackService.deleteFeedback(deleteFeedbackId);
                                break;

                            case 5:
                                System.out.println("Returning to main menu.");
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (feedbackChoice != 5);
                    break;

               /* case 4:
                    // Analytics and Reporting Submenu
                    int analyticsChoice = 0;
                    do {
                        System.out.println("\nAnalytics and Reporting");
                        System.out.println("1. Generate Analytics Report");
                        System.out.println("2. View Analytics Report");
                        System.out.println("3. Generate Common Feedback Topics");
                        System.out.println("4. Real-time Reporting");
                        System.out.println("5. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        
                        analyticsChoice = scanner.nextInt();
                        scanner.nextLine();  // Consume newline character
                        
                        switch (analyticsChoice) {
                            case 1:
                                // Generate Analytics Report
                                System.out.print("Enter event ID to generate analytics report: ");
                                int eventId = scanner.nextInt();
                                analyticsService.generateReport(eventId);
                                break;

                            case 2:
                                // View Analytics Report
                                analyticsService.viewAnalyticsReport();
                                break;

                            case 3:
                                // Generate Common Feedback Topics
                                analyticsService.generateCommonFeedbackTopics();
                                break;

                            case 4:
                                // Real-time Reporting
                                System.out.print("Enter event ID for real-time report: ");
                                int realTimeEventId = scanner.nextInt();
                                analyticsService.realTimeReport(realTimeEventId);
                                break;

                            case 5:
                                System.out.println("Returning to main menu.");
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (analyticsChoice != 5);
                    break;*/

                case 5:
                    // Event Management Submenu
                    int eventChoice1 = 0;
                    do {
                        System.out.println("\nEvent Management");
                        System.out.println("1. Add Event");
                        System.out.println("2. View Events");
                        System.out.println("3. Update Event");
                        System.out.println("4. Delete Event");
                        System.out.println("5. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        
                        eventChoice = scanner.nextInt();
                        scanner.nextLine();  // Consume newline character
                        
                        switch (eventChoice1) {
                            case 1:
                                // Add Event
                                System.out.print("Enter event name: ");
                                String eventName = scanner.nextLine();
                                System.out.print("Enter event date: ");
                                String eventDate = scanner.nextLine();
                                System.out.print("Enter event location: ");
                                String eventLocation = scanner.nextLine();
                                eventService.addEvent(eventName, eventDate, eventLocation);
                                break;

                            case 2:
                                // View Events
                                eventService.viewEvents();
                                break;

                            case 3:
                                // Update Event
                                System.out.print("Enter event ID to update: ");
                                int updateEventId = scanner.nextInt();
                                scanner.nextLine();  // Consume newline character
                                System.out.print("Enter new event name: ");
                                String newEventName = scanner.nextLine();
                                System.out.print("Enter new event date: ");
                                String newEventDate = scanner.nextLine();
                                System.out.print("Enter new event location: ");
                                String newEventLocation = scanner.nextLine();
                                eventService.updateEvent(updateEventId, newEventName, newEventDate, newEventLocation);
                                break;

                            case 4:
                                // Delete Event
                                System.out.print("Enter event ID to delete: ");
                                int deleteEventId = scanner.nextInt();
                                eventService.deleteEvent(deleteEventId);
                                break;

                            case 5:
                                System.out.println("Returning to main menu.");
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (eventChoice != 5);
                    break;

                case 6:
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
        
        scanner.close();
    }
}

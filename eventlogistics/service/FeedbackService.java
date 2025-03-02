package com.eventlogistics.service;

import java.util.ArrayList;
import java.util.List;

import com.eventlogistics.model.Feedback;

public class FeedbackService {
    // In-memory list to store feedbacks, can be replaced with a database or a file-based storage
    private List<Feedback> feedbackList = new ArrayList<>();

    // Submit Feedback
    public void submitFeedback(int participantId, int itemId, int rating, String comments) {
        Feedback feedback = new Feedback(participantId, itemId, rating, comments);
        feedbackList.add(feedback);
        System.out.println("Feedback submitted successfully.");
    }

    // View Feedback
    public void viewFeedback(int itemId) {
        boolean found = false;
        System.out.println("\nFeedback for Item ID: " + itemId);
        for (Feedback feedback : feedbackList) {
            if (feedback.getItemId() == itemId) {
                System.out.println(feedback);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No feedback found for the given item.");
        }
    }

    // Update Feedback
    public void updateFeedback(int feedbackId, int newRating, String newComments) {
        Feedback feedback = findFeedbackById(feedbackId);
        if (feedback != null) {
            feedback.setRating(newRating);
            feedback.setComments(newComments);
            System.out.println("Feedback updated successfully.");
        } else {
            System.out.println("Feedback not found.");
        }
    }

    // Delete Feedback
    public void deleteFeedback(int feedbackId) {
        Feedback feedback = findFeedbackById(feedbackId);
        if (feedback != null) {
            feedbackList.remove(feedback);
            System.out.println("Feedback deleted successfully.");
        } else {
            System.out.println("Feedback not found.");
        }
    }

    // Helper method to find feedback by ID
    private Feedback findFeedbackById(int feedbackId) {
        for (Feedback feedback : feedbackList) {
            if (feedback.getFeedbackId() == feedbackId) {
                return feedback;
            }
        }
        return null;
    }
}

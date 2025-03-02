package com.eventlogistics.controller;

import com.eventlogistics.service.FeedbackService;

public class FeedbackController {

    FeedbackService feedbackService = new FeedbackService();

    public void submitFeedback(int eventId, int participantId, int rating, String comments) {
        feedbackService.submitFeedback(eventId, participantId, rating, comments);
    }
}

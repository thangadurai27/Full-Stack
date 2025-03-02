package com.eventlogistics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.eventlogistics.util.DBUtil;

public class FeedbackDAO {

    public void submitFeedback(int rating, String comments, int participantId, int eventId, int sessionId, int speakerId) {
        String query = "INSERT INTO Feedback (rating, comments, participant_id, event_id, session_id, speaker_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, rating);
            statement.setString(2, comments);
            statement.setInt(3, participantId);
            statement.setInt(4, eventId);
            statement.setInt(5, sessionId);
            statement.setInt(6, speakerId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Feedback submitted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

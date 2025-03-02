package com.eventlogistics.dao;

import com.eventlogistics.model.Participant;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {
    private Connection connection;
    
    
    
    
    
    
    
    

    // Constructor to initialize database connection
    public ParticipantDAO(Connection connection) {
        this.connection = connection; // Use the passed connection directly
    }

    // Add a participant to the database
    public void addParticipant(Participant participant) throws SQLException {
        String sql = "INSERT INTO participant (first_name, last_name, email) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, participant.getFirstName());
            stmt.setString(2, participant.getLastName());
            stmt.setString(3, participant.getEmail());
            stmt.executeUpdate();
        }
    }

    // Get all participants from the database
    public List<Participant> getAllParticipants() throws SQLException {
        List<Participant> participants = new ArrayList<>();
        String sql = "SELECT * FROM participant";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Participant participant = new Participant(
                    rs.getInt("participant_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email")
                );
                participants.add(participant);
            }
        }
        return participants;
    }

    // Update participant details in the database
    public void updateParticipant(Participant participant) throws SQLException {
        String sql = "UPDATE participant SET first_name = ?, last_name = ?, email = ? WHERE participant_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, participant.getFirstName());
            stmt.setString(2, participant.getLastName());
            stmt.setString(3, participant.getEmail());
            stmt.setInt(4, participant.getId());
            stmt.executeUpdate();
        }
    }

    // Delete a participant from the database
    public void deleteParticipant(int participantId) throws SQLException {
        String sql = "DELETE FROM participant WHERE participant_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, participantId);
            stmt.executeUpdate();
        }
    }
}

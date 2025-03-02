package com.eventlogistics.service;

import com.eventlogistics.dao.ParticipantDAO;
import com.eventlogistics.model.Participant;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ParticipantService {
    private ParticipantDAO participantDAO;

    // Constructor to initialize ParticipantDAO with a Connection
    public ParticipantService(Connection connection) {
        this.participantDAO = new ParticipantDAO(connection);
    }

    // Add a participant using the DAO
    public void addParticipant(String firstName, String lastName, String email) {
        try {
            Participant participant = new Participant(0, firstName, lastName, email);
            participantDAO.addParticipant(participant);
            System.out.println("Participant added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding participant: " + e.getMessage());
        }
    }

    // View all participants using the DAO
    public void viewParticipants() {
        try {
            List<Participant> participants = participantDAO.getAllParticipants();
            if (participants.isEmpty()) {
                System.out.println("No participants found.");
            } else {
                for (Participant participant : participants) {
                    System.out.println(participant);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving participants: " + e.getMessage());
        }
    }

    // Update participant using the DAO
    public void updateParticipant(int id, String firstName, String lastName, String email) {
        try {
            Participant participant = new Participant(id, firstName, lastName, email);
            participantDAO.updateParticipant(participant);
            System.out.println("Participant updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating participant: " + e.getMessage());
        }
    }

    // Delete participant using the DAO
    public void deleteParticipant(int id) {
        try {
            participantDAO.deleteParticipant(id);
            System.out.println("Participant deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting participant: " + e.getMessage());
        }
    }
}

package com.eventlogistics.model;

public class Participant {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    // Constructor
    public Participant(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }

    public void setId(int id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }

    // toString method for displaying participant details
    @Override
    public String toString() {
        return "Participant [ID=" + id + ", First Name=" + firstName + ", Last Name=" + lastName + ", Email=" + email + "]";
    }
}

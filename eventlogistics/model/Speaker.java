package com.eventlogistics.model;

public class Speaker {
    private int speakerId;
    private String speakerName;
    private String biography;

    public Speaker(int speakerId, String speakerName, String biography) {
        this.speakerId = speakerId;
        this.speakerName = speakerName;
        this.biography = biography;
    }

    // Getters and Setters
    public int getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(int speakerId) {
        this.speakerId = speakerId;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}

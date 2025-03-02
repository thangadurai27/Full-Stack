package com.eventlogistics.model;

public class Feedback {
	
	
	 private int participantId;
	    private int itemId;
	    private int rating;
	    private String comments;

	    // Constructor that matches the parameters being passed
	    public Feedback(int participantId, int itemId, int rating, String comments) {
	        this.participantId = participantId;
	        this.itemId = itemId;
	        this.rating = rating;
	        this.comments = comments;
	    }

		public int getParticipantId() {
			return participantId;
		}

		public void setParticipantId(int participantId) {
			this.participantId = participantId;
		}

		public int getItemId() {
			return itemId;
		}

		public void setItemId(int itemId) {
			this.itemId = itemId;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

}

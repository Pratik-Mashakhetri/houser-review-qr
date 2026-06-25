package com.model;

public class ReviewTemplate {

	 private int id;
	    private String category;
	    private String review;

	    public ReviewTemplate(int id, String category, String review) {
	        this.id = id;
	        this.category = category;
	        this.review = review;
	    }

	    public int getId() { return id; }
	    public String getCategory() { return category; }
	    public String getReview() { return review; }

	    public void setId(int id) { this.id = id; }
	    public void setCategory(String category) { this.category = category; }
	    public void setReview(String review) { this.review = review; }
	
}

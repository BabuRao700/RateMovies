package com.movierating.dtos;

public class RatingDto {
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public int getRatingValue() {
		return RatingValue;
	}
	public void setRatingValue(int ratingValue) {
		RatingValue = ratingValue;
	}
	public int getRatingCounter() {
		return RatingCounter;
	}
	public void setRatingCounter(int ratingCounter) {
		RatingCounter = ratingCounter;
	}
	private int Id;	
	private String images;	
	private int RatingValue;	
	private int RatingCounter;
	// getter-setters

}

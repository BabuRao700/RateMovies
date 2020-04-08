package com.movierating.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RatingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "Rating_id")
	private int Id;
	@Column(name = "Movie_Name")
	private String images;
	@Column(name = "Rating_Value")
	private int RatingValue;
	@Column(name = "Rating_Counter")
	private int RatingCounter;
	// getter-setters
}

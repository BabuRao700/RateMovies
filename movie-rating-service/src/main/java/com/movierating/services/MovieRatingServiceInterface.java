package com.movierating.services;

import java.util.Optional;

import com.movierating.dtos.RatingDto;

public interface MovieRatingServiceInterface {
	
	RatingDto SaveRating(RatingDto ratingDto);
	
	RatingDto GetRating(int ratingId);

}

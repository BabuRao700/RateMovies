package com.movierating.services;

import com.movierating.dtos.RatingDto;

public interface MovieRatingServiceInterface {
	RatingDto saveRating(RatingDto ratingDto);
	RatingDto getRating(int ratingId);
}

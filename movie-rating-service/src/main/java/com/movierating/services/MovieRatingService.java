package com.movierating.services;

import com.movierating.domain.Rating;
import com.movierating.dtos.RatingDto;
import com.movierating.repository.MovieRatingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class MovieRatingService implements MovieRatingServiceInterface {

	private final MovieRatingRepository movieRatingRepository;

	@Autowired
	public MovieRatingService(MovieRatingRepository movieRatingRepository) {
		this.movieRatingRepository=movieRatingRepository;
	}

	public RatingDto saveRating(RatingDto ratingDto) {
		Rating existingRating = movieRatingRepository.findByMovieId(ratingDto.getMovieId());
		Rating newRating = Objects.isNull(existingRating)? createNewRating(ratingDto)
				                                         : calculateRating(existingRating, ratingDto);
		movieRatingRepository.save(newRating);
		log.info("rating saved...");
		return getRatingDto(ratingDto.getMovieId(), newRating);
	}

	private Rating createNewRating(RatingDto ratingDto) {
		return  Rating.builder().movieId(ratingDto.getMovieId())
						.avgRating(ratingDto.getRating())
						.noOfVotes(1).build();
	}

	public RatingDto getRating(int movieId) {
		Rating rating = movieRatingRepository.findByMovieId(movieId);
		return getRatingDto(movieId, rating);
	}

	private RatingDto getRatingDto(int movieId, Rating rating) {
		return RatingDto.builder()
				.movieId(movieId)
				.rating(rating.getAvgRating())
				.build();
	}

	//	weighted average (rating * n) + currentRating/ n+1;
	private Rating calculateRating(Rating existingRating, RatingDto ratingDto) {
		float newRating = ((existingRating.getAvgRating() * existingRating.getNoOfVotes()) + ratingDto.getRating())
				/ (existingRating.getNoOfVotes() + 1);
		existingRating.setAvgRating(newRating);
		existingRating.setNoOfVotes(existingRating.getNoOfVotes() + 1);
		return existingRating;
	}
}

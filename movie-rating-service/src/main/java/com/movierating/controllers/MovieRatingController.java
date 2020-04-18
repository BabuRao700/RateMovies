package com.movierating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import com.movierating.dtos.RatingDto;
import com.movierating.services.MovieRatingServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/rating-api")
public class MovieRatingController {
	
	private final MovieRatingServiceInterface movieRatingService;
	
	@Autowired
	public MovieRatingController(MovieRatingServiceInterface movieRatingService) {
		this.movieRatingService=movieRatingService;
	}
	
	@PostMapping(path = "/rating")
	public ResponseEntity<RatingDto> saveRating(@RequestBody RatingDto ratingDto)
	{
		RatingDto ratingDtoResponse= movieRatingService.saveRating(ratingDto);
		return new ResponseEntity<>(ratingDtoResponse, HttpStatus.OK);
	}

	@GetMapping(path = "/ratings")
	public ResponseEntity<RatingDto> getMovieRating(@RequestParam String movieId)
	{
		RatingDto ratingDto= movieRatingService.getRating(Integer.parseInt(movieId));
		return new ResponseEntity<>(ratingDto, HttpStatus.OK);
	}
}

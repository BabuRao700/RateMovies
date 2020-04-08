package com.movierating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movierating.dtos.RatingDto;
import com.movierating.services.MovieRatingServiceInterface;

@RestController
@RequestMapping(value="/rating")
public class MovieRatingController {
	
	private final MovieRatingServiceInterface movieRatingService;
	
	@Autowired
	public MovieRatingController(MovieRatingServiceInterface movieRatingService) {
		// TODO Auto-generated constructor stub
		this.movieRatingService=movieRatingService;
	}
	
	@RequestMapping(value = "/Save", method = RequestMethod.POST)
	public ResponseEntity<RatingDto> saveRaing(RatingDto ratingDto)
	{
		RatingDto ratingDtoresponse= this.movieRatingService.SaveRating(ratingDto);
		
		return new ResponseEntity<RatingDto>(ratingDtoresponse,HttpStatus.OK);
	}
	@RequestMapping(value = "/Get", method = RequestMethod.GET)
	public ResponseEntity<RatingDto> getMovieRating(int movieId)
	{
		RatingDto ratingDtoresponse= this.movieRatingService.GetRating(movieId);
		
		return new ResponseEntity<RatingDto>(ratingDtoresponse,HttpStatus.OK);
	}
	
	

}

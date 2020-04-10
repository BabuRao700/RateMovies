package com.movierating.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.movierating.domain.RatingEntity;
import com.movierating.dtos.RatingDto;
import com.movierating.repository.MovieRatingRepository;

public class MovieRatingService implements MovieRatingServiceInterface {

	private final MovieRatingRepository movieRatingRepository;
	private final ModelMapper modelMapper;
	@Autowired
	public MovieRatingService(MovieRatingRepository movieRatingRepository, ModelMapper modelMapper) {
		this.movieRatingRepository=movieRatingRepository;
		this.modelMapper=modelMapper;
	}
	public RatingDto SaveRating(RatingDto ratingDto) {

		RatingEntity ratingEntity=this.modelMapper.map(ratingDto,RatingEntity.class);
		
		RatingEntity savedEntity=this.movieRatingRepository.save(ratingEntity);
		
		return modelMapper.map(savedEntity,RatingDto.class);
	}

	public RatingDto GetRating(int ratingId) {

		Optional<RatingEntity> availableRatingEntity=this.movieRatingRepository.findById(ratingId);
		
		return modelMapper.map(availableRatingEntity.get(),RatingDto.class);//TODO Need to convert optional mapper
	}

}

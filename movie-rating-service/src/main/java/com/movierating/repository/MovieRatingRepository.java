package com.movierating.repository;

import org.springframework.data.repository.CrudRepository;

import com.movierating.domain.RatingEntity;

public interface MovieRatingRepository extends  CrudRepository<RatingEntity,Integer> {

}

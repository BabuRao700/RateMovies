package com.movierating.repository;

import com.movierating.domain.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRatingRepository extends CrudRepository<Rating, Integer> {

    Rating findByMovieId(int movieId);
}

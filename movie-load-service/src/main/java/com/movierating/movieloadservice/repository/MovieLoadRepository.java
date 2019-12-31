package com.movierating.movieloadservice.repository;

import com.movierating.movieloadservice.models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieLoadRepository extends CrudRepository<Movie, Long> {
}

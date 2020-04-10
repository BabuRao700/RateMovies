package com.movierating.commentsservice.repository;

import com.movierating.commentsservice.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends CrudRepository<Review, Integer> {

    List<Review> findByMovieId(Integer movieId);
}

package com.movierating.commentsservice.services;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.movierating.commentsservice.Review;
import com.movierating.commentsservice.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    public void createReview(Review review) {
        commentsRepository.save(review);
    }

    public List<Review> getReviewsByMovieId(Integer movieId) {
        List<Review> reviews = new ArrayList<>();
        commentsRepository.findAllById(new ArrayList<>(movieId)).forEach(eachReview -> {
            reviews.add(eachReview);
        });
        return reviews;
    }
}

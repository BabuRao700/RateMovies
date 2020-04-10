package com.movierating.commentsservice.services;

import com.movierating.commentsservice.Review;
import com.movierating.commentsservice.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    public void createReview(Review review) {
        review.setPostedTime(LocalDateTime.now().toString());
        commentsRepository.save(review);
    }

    public List<Review> getReviewsByMovieId(Integer movieId) {
        return commentsRepository.findByMovieId(movieId);
    }
}

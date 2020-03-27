package com.movierating.commentsservice.services;

import com.movierating.commentsservice.Review;
import com.movierating.commentsservice.repository.CommentsRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {


    @Autowired
    private CommentsRepository commentsRepository;

    public void createReview(Review review) {
        commentsRepository.save(review);
    }
}

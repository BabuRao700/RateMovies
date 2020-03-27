package com.movierating.commentsservice.controller;

import com.google.gson.Gson;
import com.movierating.commentsservice.Review;
import com.movierating.commentsservice.services.CommentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/reviews-service")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @PostMapping(path = "/review")
    public ResponseEntity.BodyBuilder createReview(@RequestBody Review review) {
        try {
            commentsService.createReview(review);
            log.info("review saved for {0}", review.getMovieName());
            return ResponseEntity.status(HttpStatus.CREATED);
        } catch(Exception e) {
            log.error("problem saving review");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/reviews")
    public ResponseEntity<String> getReviews(@RequestParam String movieId) {
        List<Review> reviewList = commentsService.getReviewsByMovieId(Integer.parseInt(movieId));
        return new ResponseEntity<>(new Gson().toJson(reviewList), HttpStatus.OK);
    }


}

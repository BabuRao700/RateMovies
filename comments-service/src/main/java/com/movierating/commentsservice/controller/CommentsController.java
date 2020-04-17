package com.movierating.commentsservice.controller;

import com.google.gson.Gson;
import com.movierating.commentsservice.HttpResponse;
import com.movierating.commentsservice.Review;
import com.movierating.commentsservice.services.CommentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/reviews-api")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @PostMapping(path = "/review")
    public ResponseEntity<String> createReview(@RequestBody Review review) {
        try {
            commentsService.createReview(review);
            log.info("review saved for {0}", review.getMovieName());
            return ResponseEntity.ok(new Gson().toJson(HttpResponse.builder().message("created")));
        } catch(Exception e) {
            log.error("problem saving review");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Gson().toJson(HttpResponse.builder().message("problem saving record")));
        }
    }

    @GetMapping(path = "/reviews")
    public ResponseEntity<String> getReviews(@RequestParam String movieId) {
        List<Review> reviewList = commentsService.getReviewsByMovieId(Integer.parseInt(movieId));
        return new ResponseEntity<>(new Gson().toJson(reviewList), HttpStatus.OK);
    }


}

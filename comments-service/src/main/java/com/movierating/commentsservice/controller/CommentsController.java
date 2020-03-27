package com.movierating.commentsservice.controller;

import com.movierating.commentsservice.Review;
import com.movierating.commentsservice.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(path = "/reviews-service")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @PostMapping(path = "/review")
    public ResponseEntity createReview(@RequestBody Review review) {
        commentsService.createReview(review);
        return ResponseEntity.ok("review created");
    }


}

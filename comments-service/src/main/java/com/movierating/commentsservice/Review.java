package com.movierating.commentsservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REVIEWS")
public class Review {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer ID;

    @Column(name = "MOVIE_ID")
    private Integer movieId;

    @Column(name = "MOVIE_NAME")
    private String movieName;

    @Column(name = "REVIEW")
    private String review;

    @Column(name = "POSTED_TIME")
    private String postedTime;
}

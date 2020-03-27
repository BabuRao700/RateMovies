package com.movierating.commentsservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REVIEWS")
public class Review {
    @Id
    @Column(name = "MOVIE_ID")
    private Integer movieId;

    @Column(name = "MOVIE_NAME")
    private String movieName;

    @Column(name = "REVIEW")
    private String review;
}

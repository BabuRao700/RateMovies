package com.movierating.movieloadservice.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MOVIES")
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long movieId;

    @Column(name = "MOVIE_ID")
    private String id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "ORIGINAL_TITILE")
    private String originalTitle;

    @Column(name = "RELEASE_DATE")
    private String releaseDate;

    @Column(name = "POSTER_PATH")
    private String posterPath;

    @Column(name = "ORIGINAL_LANGUAGE")
    private String originalLanguage;

    @Column(name = "ADULT")
    private Boolean adult;

    @Column(name = "OVERVIEW", length = 1000)
    private String overview;

}

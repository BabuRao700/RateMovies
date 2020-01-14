package com.movierating.movieloadservice.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.movierating.movieloadservice.Constants;
import com.movierating.movieloadservice.models.Movie;
import com.movierating.movieloadservice.models.MovieDBMovie;
import com.movierating.movieloadservice.movieapi.MovieService;
import com.movierating.movieloadservice.services.MovieLoadService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/movieapi")
public class MovieLoadController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieLoadService movieLoadService;

    @GetMapping(path = "/currentPlayingMovies")
    public ResponseEntity<String> getCurrentPlayingMovies() {
        log.info("calling Movie Data base api manually...");
        try {
            List<MovieDBMovie> movies = movieService.getCurrentlyPlayingMovies();
            return new ResponseEntity<>(getGson().toJson(movies), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            log.info("error while fetching results from movie DB api...");
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/movies")
    public ResponseEntity<String> getCurrentMovies() {
        try {
            log.info("Fetching movies.....");
            List<Movie> movies = movieLoadService.getMovies();
            return new ResponseEntity<>(getGson().toJson(movies), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            log.info("error while fetching movies from DB");
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/get-image-with-media-type", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getMoviePoster(@RequestParam("movieName") String movieName) throws IOException {
        File image = new File(Constants.imagesSavedLocation + movieName + ".jpg");
        InputStream imageStream = FileUtils.openInputStream(image);
        return new ResponseEntity<>(IOUtils.toByteArray(imageStream), HttpStatus.ACCEPTED);
    }

    public Gson getGson() {
        return new GsonBuilder().setPrettyPrinting().create();
    }
}

package com.movierating.movieloadservice.services;

import com.movierating.movieloadservice.models.Movie;
import com.movierating.movieloadservice.models.MovieDBMovie;
import com.movierating.movieloadservice.movieapi.MovieService;
import com.movierating.movieloadservice.repository.MovieLoadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MovieLoadService {

    @Autowired
    private MovieLoadRepository movieLoadRepository;

    @Autowired
    private MovieService movieService;

    @PostConstruct
    public void loadCurrentlyPlayingMovies() {
        List<MovieDBMovie> movieList = movieService.getCurrentlyPlayingMovies();
        List<Movie> movies = getAllMovies(movieList);
        movieLoadRepository.saveAll(movies);
        log.info("movies loaded to database.....");
    }

    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movieLoadRepository.findAll().forEach(m -> movies.add(m));
        return movies;
    }

    private List<Movie> getAllMovies(List<MovieDBMovie> moviesFromService) {
        List<Movie> movies = new ArrayList<>();
        moviesFromService.stream()
                .forEach( m -> {
                    Movie movie = new Movie();
                    BeanUtils.copyProperties(m, movie);
                    movies.add(movie);
                });

        return movies;
    }
}

package com.movierating.movieloadservice.Config;


import com.movierating.movieloadservice.services.MovieLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;

@Configuration
@EnableScheduling
public class MovieConfiguration {

    @Autowired
    private MovieLoadService movieLoadService;

    @Scheduled(cron = "0 0 8 * * *")
    private void getMoviesFromPublicApi() {
        movieLoadService.loadCurrentlyPlayingMovies();
    }
}

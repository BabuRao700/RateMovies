package com.movierating.movieloadservice.Config;


import com.movierating.movieloadservice.services.MovieLoadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@Configuration
@EnableScheduling
public class MovieConfiguration {

    @Autowired
    private MovieLoadService movieLoadService;

    @Scheduled(cron = "0 0 8 * * *")
    private void getMoviesFromPublicApi() {
        movieLoadService.loadCurrentlyPlayingMovies();
        log.info("cron job executed!!");
    }
}

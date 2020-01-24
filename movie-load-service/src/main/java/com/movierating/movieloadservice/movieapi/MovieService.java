package com.movierating.movieloadservice.movieapi;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.movierating.movieloadservice.models.MovieDBMovie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sun.misc.Request;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class MovieService {

    public static final String movieApiLink = "https://api.themoviedb.org/3/movie";
    public static final String movieImagesBaseLink = "https://image.tmdb.org/t/p/";
    public static final String movieApiKey = "?api_key=54e58be691740d0226952d4209acd233";
    public static final String imageSize = "w400";


    public List<MovieDBMovie> getCurrentlyPlayingMovies() {
        String endPoint = "/now_playing";
        String apiUrl = movieApiLink + endPoint + movieApiKey;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(apiUrl, String.class);
        String results = getResultString(response);

        Type listType = new TypeToken<List<MovieDBMovie>>(){}.getType();
        List<MovieDBMovie> movieList = new Gson().fromJson(results, listType);

        log.info("Public Api responded with the response:", results);
        return movieList;
    }

    private String getResultString(String response) {
        JsonParser parser = new JsonParser();
        return parser.parse(response)
                .getAsJsonObject()
                .get("results")
                .toString();
    }

    public ResponseEntity<byte[]> getImageByPosterPath(String posterPath) {
        HttpHeaders headers = new HttpHeaders();
        String movieImagePath = movieImagesBaseLink + imageSize + posterPath;
        RestTemplate restTemplate = new RestTemplate();

        List<MediaType> acceptableMediaTypes = new ArrayList<>();
        restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());
        acceptableMediaTypes.add(MediaType.IMAGE_JPEG);
        acceptableMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Request> httpEntity = new HttpEntity<Request>(headers);
        ResponseEntity<byte[]> res = restTemplate.exchange(movieImagePath, HttpMethod.GET, httpEntity, byte[].class, "1");
        return res;
    }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from '../models/movie';
import { Review } from '../models/review';
import { Rating } from '../models/rating';


@Injectable({
  providedIn: 'root'
})
export class MoviedataService {
  host: string = 'http://localhost:8080';
  movieServiceUrl: string =  this.host + '/movie-service/movie-api/movies';
  reviewServiceUrl: string = this.host + '/review-service/reviews-api';
  ratingServiceUrl: string = this.host + '/rating-service/rating-api';

  constructor(private http: HttpClient) { }

  getMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.movieServiceUrl); 
  }

  saveReviews(review: Review): Observable<Review> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
   return this.http.post<Review>(this.reviewServiceUrl + '/review', review, httpOptions);
  }

  getReviewsById(id: string): Observable<Review[]> {
    let params = new HttpParams().set('movieId', id);
    return this.http.get<Review[]>(this.reviewServiceUrl + '/reviews', { params: params });
  }

  saveMovieRating(rating: Rating): Observable<Rating> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.http.post<Rating>(this.ratingServiceUrl + '/rating', rating, httpOptions);
  }

  getMovieRatingById(id: string): Observable<Rating>  {
    let params = new HttpParams().set('movieId', id);
    return this.http.get<Rating>(this.ratingServiceUrl + '/ratings', { params: params });
  }

}

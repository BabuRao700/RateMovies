import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from '../models/movie';
import { Review } from '../models/review';


@Injectable({
  providedIn: 'root'
})
export class MoviedataService {
  movieServiceUrl: string = 'http://localhost:8080/movie-service/movie-api/movies';
  reviewServiceUrl: string = 'http://localhost:8080/review-service/reviews-api';

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

}

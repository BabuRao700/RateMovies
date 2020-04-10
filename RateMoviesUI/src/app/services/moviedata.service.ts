import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from '../models/movie';
import { Review } from '../models/review';
import { error } from 'protractor';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MoviedataService {

  constructor(private http: HttpClient) { }

  getMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>('http://localhost:8080/movieapi/movies'); 
  }

  saveReviews(review: Review): Observable<Review> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
   return this.http.post<Review>('http://localhost:8081/reviews-service/review', review, httpOptions);
  }

  getReviewsById(id: string): Observable<Review[]> {
    let params = new HttpParams().set('movieId', id);
    return this.http.get<Review[]>('http://localhost:8081/reviews-service/reviews', { params: params });
  }

}

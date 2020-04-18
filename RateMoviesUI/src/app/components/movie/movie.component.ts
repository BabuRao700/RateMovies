import { Component, OnInit, Input } from '@angular/core';
import { Movie } from '../../models/movie';
import { ImageService } from '../../services/image.service';
import { DomSanitizer } from '@angular/platform-browser';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { RateReviewDialogComponent } from '../rate-review-dialog/rate-review-dialog.component';
import { MoviedataService } from '../../services/moviedata.service';
import { Review } from '../../models/review';
import { error } from 'protractor';
import { Rating } from 'src/app/models/rating';


export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
}

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {

  selectedMovie: Movie;
  rating: number;
  review: string;
  reviews: Review [] = [];
  reviewed = false;
  movieRating: number = 0;

  constructor(private imageService: ImageService, 
    private movieDataService: MoviedataService,
    private domSanitizer : DomSanitizer, 
    public dialog: MatDialog) { }

  ngOnInit() {
    this.selectedMovie = history.state.data;
    this.imageService.getImage(this.selectedMovie.title)
      .subscribe(image => {
        const url = window.URL.createObjectURL(image);
        const safeUrl = this.domSanitizer.bypassSecurityTrustUrl(url);
        this.selectedMovie.poster = safeUrl;
      }, (error) => console.log("error while getting images", error))
    this.getReviews(this.selectedMovie.movieId);
    this.getMovieRating(this.selectedMovie.movieId);
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(RateReviewDialogComponent, {
      width: '500px',
      data: { rating: this.rating, review: this.review }
    });

    dialogRef.afterClosed().subscribe(result => {
      let savedReview: Review = {
        movieId: this.selectedMovie.movieId,
        movieName: this.selectedMovie.title,
        review: result[0],
        postedTime: ''
      };
      let savedRating: Rating = {
        movieId: this.selectedMovie.movieId,
        rating: result[1]
      }
      this.movieDataService.saveReviews(savedReview).subscribe(
        (data) => this.getReviews(this.selectedMovie.movieId)
      )
      this.movieDataService.saveMovieRating(savedRating).subscribe(
        (data) => this.movieRating = data.rating
      )
    });
  }

  getReviews(movieId: number) {
    this.movieDataService.getReviewsById(movieId.toString()).subscribe(
      (data) => {
        this.reviews = data
        data.length !== 0 ? this.reviewed = true: this.reviewed = false;
      }
    )
  }

  getMovieRating(movieId: number) {
    this.movieDataService.getMovieRatingById(movieId.toString()).subscribe(
      (data) => {
        this.movieRating = data.rating;
      }
    )
  }

}

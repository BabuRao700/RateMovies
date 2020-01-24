import { Component, OnInit } from '@angular/core';
import { MoviedataService } from '../services/moviedata.service';
import { Movie } from '../models/movie';
import { error } from 'util';
import { ImageService } from '../services/image.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-movielist',
  templateUrl: './movielist.component.html',
  styleUrls: ['./movielist.component.css']
})
export class MovielistComponent implements OnInit {

  movies: Movie [] = [];
  numbersList: number [] = [];
  selectedMovie?: Movie; 

  constructor(private moviedataService: MoviedataService, private imageService: ImageService, private domSanitizer : DomSanitizer) { 
    this.moviedataService.getMovies().subscribe((data: Movie[]) => {
      this.movies = data;
      this.getAllImages(this.movies);

  },
  (error) => console.log(error))
  }

  ngOnInit() {
  }

  getAllImages(movieList: Movie []) {
    movieList.forEach( movie => { debugger
      this.imageService.getImage(movie.title)
      .subscribe(image => {
        const url = window.URL.createObjectURL(image);
        const safeUrl = this.domSanitizer.bypassSecurityTrustUrl(url);
        movie.poster = safeUrl;
        console.log(safeUrl);
      }, (error) => console.log("error while getting images", error))
    } )
  }

  reviewTheMovie(movie: Movie) {
    this.selectedMovie = movie;
  }

}

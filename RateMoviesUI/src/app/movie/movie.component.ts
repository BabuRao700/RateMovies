import { Component, OnInit, Input } from '@angular/core';
import { Movie } from '../models/movie';
import { ImageService } from '../services/image.service';
import { DomSanitizer } from '@angular/platform-browser';


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

  tiles: Tile[] = [
    {text: 'Three', cols: 2, rows: 1, color: '#DDBDF1'},
    {text: 'Four', cols: 2, rows: 2, color: 'lightpink'},
  ];
  
  selectedMovie: Movie;

  constructor(private imageService: ImageService, private domSanitizer : DomSanitizer) { }

  ngOnInit() {
    this.selectedMovie = history.state.data;
    this.imageService.getImage(this.selectedMovie.title)
      .subscribe(image => {
        const url = window.URL.createObjectURL(image);
        const safeUrl = this.domSanitizer.bypassSecurityTrustUrl(url);
        this.selectedMovie.poster = safeUrl;
      }, (error) => console.log("error while getting images", error))
    console.log(this.selectedMovie.poster);
  }

}

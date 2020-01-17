import { Component, OnInit } from '@angular/core';
import { MoviedataService } from '../services/moviedata.service';
import { Movie } from '../models/movie';
import { error } from 'util';

@Component({
  selector: 'app-movielist',
  templateUrl: './movielist.component.html',
  styleUrls: ['./movielist.component.css']
})
export class MovielistComponent implements OnInit {

  movies: Movie [] = [];

  constructor(private moviedataService: MoviedataService) { }

  ngOnInit() {
    this.moviedataService.getMovies().subscribe((data:Movie) => {
        this.movies.push(data);
        console.log(data);
    },
    (error) => console.log(error))
  }
}

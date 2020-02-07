import { Component, OnInit, Input } from '@angular/core';
import { Movie } from '../models/movie';
import { ImageService } from '../services/image.service';
import { DomSanitizer } from '@angular/platform-browser';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { RateReviewDialogComponent } from '../rate-review-dialog/rate-review-dialog.component';


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

  constructor(private imageService: ImageService, private domSanitizer : DomSanitizer, public dialog: MatDialog) { }

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


  openDialog(): void {
    const dialogRef = this.dialog.open(RateReviewDialogComponent, {
      width: '500px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

}

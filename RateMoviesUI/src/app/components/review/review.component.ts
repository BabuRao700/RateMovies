import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { Review } from 'src/app/models/review';
import { MatPaginator, MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  @Input("reviews") reviews: Review [] = [];
  
  reviwCount: number = 0;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  dataSource = new MatTableDataSource<Review>(this.reviews);

  displayedColumns: string[] = ['number', 'reviews'];
  
  constructor() { }

  ngOnInit() {
    this.reviwCount = this.reviews.length;
    this.dataSource.paginator = this.paginator;
  }

}

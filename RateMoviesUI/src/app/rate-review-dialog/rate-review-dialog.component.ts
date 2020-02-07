import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

export interface DialogData {
  rating: number;
  review: string;
}

@Component({
  selector: 'app-rate-review-dialog',
  templateUrl: './rate-review-dialog.component.html',
  styleUrls: ['./rate-review-dialog.component.css']
})
export class RateReviewDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<RateReviewDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) { }

  ngOnInit() {
  }

}

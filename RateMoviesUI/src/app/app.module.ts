import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MovielistComponent } from './movielist/movielist.component';
import { MovieComponent } from './movie/movie.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MoviematerialModule } from './moviematerial/moviematerial.module';
import {FlexLayoutModule} from "@angular/flex-layout";
import { ToolbarComponent } from './toolbar/toolbar.component';
import { ReviewsComponent } from './reviews/reviews.component';
import { BarRatingModule } from "ngx-bar-rating";
import { CommentsComponent } from './comments/comments.component';
import { RateReviewDialogComponent } from './rate-review-dialog/rate-review-dialog.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    MovielistComponent,
    MovieComponent,
    HomeComponent,
    ToolbarComponent,
    ReviewsComponent,
    CommentsComponent,
    RateReviewDialogComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MoviematerialModule,
    FlexLayoutModule,
    BarRatingModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [RateReviewDialogComponent]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MovielistComponent } from './components/movielist/movielist.component';
import { MovieComponent } from './components/movie/movie.component';
import { HomeComponent } from './components/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MoviematerialModule } from './moviematerial/moviematerial.module';
import {FlexLayoutModule} from "@angular/flex-layout";
import { ToolbarComponent } from './components/toolbar/toolbar.component';
import { BarRatingModule } from "ngx-bar-rating";
import { RateReviewDialogComponent } from './components/rate-review-dialog/rate-review-dialog.component';
import { FormsModule } from '@angular/forms';
import { ReviewComponent } from './components/review/review.component';

@NgModule({
  declarations: [
    AppComponent,
    MovielistComponent,
    MovieComponent,
    HomeComponent,
    ToolbarComponent,
    RateReviewDialogComponent,
    ReviewComponent
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

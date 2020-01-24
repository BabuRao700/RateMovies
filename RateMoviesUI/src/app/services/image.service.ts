import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import {DomSanitizer} from '@angular/platform-browser';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  constructor(private http: HttpClient, private _sanitizer:DomSanitizer) { }

  getImage(imageName: string): Observable<Blob> { debugger
    return this.http.get("http://localhost:8080/movieapi/get-image-with-media-type", {
      params: new HttpParams().set('movieName', imageName),
      responseType: 'blob'
  })
  }
}

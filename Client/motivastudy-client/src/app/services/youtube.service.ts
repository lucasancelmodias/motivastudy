import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class YoutubeService {

    apiKey : string = 'AIzaSyBz4fTMkjkLWD_eyZFSs2h151DDbIybL6k';

    constructor(public http:HttpClient){}


    getVideosPlaylist(playlistId): Observable<Object>{ 
        let url ='https://youtube.googleapis.com/youtube/v3/playlistItems?key='+this.apiKey+'&part=snippet%2CcontentDetails&maxResults=25&playlistId='+ playlistId
        return this.http.get(url)
        .pipe(map((res) => {
         return res;
        }))
    }

}   

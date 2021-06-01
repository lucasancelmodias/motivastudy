import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class YoutubeService {

    apiKey : string = 'AIzaSyBf_w-gztU8dev9LoMXOxtF5GsmKIsMf1I';

    constructor(public http:HttpClient){}

    getVideosForChanel(channel, maxResults): Observable<Object> {
        let url = 'https://www.googleapis.com/youtube/v3/search?key=' + this.apiKey + '&channelId=' + channel + '&order=date&part=snippet &type=video,id&maxResults=' + maxResults
        return this.http.get(url)
          .pipe(map((res) => {
            return res;
          }))
    }

    getVideosPlaylist(playlistId): Observable<Object>{
        let url = 'https://www.googleapis.com/youtube/v3/search?key=' + this.apiKey + '&playlistId'+ playlistId + '&order=date&part=snippet'
        
        return this.http.get(url)
        .pipe(map((res) => {
         return res;
        }))
    }

}   

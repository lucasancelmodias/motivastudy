import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { NgxSpinnerService } from 'ngx-spinner';
import { YoutubeService } from 'src/app/services/youtube.service';
import { takeUntil } from 'rxjs/operators';

@Component({
  selector: 'app-videos',
  templateUrl: './videos.component.html',
  styleUrls: ['./videos.component.css']
})
export class VideosComponent  {

  videos: any[];
  private unsubscribe$: Subject<any> = new Subject();
  
  constructor(private spinner: NgxSpinnerService, private youTubeService: YoutubeService) {}

  ngOnInit() {
    this.spinner.show()
    setTimeout(()=>
    {
      this.spinner.hide()
    },3000)
    this.videos = [];
    this.youTubeService
      .getVideosForChanel('UC_LtA_EtCr7Jp5ofOsYt18g', 15)
      //.getVideosPlaylist('PL0-S2gYArrI77Ty7DQvcEzN0fEiARxFA0')
      .pipe(takeUntil(this.unsubscribe$))
      .subscribe(lista => {
        for (let element of lista["items"]) {
          this.videos.push(element)
        }

      });
  }

}
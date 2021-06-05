import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { NgxSpinnerService } from 'ngx-spinner';
import { YoutubeService } from 'src/app/services/youtube.service';
import { takeUntil } from 'rxjs/operators';


@Component({
  selector: 'app-video-aula',
  templateUrl: './video-aula.component.html',
  styleUrls: ['./video-aula.component.css']
})
export class VideoAulaComponent implements OnInit {

  videos: any[];
  tamanhoPlalist: number;
  contador: number;
  public unsubscribe$: Subject<any> = new Subject();

  constructor(public spinner: NgxSpinnerService, public youTubeService: YoutubeService) { }

  ngOnInit(): void {
    this.contador = 0;
    this.spinner.show()
    setTimeout(()=>
    {
      this.spinner.hide()
    },3000)
    this.videos = [];
    this.youTubeService
      .getVideosPlaylist('PLoBA7bAZxZEZmPrO0egK-iebY8LOlLoUQ')
      .subscribe(lista => {
        this.videos = lista['items']
        this.tamanhoPlalist = this.videos.length
        console.log(lista)
      });
  }

  getVideoUrl(videoId){
    return `https://www.youtube.com/embed/${videoId}`
  }

  proximoVideo(){
    console.log('tamanho '+ this.tamanhoPlalist);
    if(this.contador>=this.tamanhoPlalist - 1){
      this.contador = 0
    }else{
      this.contador++
    } 
    console.log('contador '+ this.contador)
    return this.contador
  }

  videoAnterior(){
    if(this.contador==0) return this.contador = this.tamanhoPlalist - 1
    return this.contador-- 
  }
  
}

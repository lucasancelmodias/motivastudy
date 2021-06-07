import { Component, Input, OnInit, OnChanges, SimpleChanges } from '@angular/core';
import { Subject } from 'rxjs';
import { NgxSpinnerService } from 'ngx-spinner';
import { YoutubeService } from 'src/app/services/youtube.service';
import { takeUntil } from 'rxjs/operators';
import { Topico } from 'src/app/models/Topico';


@Component({
  selector: 'app-video-aula',
  templateUrl: './video-aula.component.html',
  styleUrls: ['./video-aula.component.css']
})
export class VideoAulaComponent implements OnInit, OnChanges {
  @Input() topico: Topico
  videos: any[];
  tamanhoPlaylist: number;
  contador: number;
  public unsubscribe$: Subject<any> = new Subject();

  constructor(public spinner: NgxSpinnerService, public youTubeService: YoutubeService) { }
  ngOnChanges(changes: SimpleChanges): void {
    if(!changes.topico.currentValue){
      return
    }
    this.youTubeService.getVideosPlaylist(this.topico.urlPlaylist)
      .subscribe((response) => {
        this.videos = response['items']
        this.tamanhoPlaylist = this.videos.length
        console.log(response)
      })
  }

  ngOnInit(): void {
    this.contador = 0;
    this.spinner.show()
    // setTimeout(()=>
    // {
    //   this.spinner.hide()
    // },3000)
    // this.videos = [];
    // this.youTubeService
    //   .getVideosPlaylist('PLoBA7bAZxZEZmPrO0egK-iebY8LOlLoUQ')
    //   .subscribe(lista => {
    //     this.videos = lista['items']
    //     this.tamanhoPlaylist = this.videos.length
    //     console.log(lista)
    //   });
  }

  getVideoUrl(videoId){
    return `https://www.youtube.com/embed/${videoId}`
  }

  proximoVideo(){
    console.log('tamanho '+ this.tamanhoPlaylist);
    if(this.contador>=this.tamanhoPlaylist - 1){
      this.contador = 0
    }else{
      this.contador++
    }
    console.log('contador '+ this.contador)
    return this.contador
  }

  videoAnterior(){
    if(this.contador==0) return this.contador = this.tamanhoPlaylist - 1
    return this.contador--
  }

}

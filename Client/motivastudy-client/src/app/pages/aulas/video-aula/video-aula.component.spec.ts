import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VideoAulaComponent } from './video-aula.component';

describe('VideoAulaComponent', () => {
  let component: VideoAulaComponent;
  let fixture: ComponentFixture<VideoAulaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VideoAulaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VideoAulaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

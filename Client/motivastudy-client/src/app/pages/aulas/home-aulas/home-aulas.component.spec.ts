import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeAulasComponent } from './home-aulas.component';

describe('HomeAulasComponent', () => {
  let component: HomeAulasComponent;
  let fixture: ComponentFixture<HomeAulasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeAulasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeAulasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

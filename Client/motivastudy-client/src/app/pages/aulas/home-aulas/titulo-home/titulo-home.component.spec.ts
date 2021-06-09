import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TituloHomeComponent } from './titulo-home.component';

describe('TituloHomeComponent', () => {
  let component: TituloHomeComponent;
  let fixture: ComponentFixture<TituloHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TituloHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TituloHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

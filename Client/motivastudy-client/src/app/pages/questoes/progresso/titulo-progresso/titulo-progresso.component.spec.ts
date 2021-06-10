import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TituloProgressoComponent } from './titulo-progresso.component';

describe('TituloProgressoComponent', () => {
  let component: TituloProgressoComponent;
  let fixture: ComponentFixture<TituloProgressoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TituloProgressoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TituloProgressoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

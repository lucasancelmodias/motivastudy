import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MetodosEstudoComponent } from './metodos-estudo.component';

describe('MetodosEstudoComponent', () => {
  let component: MetodosEstudoComponent;
  let fixture: ComponentFixture<MetodosEstudoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MetodosEstudoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MetodosEstudoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

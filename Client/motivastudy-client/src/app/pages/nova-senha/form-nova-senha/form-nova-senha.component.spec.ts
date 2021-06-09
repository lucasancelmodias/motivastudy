import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormNovaSenhaComponent } from './form-nova-senha.component';

describe('FormNovaSenhaComponent', () => {
  let component: FormNovaSenhaComponent;
  let fixture: ComponentFixture<FormNovaSenhaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormNovaSenhaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormNovaSenhaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

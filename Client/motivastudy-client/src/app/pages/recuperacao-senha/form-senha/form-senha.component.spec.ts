import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormSenhaComponent } from './form-senha.component';

describe('FormSenhaComponent', () => {
  let component: FormSenhaComponent;
  let fixture: ComponentFixture<FormSenhaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormSenhaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormSenhaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormLComponent } from './form-l.component';

describe('FormLComponent', () => {
  let component: FormLComponent;
  let fixture: ComponentFixture<FormLComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormLComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormLComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

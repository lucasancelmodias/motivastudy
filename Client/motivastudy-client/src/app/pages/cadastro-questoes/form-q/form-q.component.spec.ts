import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormQComponent } from './form-q.component';

describe('FormQComponent', () => {
  let component: FormQComponent;
  let fixture: ComponentFixture<FormQComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormQComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormQComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

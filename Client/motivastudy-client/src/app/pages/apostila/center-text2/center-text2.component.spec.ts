import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CenterText2Component } from './center-text2.component';

describe('CenterText2Component', () => {
  let component: CenterText2Component;
  let fixture: ComponentFixture<CenterText2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CenterText2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CenterText2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

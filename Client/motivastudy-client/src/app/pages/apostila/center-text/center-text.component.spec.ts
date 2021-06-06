import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CenterTextComponent } from './center-text.component';

describe('CenterTextComponent', () => {
  let component: CenterTextComponent;
  let fixture: ComponentFixture<CenterTextComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CenterTextComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CenterTextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

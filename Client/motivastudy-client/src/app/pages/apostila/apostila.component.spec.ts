import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApostilaComponent } from './apostila.component';

describe('ApostilaComponent', () => {
  let component: ApostilaComponent;
  let fixture: ComponentFixture<ApostilaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApostilaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApostilaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

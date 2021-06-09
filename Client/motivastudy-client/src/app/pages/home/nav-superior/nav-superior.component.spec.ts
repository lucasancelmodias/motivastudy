import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavSuperiorComponent } from './nav-superior.component';

describe('NavSuperiorComponent', () => {
  let component: NavSuperiorComponent;
  let fixture: ComponentFixture<NavSuperiorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavSuperiorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavSuperiorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

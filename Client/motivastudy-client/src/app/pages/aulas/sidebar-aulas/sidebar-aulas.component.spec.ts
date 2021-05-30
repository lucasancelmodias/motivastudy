import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarAulasComponent } from './sidebar-aulas.component';

describe('SidebarAulasComponent', () => {
  let component: SidebarAulasComponent;
  let fixture: ComponentFixture<SidebarAulasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SidebarAulasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SidebarAulasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

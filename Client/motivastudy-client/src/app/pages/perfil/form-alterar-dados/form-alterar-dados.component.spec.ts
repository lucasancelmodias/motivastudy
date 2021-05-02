import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAlterarDadosComponent } from './form-alterar-dados.component';

describe('FormAlterarDadosComponent', () => {
  let component: FormAlterarDadosComponent;
  let fixture: ComponentFixture<FormAlterarDadosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormAlterarDadosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormAlterarDadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroQuestoesComponent } from './cadastro-questoes.component';

describe('CadastroQuestoesComponent', () => {
  let component: CadastroQuestoesComponent;
  let fixture: ComponentFixture<CadastroQuestoesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroQuestoesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroQuestoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

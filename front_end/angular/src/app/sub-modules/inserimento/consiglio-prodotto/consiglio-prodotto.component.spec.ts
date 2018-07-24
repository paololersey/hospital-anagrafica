import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsiglioProdottoComponent } from './consiglio-prodotto.component';

describe('ConsiglioProdottoComponent', () => {
  let component: ConsiglioProdottoComponent;
  let fixture: ComponentFixture<ConsiglioProdottoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsiglioProdottoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsiglioProdottoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

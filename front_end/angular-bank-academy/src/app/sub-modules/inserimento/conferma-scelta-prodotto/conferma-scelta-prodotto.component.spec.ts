import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfermaSceltaProdottoComponent } from './conferma-scelta-prodotto.component';

describe('ConfermaSceltaProdottoComponent', () => {
  let component: ConfermaSceltaProdottoComponent;
  let fixture: ComponentFixture<ConfermaSceltaProdottoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConfermaSceltaProdottoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfermaSceltaProdottoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

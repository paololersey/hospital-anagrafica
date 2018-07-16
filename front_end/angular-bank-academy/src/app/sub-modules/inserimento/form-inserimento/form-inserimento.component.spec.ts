import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormInserimentoComponent } from './form-inserimento.component';

describe('FormInserimentoComponent', () => {
  let component: FormInserimentoComponent;
  let fixture: ComponentFixture<FormInserimentoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormInserimentoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormInserimentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

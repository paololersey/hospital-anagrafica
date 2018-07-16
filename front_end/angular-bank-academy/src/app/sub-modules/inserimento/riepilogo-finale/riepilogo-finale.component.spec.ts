import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RiepilogoFinaleComponent } from './riepilogo-finale.component';

describe('RiepilogoFinaleComponent', () => {
  let component: RiepilogoFinaleComponent;
  let fixture: ComponentFixture<RiepilogoFinaleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RiepilogoFinaleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RiepilogoFinaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

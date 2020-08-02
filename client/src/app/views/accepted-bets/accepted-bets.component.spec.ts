import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AcceptedBetsComponent } from './accepted-bets.component';

describe('AcceptedBetsComponent', () => {
  let component: AcceptedBetsComponent;
  let fixture: ComponentFixture<AcceptedBetsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AcceptedBetsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AcceptedBetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

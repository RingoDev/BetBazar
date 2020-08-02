import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActiveBetsComponent } from './active-bets.component';

describe('ActiveBetsComponent', () => {
  let component: ActiveBetsComponent;
  let fixture: ComponentFixture<ActiveBetsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActiveBetsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActiveBetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

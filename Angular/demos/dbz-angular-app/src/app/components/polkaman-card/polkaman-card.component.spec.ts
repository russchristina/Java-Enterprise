import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PolkamanCardComponent } from './polkaman-card.component';

describe('PolkamanCardComponent', () => {
  let component: PolkamanCardComponent;
  let fixture: ComponentFixture<PolkamanCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PolkamanCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PolkamanCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

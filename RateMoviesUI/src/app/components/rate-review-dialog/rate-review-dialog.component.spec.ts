import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RateReviewDialogComponent } from './rate-review-dialog.component';

describe('RateReviewDialogComponent', () => {
  let component: RateReviewDialogComponent;
  let fixture: ComponentFixture<RateReviewDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RateReviewDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RateReviewDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

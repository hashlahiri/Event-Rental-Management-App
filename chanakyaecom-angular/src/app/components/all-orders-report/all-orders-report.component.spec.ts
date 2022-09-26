import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllOrdersReportComponent } from './all-orders-report.component';

describe('AllOrdersReportComponent', () => {
  let component: AllOrdersReportComponent;
  let fixture: ComponentFixture<AllOrdersReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllOrdersReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllOrdersReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

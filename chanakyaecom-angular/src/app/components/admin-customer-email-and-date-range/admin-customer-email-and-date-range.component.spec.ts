import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCustomerEmailAndDateRangeComponent } from './admin-customer-email-and-date-range.component';

describe('AdminCustomerEmailAndDateRangeComponent', () => {
  let component: AdminCustomerEmailAndDateRangeComponent;
  let fixture: ComponentFixture<AdminCustomerEmailAndDateRangeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminCustomerEmailAndDateRangeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCustomerEmailAndDateRangeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

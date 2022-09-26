import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCustomerEmailReceiptComponent } from './admin-customer-email-receipt.component';

describe('AdminCustomerEmailReceiptComponent', () => {
  let component: AdminCustomerEmailReceiptComponent;
  let fixture: ComponentFixture<AdminCustomerEmailReceiptComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminCustomerEmailReceiptComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCustomerEmailReceiptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminOrderTrackingReceiptComponent } from './admin-order-tracking-receipt.component';

describe('AdminOrderTrackingReceiptComponent', () => {
  let component: AdminOrderTrackingReceiptComponent;
  let fixture: ComponentFixture<AdminOrderTrackingReceiptComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminOrderTrackingReceiptComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminOrderTrackingReceiptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

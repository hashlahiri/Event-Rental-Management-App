import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminOrdersByMonthAndYearComponent } from './admin-orders-by-month-and-year.component';

describe('AdminOrdersByMonthAndYearComponent', () => {
  let component: AdminOrdersByMonthAndYearComponent;
  let fixture: ComponentFixture<AdminOrdersByMonthAndYearComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminOrdersByMonthAndYearComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminOrdersByMonthAndYearComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminOrdersForTodayComponent } from './admin-orders-for-today.component';

describe('AdminOrdersForTodayComponent', () => {
  let component: AdminOrdersForTodayComponent;
  let fixture: ComponentFixture<AdminOrdersForTodayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminOrdersForTodayComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminOrdersForTodayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAllUsersReportComponent } from './admin-all-users-report.component';

describe('AdminAllUsersReportComponent', () => {
  let component: AdminAllUsersReportComponent;
  let fixture: ComponentFixture<AdminAllUsersReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAllUsersReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAllUsersReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

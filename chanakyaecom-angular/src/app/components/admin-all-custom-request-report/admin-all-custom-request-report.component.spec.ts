import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAllCustomRequestReportComponent } from './admin-all-custom-request-report.component';

describe('AdminAllCustomRequestReportComponent', () => {
  let component: AdminAllCustomRequestReportComponent;
  let fixture: ComponentFixture<AdminAllCustomRequestReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAllCustomRequestReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAllCustomRequestReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

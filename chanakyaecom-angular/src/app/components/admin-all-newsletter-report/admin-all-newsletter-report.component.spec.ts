import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAllNewsletterReportComponent } from './admin-all-newsletter-report.component';

describe('AdminAllNewsletterReportComponent', () => {
  let component: AdminAllNewsletterReportComponent;
  let fixture: ComponentFixture<AdminAllNewsletterReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAllNewsletterReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAllNewsletterReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

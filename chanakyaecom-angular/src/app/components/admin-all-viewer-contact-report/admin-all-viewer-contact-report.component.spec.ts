import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAllViewerContactReportComponent } from './admin-all-viewer-contact-report.component';

describe('AdminAllViewerContactReportComponent', () => {
  let component: AdminAllViewerContactReportComponent;
  let fixture: ComponentFixture<AdminAllViewerContactReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAllViewerContactReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAllViewerContactReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

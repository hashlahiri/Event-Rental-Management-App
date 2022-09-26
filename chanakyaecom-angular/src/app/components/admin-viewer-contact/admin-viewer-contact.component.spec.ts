import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminViewerContactComponent } from './admin-viewer-contact.component';

describe('AdminViewerContactComponent', () => {
  let component: AdminViewerContactComponent;
  let fixture: ComponentFixture<AdminViewerContactComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminViewerContactComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminViewerContactComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

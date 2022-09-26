import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCustomRequestsComponent } from './admin-custom-requests.component';

describe('AdminCustomRequestsComponent', () => {
  let component: AdminCustomRequestsComponent;
  let fixture: ComponentFixture<AdminCustomRequestsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminCustomRequestsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCustomRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

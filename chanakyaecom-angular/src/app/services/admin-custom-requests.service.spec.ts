import { TestBed } from '@angular/core/testing';

import { AdminCustomRequestsService } from './admin-custom-requests.service';

describe('AdminCustomRequestsService', () => {
  let service: AdminCustomRequestsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminCustomRequestsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

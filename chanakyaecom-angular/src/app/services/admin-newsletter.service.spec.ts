import { TestBed } from '@angular/core/testing';

import { AdminNewsletterService } from './admin-newsletter.service';

describe('AdminNewsletterService', () => {
  let service: AdminNewsletterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminNewsletterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

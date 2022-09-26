import { TestBed } from '@angular/core/testing';

import { AdminViewerContactService } from './admin-viewer-contact.service';

describe('AdminViewerContactService', () => {
  let service: AdminViewerContactService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminViewerContactService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

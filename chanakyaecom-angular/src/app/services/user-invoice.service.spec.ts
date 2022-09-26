import { TestBed } from '@angular/core/testing';

import { UserInvoiceService } from './user-invoice.service';

describe('UserInvoiceService', () => {
  let service: UserInvoiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserInvoiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { UserReceiptService } from './user-receipt.service';

describe('UserReceiptService', () => {
  let service: UserReceiptService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserReceiptService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

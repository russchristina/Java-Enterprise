import { TestBed } from '@angular/core/testing';

import { PolkamanService } from './polkaman.service';

describe('PolkamanService', () => {
  let service: PolkamanService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PolkamanService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

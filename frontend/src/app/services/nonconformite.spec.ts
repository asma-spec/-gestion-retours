import { TestBed } from '@angular/core/testing';

import { Nonconformite } from './nonconformite';

describe('Nonconformite', () => {
  let service: Nonconformite;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Nonconformite);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

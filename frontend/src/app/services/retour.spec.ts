import { TestBed } from '@angular/core/testing';

import { Retour } from './retour';

describe('Retour', () => {
  let service: Retour;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Retour);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { MoviedataService } from './moviedata.service';

describe('MoviedataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MoviedataService = TestBed.get(MoviedataService);
    expect(service).toBeTruthy();
  });
});

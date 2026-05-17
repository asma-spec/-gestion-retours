import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NonconformiteForm } from './nonconformite-form';

describe('NonconformiteForm', () => {
  let component: NonconformiteForm;
  let fixture: ComponentFixture<NonconformiteForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NonconformiteForm],
    }).compileComponents();

    fixture = TestBed.createComponent(NonconformiteForm);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

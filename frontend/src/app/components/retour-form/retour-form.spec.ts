import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RetourForm } from './retour-form';

describe('RetourForm', () => {
  let component: RetourForm;
  let fixture: ComponentFixture<RetourForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RetourForm],
    }).compileComponents();

    fixture = TestBed.createComponent(RetourForm);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

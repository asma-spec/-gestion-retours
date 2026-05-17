import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RetourList } from './retour-list';

describe('RetourList', () => {
  let component: RetourList;
  let fixture: ComponentFixture<RetourList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RetourList],
    }).compileComponents();

    fixture = TestBed.createComponent(RetourList);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

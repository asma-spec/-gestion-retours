import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NonconformiteList } from './nonconformite-list';

describe('NonconformiteList', () => {
  let component: NonconformiteList;
  let fixture: ComponentFixture<NonconformiteList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NonconformiteList],
    }).compileComponents();

    fixture = TestBed.createComponent(NonconformiteList);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

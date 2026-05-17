import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoriqueForm } from './historique-form';

describe('HistoriqueForm', () => {
  let component: HistoriqueForm;
  let fixture: ComponentFixture<HistoriqueForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HistoriqueForm],
    }).compileComponents();

    fixture = TestBed.createComponent(HistoriqueForm);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

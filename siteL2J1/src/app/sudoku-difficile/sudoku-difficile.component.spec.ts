import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SudokuDifficileComponent } from './sudoku-difficile.component';

describe('SudokuDifficileComponent', () => {
  let component: SudokuDifficileComponent;
  let fixture: ComponentFixture<SudokuDifficileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SudokuDifficileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SudokuDifficileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

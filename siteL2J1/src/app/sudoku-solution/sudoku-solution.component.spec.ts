import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SudokuSolutionComponent } from './sudoku-solution.component';

describe('SudokuSolutionComponent', () => {
  let component: SudokuSolutionComponent;
  let fixture: ComponentFixture<SudokuSolutionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SudokuSolutionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SudokuSolutionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

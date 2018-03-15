import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SudokuNormalComponent } from './sudoku-normal.component';

describe('SudokuNormalComponent', () => {
  let component: SudokuNormalComponent;
  let fixture: ComponentFixture<SudokuNormalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SudokuNormalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SudokuNormalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

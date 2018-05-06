import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SudokuIndexComponent } from './sudoku-index.component';

describe('SudokuIndexComponent', () => {
  let component: SudokuIndexComponent;
  let fixture: ComponentFixture<SudokuIndexComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SudokuIndexComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SudokuIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

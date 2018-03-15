import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SudokuFacileComponent } from './sudoku-facile.component';

describe('SudokuFacileComponent', () => {
  let component: SudokuFacileComponent;
  let fixture: ComponentFixture<SudokuFacileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SudokuFacileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SudokuFacileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

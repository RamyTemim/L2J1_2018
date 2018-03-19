import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MorpionGrilleComponent } from './morpion-grille.component';

describe('MorpionGrilleComponent', () => {
  let component: MorpionGrilleComponent;
  let fixture: ComponentFixture<MorpionGrilleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MorpionGrilleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MorpionGrilleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MorpionJ1vsIaComponent } from './morpion-j1vs-ia.component';

describe('MorpionJ1vsIaComponent', () => {
  let component: MorpionJ1vsIaComponent;
  let fixture: ComponentFixture<MorpionJ1vsIaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MorpionJ1vsIaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MorpionJ1vsIaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

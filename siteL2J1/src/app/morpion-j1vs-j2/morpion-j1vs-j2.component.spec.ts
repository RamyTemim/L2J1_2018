import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MorpionJ1vsJ2Component } from './morpion-j1vs-j2.component';

describe('MorpionJ1vsJ2Component', () => {
  let component: MorpionJ1vsJ2Component;
  let fixture: ComponentFixture<MorpionJ1vsJ2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MorpionJ1vsJ2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MorpionJ1vsJ2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

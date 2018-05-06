import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MorpionIndexComponent } from './morpion-index.component';

describe('MorpionIndexComponent', () => {
  let component: MorpionIndexComponent;
  let fixture: ComponentFixture<MorpionIndexComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MorpionIndexComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MorpionIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

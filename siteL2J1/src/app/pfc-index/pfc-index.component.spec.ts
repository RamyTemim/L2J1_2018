import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PfcIndexComponent } from './pfc-index.component';

describe('PfcIndexComponent', () => {
  let component: PfcIndexComponent;
  let fixture: ComponentFixture<PfcIndexComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PfcIndexComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PfcIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

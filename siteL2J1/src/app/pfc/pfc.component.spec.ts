import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PfcComponent } from './pfc.component';

describe('PfcComponent', () => {
  let component: PfcComponent;
  let fixture: ComponentFixture<PfcComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PfcComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PfcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

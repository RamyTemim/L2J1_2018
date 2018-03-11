import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuteurComponent } from './auteur.component';

describe('AuteurComponent', () => {
  let component: AuteurComponent;
  let fixture: ComponentFixture<AuteurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuteurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuteurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

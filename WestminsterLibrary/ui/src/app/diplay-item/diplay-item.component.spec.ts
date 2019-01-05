import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiplayItemComponent } from './diplay-item.component';

describe('DiplayItemComponent', () => {
  let component: DiplayItemComponent;
  let fixture: ComponentFixture<DiplayItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiplayItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiplayItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

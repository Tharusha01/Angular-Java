import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GenrateItemComponent } from './genrate-item.component';

describe('GenrateItemComponent', () => {
  let component: GenrateItemComponent;
  let fixture: ComponentFixture<GenrateItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GenrateItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GenrateItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComparisonSectorComponent } from './comparison-sector.component';

describe('ComparisonSectorComponent', () => {
  let component: ComparisonSectorComponent;
  let fixture: ComponentFixture<ComparisonSectorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComparisonSectorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComparisonSectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

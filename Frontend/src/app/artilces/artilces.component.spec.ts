import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtilcesComponent } from './artilces.component';

describe('ArtilcesComponent', () => {
  let component: ArtilcesComponent;
  let fixture: ComponentFixture<ArtilcesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArtilcesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtilcesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

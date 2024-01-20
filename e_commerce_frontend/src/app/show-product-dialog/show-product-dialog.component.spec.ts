import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowProductDialogComponent } from './show-product-dialog.component';

describe('ShowProductDialogComponent', () => {
  let component: ShowProductDialogComponent;
  let fixture: ComponentFixture<ShowProductDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowProductDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowProductDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

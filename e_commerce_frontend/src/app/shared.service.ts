import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  private grandTotalSource = new BehaviorSubject<number>(0);
  currentGrandTotal = this.grandTotalSource.asObservable();

  constructor() { }

  setGrandTotal(grandTotal: number): void {
    this.grandTotalSource.next(grandTotal); // Update the current grand total
  }

  // If you need to retrieve the current value without subscribing
  getGrandTotalValue(): number {
    return this.grandTotalSource.value;
  }


}

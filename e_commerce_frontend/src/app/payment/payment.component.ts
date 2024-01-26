import { Component, ElementRef, OnInit, ViewChild, NgZone, } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SharedService } from '../shared.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  grandTotal = 0;

  @ViewChild('paymentRef', {static:true}) paymentRef!: ElementRef;

  constructor(private route: ActivatedRoute,
    private router: Router,
    private sharedService: SharedService,
    private location: Location) { }

  ngOnInit(): void {
    this.sharedService.currentGrandTotal.subscribe(total => {
    this.grandTotal = total;

    window.paypal.Buttons(
      {
        createOrder: (data: any, actions: any) =>{
          return actions.order.create({
            purchase_units: [
              {
                amount: {
                  value: this.grandTotal.toString(),
                  currentcy_code: 'USD'
                }
              }
            ]
          });
        },
        onApprove: (data: any, actions: any) => {
          return actions.order.capture().then((details: any) => {
            if(details.status === 'COMPLETED') {
              this.router.navigate(['orderConfirm']);
            }
          })
        },
        onError: (error:any) => {
          console.log(error);
        }
        }
    ).render(this.paymentRef.nativeElement);
    });
  }

  onCancel(): void {
    this.location.back(); // Uses the browser's history to go back to the previous page
  }

}

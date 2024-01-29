import { Component, OnInit } from '@angular/core';
import { ProductService } from '../_services/product.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../_model/product.model';
import { DomSanitizer } from '@angular/platform-browser';
import { ImageProcessingService } from '../image-processing.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})


export class CartComponent implements OnInit {

  displayedColumns: string[] = ['Name', 'Discounted Price', 'Image', 'Action'];

  cartDetails: any[] = [];
  product: Product;

  constructor(private productService: ProductService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private sanitizer: DomSanitizer
    ) { }

  ngOnInit(): void {
    this.product = this.activatedRoute.snapshot.data['product'];
    this.getCartDetails();
  }

  getCartDetails() {
    this.productService.getCartDetails()
    .subscribe(
      (response: any[]) => {
        console.log(response);
        console.log(this.product)
        this.cartDetails = response;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  getSanitizedImageUrl(base64Data: string) {
    const imageUrl = 'data:image/webp;base64,' + base64Data; 
    return this.sanitizer.bypassSecurityTrustUrl(imageUrl);
  }

  
  checkout() {
    this.router.navigate(['/buyProduct', {
      isSingleProductCheckout: false, id: 0
    }]);
  }

  delete(cartId) {
    this.productService.deleteCartItem(cartId).subscribe(
      (resp) => {
        console.log(resp);
        this.getCartDetails();
      }, (err) => {
        console.log(err);
      }
    )
  }
}

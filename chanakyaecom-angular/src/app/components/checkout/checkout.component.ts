import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Luv2ShopFormService } from 'src/app/services/luv2-shop-form.service';
import { Country } from 'src/app/common/country';
import { State } from 'src/app/common/state';
import { EventRentalManageValidators } from '../../validators/event-rental-manage-validators';
import { CartService } from 'src/app/services/cart.service';
import { CheckoutService } from 'src/app/services/checkout.service';
import { Router } from '@angular/router';
import { Order } from 'src/app/common/order';
import { OrderItem } from 'src/app/common/order-item';
import { Purchase } from 'src/app/common/purchase';
import { User } from 'src/app/common/user';
import { UserService } from 'src/app/services/user.service';
import { UserInfoService } from 'src/app/services/user-info.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  checkoutFormGroup: FormGroup;

  totalPrice: number = 0;
  totalQuantity: number = 0;

  creditCardYears: number[] = [];
  creditCardMonths: number[] = [];

  countries: Country[] = [];

  shippingAddressStates: State[] = [];
  billingAddressStates: State[] = [];

  storage: Storage = localStorage;

  //user information for form fill
  user: String = "";
  public userInfo = new User();

  constructor(private formBuilder: FormBuilder,
    private luv2ShopFormService: Luv2ShopFormService,
    private cartService: CartService,
    private checkoutService: CheckoutService,
    private userService: UserService,
    private userInfoService: UserInfoService,
    private router: Router) {

      this.user = this.userService.getUsername();
    }

  ngOnInit(): void {

    this.user = this.userService.getUsername();
    //console.warn(this.user);

    //get user information part
    this.userInfoService.getUserInformation(this.user).subscribe(
      data => {
        this.userInfo = data;
      }
    );
    //console.warn(JSON.stringify(this.userInfo.userEmail));

    this.reviewCartDetails();

    //read users email  address from browser storage
    const theEmail = this.userInfo.userEmail;
    //console.warn(theEmail);

    this.checkoutFormGroup = this.formBuilder.group({
      customer: this.formBuilder.group({
        /*firstName: new FormControl('',
          [Validators.required,
          Validators.minLength(2),
          Validators.maxLength(25),
          Validators.pattern('[a-zA-Z ]*'),
          EventRentalManageValidators.notOnlyWhitespace]),

        lastName: new FormControl('',
          [Validators.required,
          Validators.minLength(2),
          Validators.maxLength(25),
          Validators.pattern('[a-zA-Z ]*'),
          EventRentalManageValidators.notOnlyWhitespace]),*/

        /*email: new FormControl(theEmail,
          [Validators.required,
          Validators.minLength(5),
          Validators.maxLength(255),
          Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')])*/
      }),
      shippingAddress: this.formBuilder.group({
        street: new FormControl('',
          [Validators.required,
          Validators.minLength(2),
          Validators.maxLength(100),
          Validators.pattern('[a-zA-Z-0-9/, ]*'),
          EventRentalManageValidators.notOnlyWhitespace]),
        city: new FormControl('',
          [Validators.required,
          Validators.minLength(4),
          Validators.maxLength(20),
          Validators.pattern('[a-zA-Z ]*'),
          EventRentalManageValidators.notOnlyWhitespace]),
        state: new FormControl('', [Validators.required]),
        country: new FormControl('', [Validators.required]),
        pinCode: new FormControl('',
          [Validators.required,
          Validators.minLength(6),
          Validators.maxLength(6),
          Validators.pattern('^[0-9]*'),
          EventRentalManageValidators.notOnlyWhitespace])
      }),
      billingAddress: this.formBuilder.group({
        street: new FormControl('',
          [Validators.required,
          Validators.minLength(2),
          Validators.maxLength(100),
          Validators.pattern('[a-zA-Z-0-9/, ]*'),
          EventRentalManageValidators.notOnlyWhitespace]),
        city: new FormControl('',
          [Validators.required,
          Validators.minLength(4),
          Validators.maxLength(20),
          Validators.pattern('[a-zA-Z ]*'),
          EventRentalManageValidators.notOnlyWhitespace]),
        state: new FormControl('', [Validators.required]),
        country: new FormControl('', [Validators.required]),
        pinCode: new FormControl('',
          [Validators.required,
          Validators.minLength(6),
          Validators.maxLength(6),
          Validators.pattern('^[0-9]*'),
          EventRentalManageValidators.notOnlyWhitespace])
      }),
      creditCard: this.formBuilder.group({
        cardType: new FormControl('', [Validators.required]),
        nameOnCard: new FormControl('',
          [Validators.required,
          Validators.minLength(2),
          Validators.maxLength(50),
          Validators.pattern('[a-zA-Z ]*'),
          EventRentalManageValidators.notOnlyWhitespace]),
        cardNumber: new FormControl('',
          [Validators.required,
          Validators.pattern('[0-9]{16}'),
          EventRentalManageValidators.notOnlyWhitespace]),
        securityCode: new FormControl('',
          [Validators.required,
          Validators.pattern('[0-9]{3}'),
          EventRentalManageValidators.notOnlyWhitespace]),
        expirationMonth: [''],
        expirationYear: ['']
      })

    });

    // populate credit card months

    const startMonth: number = new Date().getMonth() + 1;
    //console.log("startMonth: " + startMonth);

    this.luv2ShopFormService.getCreditCardMonths(startMonth).subscribe(
      data => {
        //console.log("Retrieved credit card months: " + JSON.stringify(data));
        this.creditCardMonths = data;
      }
    );

    // populate credit card years

    this.luv2ShopFormService.getCreditCardYears().subscribe(
      data => {
        //console.log("Retrieved credit card years: " + JSON.stringify(data));
        this.creditCardYears = data;
      }
    );

    // populate countries

    this.luv2ShopFormService.getCountries().subscribe(
      data => {
        //console.log("Retrieved countries: " + JSON.stringify(data));
        this.countries = data;
      }
    );
  }

  reviewCartDetails() {

    // subscribe to cartService.totalQuantity
    this.cartService.totalQuantity.subscribe(
      totalQuantity => this.totalQuantity = totalQuantity
    );

    // subscribe to cartService.totalPrice
    this.cartService.totalPrice.subscribe(
      totalPrice => this.totalPrice = totalPrice
    );

  }

  //get firstName() { return this.checkoutFormGroup.get('customer.firstName'); }
  //get lastName() { return this.checkoutFormGroup.get('customer.lastName'); }
  //get email() { return this.checkoutFormGroup.get('customer.email'); }
  get firstName() { /*return this.checkoutFormGroup.get('customer.firstName');*/return this.userInfo.userFirstName }
  get lastName() { /*return this.checkoutFormGroup.get('customer.lastName');*/return this.userInfo.userLastName }
  get email() { /*return this.checkoutFormGroup.get('customer.email');*/ return this.userInfo.userEmail }

  get shippingAddressStreet() { return this.checkoutFormGroup.get('shippingAddress.street'); }
  get shippingAddressCity() { return this.checkoutFormGroup.get('shippingAddress.city'); }
  get shippingAddressState() { return this.checkoutFormGroup.get('shippingAddress.state'); }
  get shippingAddressPinCode() { return this.checkoutFormGroup.get('shippingAddress.pinCode'); }
  get shippingAddressCountry() { return this.checkoutFormGroup.get('shippingAddress.country'); }

  get billingAddressStreet() { return this.checkoutFormGroup.get('billingAddress.street'); }
  get billingAddressCity() { return this.checkoutFormGroup.get('billingAddress.city'); }
  get billingAddressState() { return this.checkoutFormGroup.get('billingAddress.state'); }
  get billingAddressPinCode() { return this.checkoutFormGroup.get('billingAddress.pinCode'); }
  get billingAddressCountry() { return this.checkoutFormGroup.get('billingAddress.country'); }

  get creditCardType() { return this.checkoutFormGroup.get('creditCard.cardType'); }
  get creditCardNameOnCard() { return this.checkoutFormGroup.get('creditCard.nameOnCard'); }
  get creditCardNumber() { return this.checkoutFormGroup.get('creditCard.cardNumber'); }
  get creditCardSecurityCode() { return this.checkoutFormGroup.get('creditCard.securityCode'); }



  copyShippingAddressToBillingAddress(event) {

    if (event.target.checked) {
      this.checkoutFormGroup.controls.billingAddress
        .setValue(this.checkoutFormGroup.controls.shippingAddress.value);

      // bug fix for states
      this.billingAddressStates = this.shippingAddressStates;

    }
    else {
      this.checkoutFormGroup.controls.billingAddress.reset();

      // bug fix for states
      this.billingAddressStates = [];
    }

  }

  onSubmit() {
    //console.log("Handling the submit button");

    if (this.checkoutFormGroup.invalid) {
      console.log('Invalid');
      this.checkoutFormGroup.markAllAsTouched();
      return;
    }

    // set up order
    let order = new Order();
    order.totalPrice = this.totalPrice;
    order.totalQuantity = this.totalQuantity;
    

    // get cart items
    const cartItems = this.cartService.cartItems;

    // create orderItems from cartItems
    // - long way
    /*
    let orderItems: OrderItem[] = [];
    for (let i=0; i < cartItems.length; i++) {
      orderItems[i] = new OrderItem(cartItems[i]);
    }
    */

    // - short way of doing the same thingy
    let orderItems: OrderItem[] = cartItems.map(tempCartItem => new OrderItem(tempCartItem));

    // set up purchase
    let purchase = new Purchase();

    // populate purchase - customer
    purchase.customer = this.checkoutFormGroup.controls['customer'].value;
    purchase.customer.email = this.userInfo.userEmail;
    purchase.customer.firstName = this.userInfo.userFirstName;
    purchase.customer.lastName = this.userInfo.userLastName;

    // populate purchase - shipping address
    purchase.shippingAddress = this.checkoutFormGroup.controls['shippingAddress'].value;
    const shippingState: State = JSON.parse(JSON.stringify(purchase.shippingAddress.state));
    const shippingCountry: Country = JSON.parse(JSON.stringify(purchase.shippingAddress.country));
    purchase.shippingAddress.state = shippingState.name;
    purchase.shippingAddress.country = shippingCountry.name;
    purchase.shippingAddress.zipCode = purchase.shippingAddress.pinCode;
    

    // populate purchase - billing address
    purchase.billingAddress = this.checkoutFormGroup.controls['billingAddress'].value;
    const billingState: State = JSON.parse(JSON.stringify(purchase.billingAddress.state));
    const billingCountry: Country = JSON.parse(JSON.stringify(purchase.billingAddress.country));
    purchase.billingAddress.state = billingState.name;
    purchase.billingAddress.country = billingCountry.name;
    purchase.billingAddress.zipCode = purchase.billingAddress.pinCode;
    

    // populate purchase - order and orderItems
    purchase.order = order;
    purchase.orderItems = orderItems;


    //console.log(JSON.stringify(purchase));
    // call REST API via the CheckoutService
    this.checkoutService.placeOrder(purchase).subscribe({
      next: response => {
        //alert(`Your order has been received.\nOrder tracking number: ${response.orderTrackingNumber}`);
        this.purchaseAlert(response.orderTrackingNumber);
        // reset cart
        this.resetCart();

      },
      error: err => {
        alert(`There was an error: ${err.message}`);
      }
    }
    );

  }

  resetCart() {
    // reset cart data
    this.cartService.cartItems = [];
    this.cartService.totalPrice.next(0);
    this.cartService.totalQuantity.next(0);

    // reset the form
    this.checkoutFormGroup.reset();

    // navigate back to the products page
    this.router.navigateByUrl("/products");
  }

  handleMonthsAndYears() {

    const creditCardFormGroup = this.checkoutFormGroup.get('creditCard');

    const currentYear: number = new Date().getFullYear();
    const selectedYear: number = Number(creditCardFormGroup.value.expirationYear);

    // if the current year equals the selected year, then start with the current month

    let startMonth: number;

    if (currentYear === selectedYear) {
      startMonth = new Date().getMonth() + 1;
    }
    else {
      startMonth = 1;
    }

    this.luv2ShopFormService.getCreditCardMonths(startMonth).subscribe(
      data => {
        //console.log("Retrieved credit card months: " + JSON.stringify(data));
        this.creditCardMonths = data;
      }
    );
  }

  getStates(formGroupName: string) {

    const formGroup = this.checkoutFormGroup.get(formGroupName);

    const countryCode = formGroup.value.country.code;
    const countryName = formGroup.value.country.name;

    //console.log(`${formGroupName} country code: ${countryCode}`);
    //console.log(`${formGroupName} country name: ${countryName}`);

    this.luv2ShopFormService.getStates(countryCode).subscribe(
      data => {

        if (formGroupName === 'shippingAddress') {
          this.shippingAddressStates = data;
        }
        else {
          this.billingAddressStates = data;
        }

        // select first item by default
        formGroup.get('state').setValue(data[0]);
      }
    );
  }

  //purchase Alert 
  purchaseAlert(orderTrackNo) {

    Swal.fire({
      title: 'Thank You! Your order tracking number is: '+orderTrackNo,
      width: 450,
      padding: '3em',
      color: '#716add',
      background: '#fff',
      backdrop: `
        rgba(0,0,123,0.4)
        url()
        left top
        no-repeat
      `
    })

  }

}

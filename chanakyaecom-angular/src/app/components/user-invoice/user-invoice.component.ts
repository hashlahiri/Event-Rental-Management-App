import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminOrder } from 'src/app/common/admin-order';
import { OrderRecord } from 'src/app/common/order-record';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-invoice',
  templateUrl: './user-invoice.component.html',
  styleUrls: ['./user-invoice.component.css']
})
export class UserInvoiceComponent implements OnInit {

  public orderInfo: OrderRecord;
  public orderRecord: string;
  public today = new Date();
  public dateTime : any;
  public user : any;

  constructor(private router: Router, private userService: UserService) {

    let date = this.today.getFullYear()+'-'+(this.today.getMonth()+1)+'-'+this.today.getDate();
    let time = this.today.getHours() + ":" + this.today.getMinutes();
    this.dateTime = date+' '+time;

    //get username
    this.user = this.userService.getUsername();
   }

  ngOnInit(): void {

    this.orderRecord = window.sessionStorage.getItem("userOrderInvoice");

    console.warn(this.orderRecord);
    this.orderInfo = JSON.parse(this.orderRecord);

  }

  onBackClick() {

    window.sessionStorage.removeItem("userOrderInvoice");

    this.router.navigate(['/user']);
  }

}

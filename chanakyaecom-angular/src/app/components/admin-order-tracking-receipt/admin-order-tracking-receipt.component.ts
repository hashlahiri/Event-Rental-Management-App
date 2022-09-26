import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminOrder } from 'src/app/common/admin-order';

@Component({
  selector: 'app-admin-order-tracking-receipt',
  templateUrl: './admin-order-tracking-receipt.component.html',
  styleUrls: ['./admin-order-tracking-receipt.component.css']
})
export class AdminOrderTrackingReceiptComponent implements OnInit {

  public adminOrderRecord: AdminOrder;
  public orderRecord: string;
  public today = new Date();
  public dateTime : any;

  constructor(private router: Router) { 

    let date = this.today.getFullYear()+'-'+(this.today.getMonth()+1)+'-'+this.today.getDate();
    let time = this.today.getHours() + ":" + this.today.getMinutes();
    this.dateTime = date+' '+time;
  }

  ngOnInit(): void {

    this.orderRecord = window.sessionStorage.getItem("orderTrackingReceiptInformation");

    this.adminOrderRecord = JSON.parse(this.orderRecord);
  }

  onBackClick() {
    //remove the sessionStorage item
    window.sessionStorage.removeItem("orderTrackingReceiptInformation");

    this.router.navigate(["admin"]);
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminOrder } from 'src/app/common/admin-order';

@Component({
  selector: 'app-admin-orders-by-month-and-year',
  templateUrl: './admin-orders-by-month-and-year.component.html',
  styleUrls: ['./admin-orders-by-month-and-year.component.css']
})
export class AdminOrdersByMonthAndYearComponent implements OnInit {

  public adminOrderRecord: AdminOrder[];
  public orderRecordList: string;
  public today = new Date();
  public dateTime: any;

  constructor(private router: Router) {
    let date = this.today.getFullYear()+'-'+(this.today.getMonth()+1)+'-'+this.today.getDate();
    let time = this.today.getHours() + ":" + this.today.getMinutes();
    this.dateTime = date+' '+time;
   }

  ngOnInit(): void {

    this.orderRecordList = window.sessionStorage.getItem("customerOrderInfoDataList");

    this.adminOrderRecord = JSON.parse(this.orderRecordList);
  }

  onBackClick() {
    
    //remove the sessionStorage item
    window.sessionStorage.removeItem("customerOrderInfoDataList");
    
    this.router.navigate(["admin"]);
  }

}

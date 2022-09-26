import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminOrder } from 'src/app/common/admin-order';

@Component({
  selector: 'app-all-orders-report',
  templateUrl: './all-orders-report.component.html',
  styleUrls: ['./all-orders-report.component.css']
})
export class AllOrdersReportComponent implements OnInit {

  allOrdersList: AdminOrder[] = [];
  public today = new Date();
  public dateTime : any;
  constructor(private router: Router) {
    let date = this.today.getFullYear()+'-'+(this.today.getMonth()+1)+'-'+this.today.getDate();
    let time = this.today.getHours() + ":" + this.today.getMinutes();
    this.dateTime = date+' '+time;
   }

  ngOnInit(): void {

    this.allOrdersList = JSON.parse(window.sessionStorage.getItem("allOrdersList"));
  }

  onBackClick() {
    //remove the sessionStorage item
    window.sessionStorage.removeItem("allOrdersList");

    this.router.navigate(["admin"]);
  }

}

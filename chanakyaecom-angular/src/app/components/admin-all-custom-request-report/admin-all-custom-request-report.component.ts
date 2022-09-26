import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminCustomRequests } from 'src/app/common/admin-custom-requests';

@Component({
  selector: 'app-admin-all-custom-request-report',
  templateUrl: './admin-all-custom-request-report.component.html',
  styleUrls: ['./admin-all-custom-request-report.component.css']
})
export class AdminAllCustomRequestReportComponent implements OnInit {

  customRequestsList: AdminCustomRequests[] = [];
  public today = new Date();
  public dateTime : any;
  constructor(private router: Router) { 
    let date = this.today.getFullYear()+'-'+(this.today.getMonth()+1)+'-'+this.today.getDate();
    let time = this.today.getHours() + ":" + this.today.getMinutes();
    this.dateTime = date+' '+time;
  }

  ngOnInit(): void {

    this.customRequestsList = JSON.parse(window.sessionStorage.getItem("allCustomRequestsList"));
  }

  onBackClick() {
    //remove the sessionStorage item
    window.sessionStorage.removeItem("allCustomRequestsList");

    this.router.navigate(["admin"]);
  }

}

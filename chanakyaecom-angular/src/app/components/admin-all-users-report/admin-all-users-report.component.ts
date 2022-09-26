import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminUser } from 'src/app/common/admin-user';

@Component({
  selector: 'app-admin-all-users-report',
  templateUrl: './admin-all-users-report.component.html',
  styleUrls: ['./admin-all-users-report.component.css']
})
export class AdminAllUsersReportComponent implements OnInit {

  allUsersList: AdminUser[] =[];
  public today = new Date();
  public dateTime : any;
  constructor(private router: Router) {
    let date = this.today.getFullYear()+'-'+(this.today.getMonth()+1)+'-'+this.today.getDate();
    let time = this.today.getHours() + ":" + this.today.getMinutes();
    this.dateTime = date+' '+time;
   }

  ngOnInit(): void {

    this.allUsersList = JSON.parse(window.sessionStorage.getItem("allUsersList"));
  }

  onBackClick() {
    //remove the sessionStorage item
    window.sessionStorage.removeItem("allUsersList");

    this.router.navigate(["admin"]);
  }

}

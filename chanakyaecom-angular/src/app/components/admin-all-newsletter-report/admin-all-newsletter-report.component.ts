import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminNewsletter } from 'src/app/common/admin-newsletter';

@Component({
  selector: 'app-admin-all-newsletter-report',
  templateUrl: './admin-all-newsletter-report.component.html',
  styleUrls: ['./admin-all-newsletter-report.component.css']
})
export class AdminAllNewsletterReportComponent implements OnInit {

  newsletterList: AdminNewsletter[] = [];
  public today = new Date();
  public dateTime : any;

  constructor(private router: Router) {
    let date = this.today.getFullYear()+'-'+(this.today.getMonth()+1)+'-'+this.today.getDate();
    let time = this.today.getHours() + ":" + this.today.getMinutes();
    this.dateTime = date+' '+time;
  }

  ngOnInit(): void {

    this.newsletterList = JSON.parse(window.sessionStorage.getItem("allNewsletterDataList"));
  }

  onBackClick() {
    //remove the sessionStorage item
    window.sessionStorage.removeItem("allNewsletterDataList");

    this.router.navigate(["admin"]);
  }

}

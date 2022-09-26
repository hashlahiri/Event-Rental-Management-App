import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminViewerContact } from 'src/app/common/admin-viewer-contact';

@Component({
  selector: 'app-admin-all-viewer-contact-report',
  templateUrl: './admin-all-viewer-contact-report.component.html',
  styleUrls: ['./admin-all-viewer-contact-report.component.css']
})
export class AdminAllViewerContactReportComponent implements OnInit {

  viewerRequestList: AdminViewerContact[] =[];
  public today = new Date();
  public dateTime : any;

  constructor(private router: Router) {
    let date = this.today.getFullYear()+'-'+(this.today.getMonth()+1)+'-'+this.today.getDate();
    let time = this.today.getHours() + ":" + this.today.getMinutes();
    this.dateTime = date+' '+time;
   }

  ngOnInit(): void {

    this.viewerRequestList = JSON.parse(window.sessionStorage.getItem("allViewerContactRequestDataList"));
  }

  onBackClick() {
    //remove the sessionStorage item
    window.sessionStorage.removeItem("allViewerContactRequestDataList");

    this.router.navigate(["admin"]);
  }

}

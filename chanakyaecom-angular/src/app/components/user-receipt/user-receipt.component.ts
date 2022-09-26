import { Component, OnInit } from '@angular/core';
import { OrderRecord } from 'src/app/common/order-record';
import { UserReceiptService } from 'src/app/services/user-receipt.service';

@Component({
  selector: 'app-user-receipt',
  templateUrl: './user-receipt.component.html',
  styleUrls: ['./user-receipt.component.css']
})
export class UserReceiptComponent implements OnInit {

  public userInformationData: any;
  public userOrderInformationData: OrderRecord[] = [];

  public today = new Date();
  public dateTime : any;

  constructor(private userReceiptService: UserReceiptService) { 

    let date = this.today.getFullYear()+'-'+(this.today.getMonth()+1)+'-'+this.today.getDate();
    let time = this.today.getHours() + ":" + this.today.getMinutes();
    this.dateTime = date+' '+time;

  }

  ngOnInit() {

    this.userInformationData = this.userReceiptService.getUserReceiptInformation();
    console.warn(JSON.stringify(this.userInformationData));
    this.userOrderInformationData = this.userReceiptService.getUserOrderReceiptInformation();
    console.warn(JSON.stringify(this.userOrderInformationData));
  }

}

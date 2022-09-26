import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { UserInfoService } from '../../services/user-info.service';
import { User } from 'src/app/common/user';
import { Observable } from 'rxjs';
import { OrderRecord } from '../../common/order-record';
import { saveAs } from 'file-saver';
import { UserReceiptService } from '../../services/user-receipt.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user: String = "";
  userInfo = new User();

  //since its a list incoming
  orderInfoList: OrderRecord[] = [];

  message: string | undefined;

  constructor(
    private userService: UserService,
    private userInfoService: UserInfoService,
    private userReceiptService: UserReceiptService,
    private router: Router,
    private userInvoiceService: UserInfoService) {

    this.user = this.userService.getUsername();

  }

  ngOnInit() {

    this.forUser();

    this.getUserAndOrderInfo();

   }

  forUser() {
    this.userService.forUser().subscribe(
      (response) => {
        console.log(response);
        this.message = response;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  getUserAndOrderInfo() {
    //get user information part
    this.userInfoService.getUserInformation(this.user).subscribe(
      data => {
        this.userInfo = data;
        this.sendForReceiptGeneration(this.userInfo);
      }
    );

    //get user order history part
    this.userInfoService.getUserOrderInformation(this.user).subscribe(
      data => {
        this.orderInfoList = data;
        this.sendForReceiptOrderGeneration(this.orderInfoList);
      }
    );
  }

  downloadYourOrders(): void {
    this.userInfoService.downloadAllYourOrdersService(this.user)
      .subscribe(blob => saveAs(blob, 'yourOrders_' + new Date().toLocaleDateString() + new Date().toLocaleTimeString() + '.csv'));
  }


  sendForReceiptGeneration(data) {
    //calling the service to generate receipt
    console.log('Inside the user component sendForReceiptGeneration function: ');
    console.log(this.user);
    console.log(data.userEmail);
    this.userReceiptService.sendUserReceiptData(data);
  }

  sendForReceiptOrderGeneration(data) {

    this.userReceiptService.sendUserOrderReceiptData(data);
  }

  generateInvoice(data){

    window.sessionStorage.setItem("userOrderInvoice", JSON.stringify(data));
    
    this.router.navigate(['/userInvoice']);
  }

}

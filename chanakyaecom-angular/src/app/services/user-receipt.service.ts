import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderRecord } from '../common/order-record';
import { User } from '../common/user';

@Injectable({
  providedIn: 'root'
})
export class UserReceiptService {

  public userInformation = null;

  public orderInformationList: OrderRecord[] = [];

  constructor() { }

  public sendUserReceiptData(userInfo) {

    this.userInformation = userInfo;
    console.log('sendUserReceiptData called');
    console.warn(JSON.stringify(this.userInformation));
    
  }

  public sendUserOrderReceiptData(orderData) {

    this.orderInformationList = orderData;
    console.log('sendUserOrderReceiptData called');
    console.warn(JSON.stringify(this.orderInformationList));
  }

  public getUserReceiptInformation() {

    return this.userInformation;
  }

  public getUserOrderReceiptInformation() {

    return this.orderInformationList;
  }
}

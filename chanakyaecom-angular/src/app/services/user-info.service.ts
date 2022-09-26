import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { OrderRecord } from '../common/order-record';
import { User } from '../common/user';

@Injectable({
  providedIn: 'root'
})
export class UserInfoService {

  private userInfoUrl = environment.eventRentalManagementBaseUrl + '/user/getByUsername/?username=';

  private orderInfoUrl = environment.eventRentalManagementBaseUrl + '/orders/getCustomerOrders/list/?username=';

  private downloadYourOrdersUrl = environment.eventRentalManagementBaseUrl + '/orders/getAllUserOrdersCSVDownload/list/?username=';

  public userInfoFetched = new User();

  constructor(private httpClient: HttpClient) { }


  getUserInformation(username: String) : Observable<User> {
    
    let userInfoUrlFinal = this.userInfoUrl + username;
    
    return this.httpClient.get<User>(userInfoUrlFinal);
  }

  getUserOrderInformation(username: String) : Observable<OrderRecord[]> {

    let orderInfoUrlFinal = this.orderInfoUrl + username;
    //this.orderInfoUrl = this.orderInfoUrl + username;

    return this.httpClient.get<OrderRecord[]>(orderInfoUrlFinal);
  }

  downloadAllYourOrdersService(username: String) : Observable<Blob> {

    let downloadYourOrdersUrlFinal = this.downloadYourOrdersUrl + username;

    return this.httpClient.get(downloadYourOrdersUrlFinal, {
      responseType: 'blob'
    });
  }

}

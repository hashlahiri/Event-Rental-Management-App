import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AdminOrder } from '../common/admin-order';

@Injectable({
  providedIn: 'root'
})
export class AdminOrdersService {

  private getAllOrdersUrl = environment.eventRentalManagementBaseUrl + '/orders/getAllOrders/list/';

  private downloadAllOrdersUrl = environment.eventRentalManagementBaseUrl + '/orders/getAllOrdersCSVDownload/list/';

  private updateByOrderTrackingUrl = environment.eventRentalManagementBaseUrl + '/orders/updateStatusByOrderTrackingNumber/?orderTrackingNumber=';

  constructor(private httpClient: HttpClient) { }

  getAllOrderInformation() : Observable<AdminOrder[]> {

    return this.httpClient.get<AdminOrder[]>(this.getAllOrdersUrl);
  }

  downloadAllOrders() : Observable<Blob> {
    
    return this.httpClient.get(this.downloadAllOrdersUrl, {
      responseType: 'blob'
    });
  }
  
  onUpdateStatus(orderTrackingNumber, requestStatus) {

    let updateByOrderTrackingUrlFinal = this.updateByOrderTrackingUrl + orderTrackingNumber + '&requestStatus='+requestStatus;

    return this.httpClient.patch(updateByOrderTrackingUrlFinal, orderTrackingNumber);
  }

  
}

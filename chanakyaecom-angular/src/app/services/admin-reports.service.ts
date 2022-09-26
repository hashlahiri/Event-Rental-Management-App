import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AdminOrder } from '../common/admin-order';
import { OrderRecord } from '../common/order-record';

@Injectable({
  providedIn: 'root'
})
export class AdminReportsService {

  private orderTrackingNumberUrl = environment.eventRentalManagementBaseUrl + '/orders/getOrderInfoByOrderTrackingNumber/?orderTrackingNumber=';
  private byCustomerEmailUrl = environment.eventRentalManagementBaseUrl + '/orders/getCustomerOrdersByCustomerEmail/?customerEmail=';
  private byCustomerEmailAndDateRangeUrl = environment.eventRentalManagementBaseUrl + '/orders/getOrderByDateRangeAndEmail/?customerEmail=';
  private byMonthAndYearUrl = environment.eventRentalManagementBaseUrl + '/orders/getOrdersByMonthAndYear/?month=';
  private byTodayUrl = environment.eventRentalManagementBaseUrl + '/orders/getOrdersFromToday/';

  constructor(private httpClient: HttpClient) { }


  onOrderTrackingSubmissionReceiptGeneration(data) : Observable<AdminOrder> {

    let orderTrackingNumberUrlFinal = this.orderTrackingNumberUrl + data;

    return this.httpClient.get<AdminOrder>(orderTrackingNumberUrlFinal);

  } 

  onOrdersByEmailSubmissionReceiptGeneration(data) : Observable<AdminOrder[]> {

    let byCustomerEmailUrlFinal = this.byCustomerEmailUrl + data;

    return this.httpClient.get<AdminOrder[]>(byCustomerEmailUrlFinal);
  }

  onOrdersByEmailAndDateRangeSubmissionReceiptGeneration(customerEmail, startingDate, endingDate) : Observable<AdminOrder[]> {

    let byCustomerEmailAndDateRangeUrlFinal = this.byCustomerEmailAndDateRangeUrl + customerEmail + '&startDate=' + startingDate + '&endDate=' + endingDate;

    return this.httpClient.get<AdminOrder[]>(byCustomerEmailAndDateRangeUrlFinal);
  }

  onOrdersByMonthAndYearSubmissionReceiptGeneration(searchMonth, searchYear) : Observable<AdminOrder[]> {

    let byMonthAndYearUrlFinal = this.byMonthAndYearUrl + searchMonth + '&year=' + searchYear;

    return this.httpClient.get<AdminOrder[]>(byMonthAndYearUrlFinal);
  }

  onOrderItemsFromToday() : Observable<AdminOrder[]> {

    return this.httpClient.get<AdminOrder[]>(this.byTodayUrl);
  }

}

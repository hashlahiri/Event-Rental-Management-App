import {HttpBackend, HttpClient} from "@angular/common/http";
//import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ForgotPassword } from '../common/forgot-password';

@Injectable({
  providedIn: 'root'
})
export class ForgotPasswordService {

  private forgotPasswordUrl = environment.eventRentalManagementBaseUrl + '/user/forgotPassword/';

  public forgotPasswordObject = new ForgotPassword();

  constructor(/*private httpClient: HttpClient*/private http: HttpClient, handler: HttpBackend) { 

    this.http = new HttpClient(handler);
  }

  checkForPassword(data) : Observable<any> {

    //checking and resetting password
    this.forgotPasswordObject.userEmail = data.userEmail;
    this.forgotPasswordObject.userSecretPin = data.userSecretPin;

    return this.http.patch(this.forgotPasswordUrl, this.forgotPasswordObject);
  }

}

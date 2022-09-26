//import { HttpClient } from '@angular/common/http';
import {HttpBackend, HttpClient} from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User} from '../common/user';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  private registrationUrl = environment.eventRentalManagementBaseUrl + '/user/insertNewUser/';

  public newUser = new User(); 

  constructor(/*private httpClient: HttpClient*/private http: HttpClient, handler: HttpBackend) { 

    this.http = new HttpClient(handler);
  }

  registerUser(data) : Observable<any> {

    //register a user service
    this.newUser.userName = data.userName;
    this.newUser.userFirstName = data.userFirstName;
    this.newUser.userLastName = data.userLastName;
    this.newUser.userPassword = data.userPassword;
    this.newUser.userEmail = data.userEmail;
    this.newUser.userPhoneNumber = data.userPhoneNumber;
    this.newUser.userAddress = data.userAddress;
    this.newUser.userDob = data.userDob;
    this.newUser.userSecretPin = data.userSecretPin;

    return this.http.post(this.registrationUrl, this.newUser);
  }
}

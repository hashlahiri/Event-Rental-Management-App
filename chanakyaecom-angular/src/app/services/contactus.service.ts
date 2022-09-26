import {HttpBackend, HttpClient} from "@angular/common/http";
//import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ContactUsComponent } from '../components/contact-us/contact-us.component';
import { ContactUs } from '../common/contact-us';

@Injectable({
  providedIn: 'root'
})
export class ContactusService {

  private contactUsUrl = environment.eventRentalManagementBaseUrl + '/contactUs/insertIntoContactUs/';

  public contactUs = new ContactUs();

  constructor(/*private httpClient: HttpClient*/private http: HttpClient, handler: HttpBackend) { 

    this.http = new HttpClient(handler);
  }

  insertContactUsData(data): Observable<any> {
    //inserting the data via post api call
    this.contactUs.contactUsName = data.contactUsName;
    this.contactUs.contactUsEmail = data.contactUsEmail;
    this.contactUs.contactUsPurpose = data.contactUsPurpose;
    this.contactUs.contactUsMessage = data.contactUsMessage;

    return this.http.post(this.contactUsUrl, this.contactUs);

  }
}
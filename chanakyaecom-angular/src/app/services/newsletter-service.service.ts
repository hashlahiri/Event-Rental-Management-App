import {HttpBackend, HttpClient} from "@angular/common/http";
//import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class NewsletterServiceService {

  private newsletterUrl = environment.eventRentalManagementBaseUrl+'/newsletter/insertNewsletter/?newsletterEmail=';

  constructor(/*private httpClient: HttpClient*/private http: HttpClient, handler: HttpBackend) { 

    this.http = new HttpClient(handler);
  }

  insertNewsletter(data): Observable<any> {

    //building final url
    let newsletterUrlFinal = this.newsletterUrl +data;
    //inserting the api
    return this.http.post(newsletterUrlFinal, data);  

  }
}

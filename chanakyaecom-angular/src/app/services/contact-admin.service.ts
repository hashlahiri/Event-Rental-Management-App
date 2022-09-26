import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ContactAdmin } from '../common/contact-admin';

@Injectable({
  providedIn: 'root'
})
export class ContactAdminService {

  private contactAdminUrl = environment.eventRentalManagementBaseUrl + '/contactAdmin/insertIntoContactAdmin/';

  public contactAdmin = new ContactAdmin();

  constructor(private httpClient: HttpClient) { }

  insertContactAdminData(data): Observable<any> {
    
    //inserting the data via post api call
    this.contactAdmin.contactAdminName = data.contactAdminName;
    this.contactAdmin.contactAdminEmail = data.contactAdminEmail;
    this.contactAdmin.contactAdminPurpose = data.contactAdminPurpose;
    this.contactAdmin.contactAdminMessage = data.contactAdminMessage;
    
    return this.httpClient.post(this.contactAdminUrl, this.contactAdmin);
  }
}

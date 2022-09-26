import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AdminNewsletter } from '../common/admin-newsletter';

@Injectable({
  providedIn: 'root'
})
export class AdminNewsletterService {

  private newsletterUrl = environment.eventRentalManagementBaseUrl + '/newsletter/getAllNewsletter/list/';

  private updateByNewsletterUrl = environment.eventRentalManagementBaseUrl + '/newsletter/updateNewsletterByEmail/?newsletterEmail=';

  constructor(private httpClient: HttpClient) { }

  getAllNewsletters() : Observable<AdminNewsletter[]> {

    return this.httpClient.get<AdminNewsletter[]>(this.newsletterUrl);
  }

  onUpdateStatus(newsletterEmail, newsletterRequestStatus) {
    
    let updateByNewsletterUrlFinal = this.updateByNewsletterUrl + newsletterEmail + '&requestStatus=' + newsletterRequestStatus;

    return this.httpClient.patch(updateByNewsletterUrlFinal, newsletterRequestStatus);
  }
}

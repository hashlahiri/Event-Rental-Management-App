import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AdminViewerContact } from '../common/admin-viewer-contact';

@Injectable({
  providedIn: 'root'
})
export class AdminViewerContactService {

  private viewerContactUrl = environment.eventRentalManagementBaseUrl + '/contactUs/getAllContactUs/list/';

  private viewerContactUpdateRequestStatusUrl = environment.eventRentalManagementBaseUrl + '/contactUs/updateContactUsRequestStatusById/?contactUsId=';

  constructor(private httpClient: HttpClient) { }

  getAllViewerContacts() : Observable<AdminViewerContact[]> {

    return this.httpClient.get<AdminViewerContact[]>(this.viewerContactUrl);
  }

  onUpdateStatus(contactUsId, contactUsRequestStatus) {

    let viewerContactUpdateRequestStatusUrlFinal = this.viewerContactUpdateRequestStatusUrl + contactUsId + '&contactUsRequestStatus=' + contactUsRequestStatus;

    return this.httpClient.patch(viewerContactUpdateRequestStatusUrlFinal, contactUsRequestStatus);
  }
}

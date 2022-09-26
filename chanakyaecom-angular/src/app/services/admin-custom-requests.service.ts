import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AdminCustomRequests } from '../common/admin-custom-requests';

@Injectable({
  providedIn: 'root'
})
export class AdminCustomRequestsService {

  private customRequestsUrl = environment.eventRentalManagementBaseUrl + '/contactAdmin/getAllContactAdmin/list/';

  private updateByContactAdminUrl = environment.eventRentalManagementBaseUrl + '/contactAdmin/updateContactAdminRequestStatusById/?contactAdminId=';

  constructor(private httpClient: HttpClient) { }

  getAllCustomRequests() : Observable<AdminCustomRequests[]> {

    return this.httpClient.get<AdminCustomRequests[]>(this.customRequestsUrl);
  }

  onUpdateStatus(contactAdminId, contactAdminRequestStatus) {

    let updateByContactAdminUrlFinal = this.updateByContactAdminUrl + contactAdminId + '&contactAdminRequestStatus=' + contactAdminRequestStatus;

    return this.httpClient.patch(updateByContactAdminUrlFinal, contactAdminRequestStatus);
  }
}

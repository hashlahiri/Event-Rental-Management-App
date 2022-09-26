import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AdminUser } from '../common/admin-user';

@Injectable({
  providedIn: 'root'
})
export class AdminUsersService {

  private usersInfoUrl = environment.eventRentalManagementBaseUrl + '/user/getAllUsers/list/';

  constructor(private httpClient: HttpClient) { }

  getAllUsersInfo() : Observable<AdminUser[]> {

    return this.httpClient.get<AdminUser[]>(this.usersInfoUrl);
  }
}

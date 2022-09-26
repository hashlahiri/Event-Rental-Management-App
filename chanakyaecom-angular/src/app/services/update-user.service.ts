import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../common/user';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class UpdateUserService {

  private updateUserUrl = environment.eventRentalManagementBaseUrl + '/user/updateProfile/';

  private deleteUserUrl = environment.eventRentalManagementBaseUrl + '/user/deleteProfile/?userEmail=';

  public userObject = new User();

  constructor(private httpClient: HttpClient) { }

  updateUserData(data): Observable<any> {
    
    //creating the user object and sending to API call
    this.userObject.userName = data.username;
    this.userObject.userFirstName = data.updateUserFirstname;
    this.userObject.userLastName = data.updateUserLastname;
    this.userObject.userPassword = data.userPassword;
    this.userObject.userEmail = data.updateUserEmail;
    this.userObject.userPhoneNumber = data.updateUserNumber;
    this.userObject.userAddress = data.updateUserAddress;
    this.userObject.userDob = data.updateUserDate;

    return this.httpClient.patch(this.updateUserUrl, this.userObject);
  }

  userDeletionRequest(data): Observable<any> {

    //deletion request
    let deleteUserUrlFinal = this.deleteUserUrl + data;

    return this.httpClient.patch(deleteUserUrlFinal, data);
  }

}

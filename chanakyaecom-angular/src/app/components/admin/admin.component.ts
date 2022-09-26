import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/common/user';
import { UpdateUserService } from 'src/app/services/update-user.service';
import { UserInfoService } from 'src/app/services/user-info.service';
import { UserService } from 'src/app/services/user.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { EventRentalManageValidators } from 'src/app/validators/event-rental-manage-validators';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  updateAdminFormGroup : FormGroup;  

  user: String = "";
  userInfo = new User();

  constructor(private userService: UserService,
              private userInfoService: UserInfoService,
              private updateUserService: UpdateUserService,
              private formBuilder : FormBuilder,
              private router: Router) { }

  ngOnInit(): void {

    this.user = this.userService.getUsername();

    //get user information part
    this.userInfoService.getUserInformation(this.user).subscribe(
      data => {
        this.userInfo = data;
      }
    );
    
    console.warn(this.userInfo);

    //UpdateAdminForm Validations
    this.updateAdminFormGroup = this.formBuilder.group({
      updateAdminEmail: null,
      updateAdminNumber: new FormControl('', [
        Validators.required,
        Validators.minLength(10),
        Validators.maxLength(10),
        Validators.pattern('[0-9]*'),
        EventRentalManageValidators.notOnlyWhitespace
      ]),
      updateAdminFirstname: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(25),
        Validators.pattern('[a-zA-Z]*'),
        EventRentalManageValidators.notOnlyWhitespace
      ]),
      updateAdminLastname: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(25),
        Validators.pattern('[a-zA-Z]*'),
        EventRentalManageValidators.notOnlyWhitespace
      ]),
      updateAdminAddress: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(255),
        EventRentalManageValidators.notOnlyWhitespace
      ]),
      updateAdminDate : new FormControl('', [
        Validators.required,
        EventRentalManageValidators.notOnlyWhitespace
      ])
    });
  }

  get updateAdminEmail() { return /*this.updateUserFormGroup.get('updateUserEmail');*/this.userInfo.userEmail; }
  get updateAdminNumber() { return this.updateAdminFormGroup.get('updateAdminNumber'); }
  get updateAdminFirstname() { return this.updateAdminFormGroup.get('updateAdminFirstname'); }
  get updateAdminLastname() { return this.updateAdminFormGroup.get('updateAdminLastname'); }
  get updateAdminAddress() { return this.updateAdminFormGroup.get('updateAdminAddress'); }
  get updateAdminDate() { return this.updateAdminFormGroup.get('updateAdminDate'); }

  onSubmit(data) {
    data.username = this.userService.getUsername();
    data.userPassword = this.userInfo.userPassword;
    data.updateAdminEmail = this.userInfo.userEmail;
    
    //replacing the real detail with user detail
    data.updateUserEmail = data.updateAdminEmail;
    data.updateUserFirstname = data.updateAdminFirstname;
    data.updateUserLastname = data.updateAdminLastname;
    data.updateUserNumber = data.updateAdminNumber;
    data.updateUserAddress = data.updateAdminAddress;
    data.updateUserDate = data.updateAdminDate;
    

    console.warn('This is what is being submitted');
    console.warn(data);
    console.warn('-----------');

    this.updateUserService.updateUserData(data).subscribe();

    this.onAdminUpdateSubmit();
  }

  onAdminUpdateSubmit() {

    Swal.fire(
      'Details Updated Successfully!', //title
      'Confidential information revised',  //text
      'success' //type
    );
  }

}

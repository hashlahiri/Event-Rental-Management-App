import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/common/user';
import { UserService } from 'src/app/services/user.service';
import { UserInfoService } from 'src/app/services/user-info.service';
import { UpdateUserService } from '../../services/update-user.service';
import { HeaderComponent } from '../../components/header/header.component';
import { Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { EventRentalManageValidators } from 'src/app/validators/event-rental-manage-validators';
import { UserAuthService } from 'src/app/services/user-auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  updateUserFormGroup : FormGroup;

  //user information for form fill
  user: String = "";
  userInfo = new User();

  constructor(private userService: UserService,
    private userInfoService: UserInfoService,
    private updateUserService: UpdateUserService,
    private userAuthService: UserAuthService,
    private formBuilder: FormBuilder,
    private router: Router) { }

  ngOnInit(): void {

    this.user = this.userService.getUsername();
    //console.warn(this.user);

    //get user information part
    this.userInfoService.getUserInformation(this.user).subscribe(
      data => {
        this.userInfo = data;
      }
    );
    console.warn(this.userInfo);

    //UpdateUserForm Validations
    this.updateUserFormGroup = this.formBuilder.group({
      updateUserEmail: null,
      /*updateUserEmail : new FormControl('', [
        Validators.required,
        Validators.minLength(5),
        Validators.maxLength(255),
        Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$'),
        EventRentalManageValidators.notOnlyWhitespace
      ]),*/
      updateUserNumber: new FormControl('', [
        Validators.required,
        Validators.minLength(10),
        Validators.maxLength(10),
        Validators.pattern('[0-9]*'),
        EventRentalManageValidators.notOnlyWhitespace
      ]),
      updateUserFirstname: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(25),
        Validators.pattern('[a-zA-Z]*'),
        EventRentalManageValidators.notOnlyWhitespace
      ]),
      updateUserLastname: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(25),
        Validators.pattern('[a-zA-Z]*'),
        EventRentalManageValidators.notOnlyWhitespace
      ]),
      updateUserAddress: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(255),
        EventRentalManageValidators.notOnlyWhitespace
      ]),
      updateUserDate : new FormControl('', [
        Validators.required,
        EventRentalManageValidators.notOnlyWhitespace
      ])
    });
  }

  get updateUserEmail() { return /*this.updateUserFormGroup.get('updateUserEmail');*/this.userInfo.userEmail; }
  get updateUserNumber() { return this.updateUserFormGroup.get('updateUserNumber'); }
  get updateUserFirstname() { return this.updateUserFormGroup.get('updateUserFirstname'); }
  get updateUserLastname() { return this.updateUserFormGroup.get('updateUserLastname'); }
  get updateUserAddress() { return this.updateUserFormGroup.get('updateUserAddress'); }
  get updateUserDate() { return this.updateUserFormGroup.get('updateUserDate'); }

  onSubmit(data) {
    data.username = this.userService.getUsername();
    data.userPassword = this.userInfo.userPassword;
    data.updateUserEmail = this.userInfo.userEmail;

    this.updateUserService.updateUserData(data).subscribe();

    this.onUpdateClickAlert();
  }

  onDeleteRequest() {

    let data = this.userInfo.userEmail;

    this.updateUserService.userDeletionRequest(data).subscribe();

    this.userAuthService.clear();
    this.router.navigate(['/home']);

  }

  onUpdateClickAlert() {

    Swal.fire(
      'Details Updated Successfully!', //title
      'YAY! New Information',  //text
      'success' //type
    ).then(function() {
      location.reload();
    });
  }

}

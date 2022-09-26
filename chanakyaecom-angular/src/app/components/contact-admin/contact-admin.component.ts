import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { EventRentalManageValidators } from 'src/app/validators/event-rental-manage-validators';
import { ContactAdminService } from '../../services/contact-admin.service';
import Swal from 'sweetalert2';
import { User } from 'src/app/common/user';
import { UserService } from 'src/app/services/user.service';
import { UserInfoService } from 'src/app/services/user-info.service';

@Component({
  selector: 'app-contact-admin',
  templateUrl: './contact-admin.component.html',
  styleUrls: ['./contact-admin.component.css']
})
export class ContactAdminComponent implements OnInit {

  contactAdminFormGroup: FormGroup;

  //user information for form fill
  user: String = "";
  userInfo = new User();

  constructor(private contactAdminService: ContactAdminService, 
    private userService: UserService,
    private userInfoService: UserInfoService,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    this.user = this.userService.getUsername();

    //get user information part
    this.userInfoService.getUserInformation(this.user).subscribe(
      data => {
        this.userInfo = data;
      }
    );

    //contactAdmin validations
    this.contactAdminFormGroup = this.formBuilder.group({
      contactAdminName: new FormControl('', 
      [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(25),
        Validators.pattern('[a-zA-Z ]*'),
        EventRentalManageValidators.notOnlyWhitespace]),

      contactAdminEmail: null,/* new FormControl('', 
      [
        Validators.required,
        Validators.minLength(5),
        Validators.maxLength(255),
        Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]),*/

      contactAdminPurpose: new FormControl('', 
      [
        Validators.required,
        Validators.minLength(10),
        Validators.maxLength(100),
        Validators.pattern('[a-zA-Z ]*'),
        EventRentalManageValidators.notOnlyWhitespace]),

      contactAdminPhone: new FormControl('', 
      [
        Validators.required,
        Validators.minLength(10),
        Validators.maxLength(10),
        Validators.pattern('^[0-9]*'),
        EventRentalManageValidators.notOnlyWhitespace]),

      contactAdminMessage: new FormControl('', 
      [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(255),
        Validators.pattern('[a-zA-Z0-9-/,/. ]*'),
        EventRentalManageValidators.notOnlyWhitespace])
    });
  }

  get contactAdminName() { return this.contactAdminFormGroup.get('contactAdminName'); }
  get contactAdminEmail() { return /*this.contactAdminFormGroup.get('contactAdminEmail');*/this.userInfo.userEmail; }
  get contactAdminPurpose() { return this.contactAdminFormGroup.get('contactAdminPurpose'); }
  get contactAdminPhone() { return this.contactAdminFormGroup.get('contactAdminPhone'); }
  get contactAdminMessage() { return this.contactAdminFormGroup.get('contactAdminMessage'); }

  onSubmit(data) {
    data.contactAdminEmail = this.userInfo.userEmail;
    console.log(data);
    this.contactAdminService.insertContactAdminData(data).subscribe();
    //console.log('Thank you for your request, we would get back to you with a response');
    this.contactAdminSubmissionAlert();
  }

  contactAdminSubmissionAlert() {
    Swal.fire(
      'Aye Aye Captain!', //title
      'Our powerful ADMINs are on it!. Expect a prompt reply!',  //text
      'success' //type
    ).then(function() {
      location.reload();
    });
  }

}

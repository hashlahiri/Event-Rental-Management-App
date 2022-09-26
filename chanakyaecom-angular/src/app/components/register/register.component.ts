import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { EventRentalManageValidators } from 'src/app/validators/event-rental-manage-validators';
import { RegistrationService } from '../../services/registration.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registrationFormGroup: FormGroup;

  constructor(private registrationService: RegistrationService,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    //registration form validations
    this.registrationFormGroup = this.formBuilder.group({
      userName: new FormControl('', [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(255),
        EventRentalManageValidators.notOnlyWhitespace
      ]),

      userFirstName: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(25),
        Validators.pattern('[a-zA-Z]*'),
        EventRentalManageValidators.notOnlyWhitespace
      ]),

      userLastName: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(25),
        Validators.pattern('[a-zA-Z]*'),
        EventRentalManageValidators.notOnlyWhitespace
      ]),

      userPassword: new FormControl('', [
        Validators.required,
        Validators.minLength(8),
        Validators.maxLength(255),
        EventRentalManageValidators.notOnlyWhitespace
      ]),

      userEmail: new FormControl('', [
        Validators.required,
        Validators.minLength(5),
        Validators.maxLength(255),
        Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$'),
        EventRentalManageValidators.notOnlyWhitespace
      ]),

      userPhoneNumber: new FormControl('', [
        Validators.required,
        Validators.minLength(10),
        Validators.maxLength(10),
        Validators.pattern('[0-9]*'),
        EventRentalManageValidators.notOnlyWhitespace
      ]),

      userAddress: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(255),
        EventRentalManageValidators.notOnlyWhitespace
      ]),

      userDob: new FormControl('', [
        Validators.required,
        EventRentalManageValidators.notOnlyWhitespace
      ]),

      userSecretPin: new FormControl('', [
        Validators.required,
        Validators.minLength(1),
        Validators.maxLength(10),
        Validators.pattern('[0-9]*'),
        EventRentalManageValidators.notOnlyWhitespace
      ])
    });
  }

  get userName() { return this.registrationFormGroup.get('userName'); }
  get userFirstName() { return this.registrationFormGroup.get('userFirstName'); }
  get userLastName() { return this.registrationFormGroup.get('userLastName'); }
  get userPassword() { return this.registrationFormGroup.get('userPassword'); }
  get userEmail() { return this.registrationFormGroup.get('userEmail'); }
  get userPhoneNumber() { return this.registrationFormGroup.get('userPhoneNumber'); }
  get userAddress() { return this.registrationFormGroup.get('userAddress'); }
  get userDob() { return this.registrationFormGroup.get('userDob'); }
  get userSecretPin() { return this.registrationFormGroup.get('userSecretPin'); }

  onSubmit(data) {
    this.registrationService.registerUser(data).subscribe();

    this.onUserDataSubmissionAlert();
  }

  onUserDataSubmissionAlert() {
    Swal.fire(
      'Registration Successful!', //title
      'Welcome to the TEAM.! You can login now',  //text
      'success' //type
    ).then(function() {
      location.replace("/login");
    });
  }
}

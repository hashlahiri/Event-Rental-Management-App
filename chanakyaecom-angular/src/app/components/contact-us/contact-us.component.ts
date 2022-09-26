import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { ContactusService } from '../../services/contactus.service';
import { EventRentalManageValidators } from '../../validators/event-rental-manage-validators';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {

  contactUsFormGroup: FormGroup;

  constructor(private contactUsService: ContactusService,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    //contactUs validations
    this.contactUsFormGroup = this.formBuilder.group({
      contactUsName: new FormControl('',
        [Validators.required,
        Validators.minLength(2),
        Validators.maxLength(25),
        Validators.pattern('[a-zA-Z ]*'),
        EventRentalManageValidators.notOnlyWhitespace]),

      contactUsEmail: new FormControl('',
        [Validators.required,
        Validators.minLength(5),
        Validators.maxLength(255),
        Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]),

      contactUsPurpose: new FormControl('',
        [Validators.required,
        Validators.minLength(10),
        Validators.maxLength(100),
        Validators.pattern('[a-zA-Z/,/. ]*'),
        EventRentalManageValidators.notOnlyWhitespace]),

      contactUsPhoneNumber: new FormControl('',
        [Validators.required,
        Validators.minLength(10),
        Validators.maxLength(10),
        Validators.pattern('^[0-9]*'),
        EventRentalManageValidators.notOnlyWhitespace]),

      contactUsMessage: new FormControl('',
        [Validators.required,
        Validators.minLength(2),
        Validators.maxLength(255),
        Validators.pattern('[a-zA-Z/,/. ]*'),
        EventRentalManageValidators.notOnlyWhitespace])
    });
  }

  get contactUsName() { return this.contactUsFormGroup.get('contactUsName'); }
  get contactUsEmail() { return this.contactUsFormGroup.get('contactUsEmail'); }
  get contactUsPurpose() { return this.contactUsFormGroup.get('contactUsPurpose'); }
  get contactUsPhoneNumber() { return this.contactUsFormGroup.get('contactUsPhoneNumber'); }
  get contactUsMessage() { return this.contactUsFormGroup.get('contactUsMessage'); }
  

  onSubmit(data) {

    this.contactUsService.insertContactUsData(data).subscribe();

    this.contactUsSubmissionAlert();
  }

  contactUsSubmissionAlert() {
    Swal.fire(
      'Yay! You messaged us!', //title
      'Our representatives would be prompt with a reply!',  //text
      'success' //type
    ).then(function() {
      location.reload();
    });
  }
}

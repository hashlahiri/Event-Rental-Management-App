import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { ForgotPasswordService } from '../../services/forgot-password.service';
import { EventRentalManageValidators } from '../../validators/event-rental-manage-validators';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  forgotPasswordFormGroup: FormGroup;

  constructor(private forgotPasswordService: ForgotPasswordService,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    //forgotPassword Form validations
    this.forgotPasswordFormGroup = this.formBuilder.group({
      userEmail: new FormControl('',[
        Validators.required,
        Validators.minLength(5),
        Validators.maxLength(255),
        Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]),

      userSecretPin: new FormControl('',[
        Validators.required,
        Validators.minLength(1),
        Validators.maxLength(10),
        Validators.pattern('[0-9]*'),
        EventRentalManageValidators.notOnlyWhitespace])
    });
  }

  get userEmail() { return this.forgotPasswordFormGroup.get('userEmail'); }
  get userSecretPin() { return this.forgotPasswordFormGroup.get('userSecretPin'); }

  onSubmit(data){
    this.forgotPasswordService.checkForPassword(data).subscribe();

    this.onResetPasswordSubmissionAlert();
  }

  onResetPasswordSubmissionAlert() {

    const forgotPasswordSwal = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })
    
    forgotPasswordSwal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, reset it!',
      cancelButtonText: 'No, cancel!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        forgotPasswordSwal.fire(
          'Password Successfully Reset!',
          'Your password has been reset, contact administrator',
          'success'
        ).then(function() {
          location.replace("/contactUs");
        });
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        forgotPasswordSwal.fire(
          'Cancelled',
          'Your imaginary password is safe :)',
          'error'
        )
      }
    })
  }
}
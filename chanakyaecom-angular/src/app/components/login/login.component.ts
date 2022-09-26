import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EventRentalManageValidators } from 'src/app/validators/event-rental-manage-validators';
import { UserAuthService } from '../../services/user-auth.service';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {

  loginFormGroup: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private userAuthService: UserAuthService,
    private router: Router
  ) { }

  ngOnInit(): void {

    //login form validations
    this.loginFormGroup = this.formBuilder.group({
      userName: new FormControl('',
        [Validators.required,
        Validators.minLength(4),
        Validators.maxLength(255),
        Validators.pattern('[a-zA-Z0-9 ]*'),
        EventRentalManageValidators.notOnlyWhitespace]),

        userPassword: new FormControl('',
        [Validators.required,
        Validators.minLength(8),
        Validators.maxLength(255),
        EventRentalManageValidators.notOnlyWhitespace]),
    });
  }

  get userName() { return this.loginFormGroup.get('userName'); }
  get userPassword() { return this.loginFormGroup.get('userPassword'); }

  login(loginForm: NgForm) {

    this.userService.login(loginForm).subscribe(
      (response: any) => {
        this.userAuthService.setRoles(response.user.role);
        this.userAuthService.setToken(response.jwtToken);

        const role = response.user.role[0].roleName;
        if (role === 'Admin') {
          this.router.navigate(['/admin']);
        } else {
          this.router.navigate(['/products']);
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }
}

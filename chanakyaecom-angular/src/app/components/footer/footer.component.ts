import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { NewsletterServiceService } from '../../services/newsletter-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  newsletterFormGroup: FormGroup;

  newsletterEmail: String = "";

  constructor(private newsletterService: NewsletterServiceService,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    //newsletter validations
    this.newsletterFormGroup = this.formBuilder.group({
      newsletter: this.formBuilder.group({
        newsletterEmailContent: new FormControl('', 
        [Validators.required, 
        Validators.minLength(5),
        Validators.maxLength(255),
        Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')])
      })
    });
  }

  get newsletterEmailContent() { return this.newsletterFormGroup.get('newsletter.newsletterEmailContent'); }

  onSubmit(data) {

    this.newsletterEmail = data.newsletter.newsletterEmailContent;
    
    this.newsletterService.insertNewsletter(this.newsletterEmail).subscribe();

    this.newsletterEmail = null;

    this.newsletterAdditionAlert();
  }

  newsletterAdditionAlert(){
    Swal.fire(
      'Newsletter Added Successfully!', //title
      'We would get in touch with you ASAP!',  //text
      'success' //type
    ).then(function() {
      location.reload();
    });
  }

}

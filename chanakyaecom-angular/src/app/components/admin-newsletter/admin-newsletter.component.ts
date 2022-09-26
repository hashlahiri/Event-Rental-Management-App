import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { AdminNewsletterService } from '../../services/admin-newsletter.service';
import { AdminNewsletter } from '../../common/admin-newsletter';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-newsletter',
  templateUrl: './admin-newsletter.component.html',
  styleUrls: ['./admin-newsletter.component.css']
})
export class AdminNewsletterComponent implements OnInit {

  constructor(private userService: UserService,
    private adminNewsletterService: AdminNewsletterService) { }

  user: String = "";

  newsletterList: AdminNewsletter[] = [];

  async ngOnInit(): Promise<void> {

    this.user = this.userService.getUsername();

    await this.adminNewsletterService.getAllNewsletters().subscribe(
      data => {
        this.newsletterList = data;
      }
    );
  }

  onAccept(data): void {
    console.log('Inside the onAccept');
    console.warn(data);

    data["newsletterRequestStatus"]="ACCEPTED";

    this.adminNewsletterService.onUpdateStatus(data.newsletterEmail, data.newsletterRequestStatus).subscribe();

    this.onUpdateStatusAlert();
  }

  onHold(data){
    console.log('Inside the onHold');
    console.warn(data);

    data["newsletterRequestStatus"]="HOLD";

    this.adminNewsletterService.onUpdateStatus(data.newsletterEmail, data.newsletterRequestStatus).subscribe();

    this.onUpdateStatusAlert();
  }

  onRejected(data){
    console.log('Inside the onRejected');
    console.warn(data);

    data["newsletterRequestStatus"]="REJECTED";

    this.adminNewsletterService.onUpdateStatus(data.newsletterEmail, data.newsletterRequestStatus).subscribe();

    this.onUpdateStatusAlert();
  }

  onNewsletterReportGenerate() {
    console.log('Inside the onNewsletterReportGenerate');

    //sending data to storage and redirecting to desired page
    window.sessionStorage.setItem("allNewsletterDataList", JSON.stringify(this.newsletterList));
    location.replace('adminAllNewsletterReport');
  }

  onUpdateStatusAlert() {
    const Toast = Swal.mixin({
      toast: true,
      position: 'top-end',
      showConfirmButton: false,
      timer: 1000,
      timerProgressBar: true,
      didOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer)
        toast.addEventListener('mouseleave', Swal.resumeTimer)
      }
    })
    
    Toast.fire({
      icon: 'success',
      title: 'Request Status Modified'
    }).then(function() {
      location.reload();
    });
  }
}

import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { AdminViewerContactService } from "../../services/admin-viewer-contact.service";
import { AdminViewerContact } from "../../common/admin-viewer-contact";
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-viewer-contact',
  templateUrl: './admin-viewer-contact.component.html',
  styleUrls: ['./admin-viewer-contact.component.css']
})
export class AdminViewerContactComponent implements OnInit {

  constructor(private userService: UserService,
    private adminViewerContactService: AdminViewerContactService) { }

    user: String = "";

    viewerRequestList: AdminViewerContact[] =[];

  async ngOnInit(): Promise<void> {

    this.user = this.userService.getUsername();

    await this.adminViewerContactService.getAllViewerContacts().subscribe(
      data => {
        this.viewerRequestList = data;
      }
    );
  }

  onAccept(data): void {
    console.log('Inside the onAccept');
    console.warn(data);

    data["contactUsRequestStatus"]="ACCEPTED";

    this.adminViewerContactService.onUpdateStatus(data.contactUsId, data.contactUsRequestStatus).subscribe();

    this.onUpdateStatusAlert();
  }

  onHold(data): void {
    console.log('Inside the onHold');
    console.warn(data);

    data["contactUsRequestStatus"]="HOLD";

    this.adminViewerContactService.onUpdateStatus(data.contactUsId, data.contactUsRequestStatus).subscribe();

    this.onUpdateStatusAlert();
  }

  onRejected(data): void {
    console.log('Inside the onRejected');
    console.warn(data);

    data["contactUsRequestStatus"]="REJECTED";

    this.adminViewerContactService.onUpdateStatus(data.contactUsId, data.contactUsRequestStatus).subscribe();

    this.onUpdateStatusAlert();
  }

  onViewerContactReportGenerate() {
    console.log('Inside the onViewerContactReportGenerate');

    //sending data to storage and redirecting to desired page
    window.sessionStorage.setItem("allViewerContactRequestDataList", JSON.stringify(this.viewerRequestList));
    location.replace('adminAllViewerContactReport');
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

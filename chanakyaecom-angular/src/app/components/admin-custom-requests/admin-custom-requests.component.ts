import { Component, ComponentFactoryResolver, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { AdminCustomRequestsService } from "../../services/admin-custom-requests.service";
import { AdminCustomRequests } from "../../common/admin-custom-requests";
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-custom-requests',
  templateUrl: './admin-custom-requests.component.html',
  styleUrls: ['./admin-custom-requests.component.css']
})
export class AdminCustomRequestsComponent implements OnInit {

  constructor(private userService: UserService,
    private adminCustomRequestsService: AdminCustomRequestsService) { }

    user: String = "";

    customRequestsList: AdminCustomRequests[] =[];

  async ngOnInit(): Promise<void> {

    this.user = this.userService.getUsername();

    await this.adminCustomRequestsService.getAllCustomRequests().subscribe(
      data => {
        this.customRequestsList = data;
      }
    );
  }

  onAccept(data): void {
    console.log('Inside the onAccept');
    console.warn(data);

    data["contactAdminRequestStatus"]="ACCEPTED";

    this.adminCustomRequestsService.onUpdateStatus(data.contactAdminId, data.contactAdminRequestStatus).subscribe();

    this.onUpdateStatusAlert();
  }

  onHold(data): void {
    console.log('Inside the onHold');
    console.warn(data);

    data["contactAdminRequestStatus"]="HOLD";

    this.adminCustomRequestsService.onUpdateStatus(data.contactAdminId, data.contactAdminRequestStatus).subscribe();

    this.onUpdateStatusAlert();
  }

  onRejected(data): void {
    console.log('Inside the onRejected');
    console.warn(data);

    data["contactAdminRequestStatus"]="REJECTED";

    this.adminCustomRequestsService.onUpdateStatus(data.contactAdminId, data.contactAdminRequestStatus).subscribe();

    this.onUpdateStatusAlert();
  }

  onAllCustomRequestReportGenerate() {

    console.log('Inside the onAllCustomRequestReportGenerate');

    window.sessionStorage.setItem("allCustomRequestsList", JSON.stringify(this.customRequestsList));
    location.replace('adminAllCustomRequestReport');
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

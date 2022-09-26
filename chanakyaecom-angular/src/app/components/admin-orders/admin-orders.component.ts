import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { AdminOrdersService } from '../../services/admin-orders.service';
import { AdminOrder } from '../../common/admin-order';
import { saveAs } from 'file-saver';
import Swal  from 'sweetalert2';

@Component({
  selector: 'app-admin-orders',
  templateUrl: './admin-orders.component.html',
  styleUrls: ['./admin-orders.component.css']
})
export class AdminOrdersComponent implements OnInit {

  constructor(private userService: UserService,
    private adminOrdersService: AdminOrdersService) { }

  user: String = "";

  //incoming order informations
  orderInfoList: AdminOrder[] = [];

  async ngOnInit(): Promise<void> {
    this.user = this.userService.getUsername();

    //get all orders information
    await this.adminOrdersService.getAllOrderInformation().subscribe(
      data => {
        this.orderInfoList = data;
      }
    )
  }

  downloadAllOrders(): void {
    this.adminOrdersService.downloadAllOrders()
    .subscribe(blob => saveAs(blob, 'orders_' + new Date().toLocaleDateString() + new Date().toLocaleTimeString() + '.csv'));
  }

  onAccept(data): void {
    console.log('Inside the onAccept');
    console.warn(data);

    data["status"]="ACCEPTED";

    this.adminOrdersService.onUpdateStatus(data.orderTrackingNumber, data.status).subscribe();

    this.onUpdateStatusAlert();
  }

  onHold(data){
    console.log('Inside the onHold');
    console.warn(data);

    data["status"]="HOLD";

    this.adminOrdersService.onUpdateStatus(data.orderTrackingNumber, data.status).subscribe();

    this.onUpdateStatusAlert();
  }

  onRejected(data){
    console.log('Inside the onRejected');
    console.warn(data);

    data["status"]="REJECTED";

    this.adminOrdersService.onUpdateStatus(data.orderTrackingNumber, data.status).subscribe();

    this.onUpdateStatusAlert();
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

  onAllOrdersReportGenerate() {

    console.log('onAllOrdersReportGenerate');

    window.sessionStorage.setItem("allOrdersList", JSON.stringify(this.orderInfoList));
    location.replace('allOrdersReport');
  }
}

import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AdminOrder } from 'src/app/common/admin-order';
import { EventRentalManageValidators } from 'src/app/validators/event-rental-manage-validators';
import { AdminReportsService } from '../../services/admin-reports.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-reports',
  templateUrl: './admin-reports.component.html',
  styleUrls: ['./admin-reports.component.css']
})
export class AdminReportsComponent implements OnInit {

  orderTrackingNumberFormGroup: FormGroup;
  ordersByEmailFormGroup: FormGroup;
  ordersByEmailAndDateRangeFormGroup: FormGroup;
  ordersByMonthAndYearFormGroup: FormGroup;

  public userOrderInformationData: AdminOrder;
  public userOrderInformationListData: AdminOrder[];

  constructor(private adminReportsService: AdminReportsService,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    //orderTrackingNumberFormGroup Validations
    this.orderTrackingNumberFormGroup = this.formBuilder.group({
      orderTrackingNumberFormContent: new FormControl('',
        [Validators.required,
        Validators.minLength(36),
        Validators.maxLength(36),
        EventRentalManageValidators.notOnlyWhitespace])
    });

    //ordersByEmailFormGroup validations
    this.ordersByEmailFormGroup = this.formBuilder.group({
      ordersByEmailFormContent: new FormControl('',
        [Validators.required,
        Validators.minLength(5),
        Validators.maxLength(255),
        Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')])
    });

    //ordersByEmailAndDateRange validations
    this.ordersByEmailAndDateRangeFormGroup = this.formBuilder.group({
      ordersByEmailAndDateRangeFormEmailContent: new FormControl('', [
        Validators.required,
        Validators.minLength(5),
        Validators.maxLength(255),
        Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]),

      ordersByEmailAndDateRangeFormStartContent: new FormControl('', Validators.required),
      ordersByEmailAndDateRangeFormEndContent: new FormControl('', Validators.required)
    });


    //ordersByMonthAndYearForm validations
    this.ordersByMonthAndYearFormGroup = this.formBuilder.group({
      ordersByMonthAndYearFormMonthContent: new FormControl('', [
        Validators.required,
        Validators.min(1),
        Validators.max(12)
      ]),
      ordersByMonthAndYearFormYearContent: new FormControl('', [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(4)
      ])
    });
  }

  get orderTrackingNumberFormContent() { return this.orderTrackingNumberFormGroup.get('orderTrackingNumberFormContent'); }
  get ordersByEmailFormContent() { return this.ordersByEmailFormGroup.get('ordersByEmailFormContent'); }
  get ordersByEmailAndDateRangeFormEmailContent() { return this.ordersByEmailAndDateRangeFormGroup.get('ordersByEmailAndDateRangeFormEmailContent'); }
  get ordersByEmailAndDateRangeFormStartContent() { return this.ordersByEmailAndDateRangeFormGroup.get('ordersByEmailAndDateRangeFormStartContent'); }
  get ordersByEmailAndDateRangeFormEndContent() { return this.ordersByEmailAndDateRangeFormGroup.get('ordersByEmailAndDateRangeFormEndContent'); }
  get ordersByMonthAndYearFormMonthContent() { return this.ordersByMonthAndYearFormGroup.get('ordersByMonthAndYearFormMonthContent'); }
  get ordersByMonthAndYearFormYearContent() { return this.ordersByMonthAndYearFormGroup.get('ordersByMonthAndYearFormYearContent'); }

  onOrderTrackingNumberForm(data) {

    this.adminReportsService.onOrderTrackingSubmissionReceiptGeneration(data.orderTrackingNumberFormContent).subscribe(
      orderInfo => {
        this.userOrderInformationData = orderInfo;

        //sending data to adminReportsService and then redirecting page there
        window.sessionStorage.setItem("orderTrackingReceiptInformation", JSON.stringify(this.userOrderInformationData));
        this.onorderTrackingAlert();
        location.replace('/adminOrderTrackingReceipt');
      }
    );
  }

  onOrdersByEmailForm(data) {

    this.adminReportsService.onOrdersByEmailSubmissionReceiptGeneration(data.ordersByEmailFormContent).subscribe(
      orderInfo => {
        this.userOrderInformationListData = orderInfo;

        //sending data to adminReportsService and then redirecting to desired page
        window.sessionStorage.setItem("customerOrderInfoDataList", JSON.stringify(this.userOrderInformationListData));
        this.onorderTrackingAlert();
        location.replace('/adminCustomerEmailReceipt');
      }
    );
  }

  onOrdersByEmailAndDateRange(data) {

    let customerEmail = data.ordersByEmailAndDateRangeFormEmailContent;
    let startingDate = data.ordersByEmailAndDateRangeFormStartContent;
    let endingDate = data.ordersByEmailAndDateRangeFormEndContent;

    this.adminReportsService.onOrdersByEmailAndDateRangeSubmissionReceiptGeneration(customerEmail, startingDate, endingDate).subscribe(
      orderInfo => {
        this.userOrderInformationListData = orderInfo;

        //sending data to adminReportsService and then redirecting to the desired page
        window.sessionStorage.setItem("customerOrderInfoDataList", JSON.stringify(this.userOrderInformationListData));
        this.onorderTrackingAlert();
        location.replace('/adminCustomerEmailAndDateRange');
      }
    );

  }

  onOrdersByMonthAndYear(data) {

    let searchMonth = data.ordersByMonthAndYearFormMonthContent;
    let searchYear = data.ordersByMonthAndYearFormYearContent;

    this.adminReportsService.onOrdersByMonthAndYearSubmissionReceiptGeneration(searchMonth, searchYear).subscribe(
      orderInfo => {
        this.userOrderInformationListData = orderInfo;

        //sending data to adminReportsService and then redirecting to the desired page
        window.sessionStorage.setItem("customerOrderInfoDataList", JSON.stringify(this.userOrderInformationListData));
        this.onorderTrackingAlert();
        location.replace('/adminOrdersByMonthAndYear');
      }
    );


  }

  onOrdersForToday() {

    this.adminReportsService.onOrderItemsFromToday().subscribe(
      orderInfo => {
        this.userOrderInformationListData = orderInfo;

        //sending data to adminReportsService and then redirecting to the desired page
        window.sessionStorage.setItem("customerOrderInfoDataList", JSON.stringify(this.userOrderInformationListData));
        this.onorderTrackingAlert();
        location.replace('adminOrdersForToday');
      }
    );
  }


  onorderTrackingAlert() {

    let timerInterval
    Swal.fire({
      title: 'Generating Report!',
      html: 'Only takes a few milliseconds!',
      timer: 2000,
      timerProgressBar: true,
      didOpen: () => {
        Swal.showLoading()
      },
      willClose: () => {
        clearInterval(timerInterval)
      }
    })
  }
}

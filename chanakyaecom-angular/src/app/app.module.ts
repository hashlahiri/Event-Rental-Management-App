import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppComponent } from "./app.component";
import { ProductListComponent } from "./components/product-list/product-list.component";
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { ProductService } from "./services/product.service";

import { Routes, RouterModule, Router } from "@angular/router";
import { ProductCategoryMenuComponent } from "./components/product-category-menu/product-category-menu.component";
import { SearchComponent } from "./components/search/search.component";
import { ProductDetailsComponent } from "./components/product-details/product-details.component";
//import { AppRoutingModule } from './app-routing.module';

import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { CartStatusComponent } from "./components/cart-status/cart-status.component";
import { CartDetailsComponent } from "./components/cart-details/cart-details.component";
import { CheckoutComponent } from "./components/checkout/checkout.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { AuthGuard } from './_auth/auth.guard';
import { AuthInterceptor } from "./_auth/auth.interceptor";

import { OrderHistoryComponent } from "./components/order-history/order-history.component";
import { LoginComponent } from './components/login/login.component';
import { AdminComponent } from './components/admin/admin.component';
import { ForbiddenComponent } from './components/forbidden/forbidden.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { UserComponent } from './components/user/user.component';
import { UserService } from "./services/user.service";
import { RegisterComponent } from './components/register/register.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import { OurPolicyComponent } from './components/our-policy/our-policy.component';
import { UserHeaderComponent } from './components/user-header/user-header.component';
import { FooterComponent } from './components/footer/footer.component';
import { ContactAdminComponent } from './components/contact-admin/contact-admin.component';
import { CareersComponent } from './components/careers/careers.component';
import { UpdateUserComponent } from './components/update-user/update-user.component';
import { AdminHeaderComponent } from './components/admin-header/admin-header.component';
import { AdminOrdersComponent } from './components/admin-orders/admin-orders.component';
import { AdminUsersComponent } from './components/admin-users/admin-users.component';
import { AdminCustomRequestsComponent } from './components/admin-custom-requests/admin-custom-requests.component';
import { AdminViewerContactComponent } from './components/admin-viewer-contact/admin-viewer-contact.component';
import { AdminNewsletterComponent } from './components/admin-newsletter/admin-newsletter.component';
import { UserReceiptComponent } from './components/user-receipt/user-receipt.component';
import { AdminReportsComponent } from './components/admin-reports/admin-reports.component';
import { AdminOrderTrackingReceiptComponent } from './components/admin-order-tracking-receipt/admin-order-tracking-receipt.component';
import { AdminCustomerEmailReceiptComponent } from './components/admin-customer-email-receipt/admin-customer-email-receipt.component';
import { AdminCustomerEmailAndDateRangeComponent } from './components/admin-customer-email-and-date-range/admin-customer-email-and-date-range.component';
import { AdminOrdersByMonthAndYearComponent } from './components/admin-orders-by-month-and-year/admin-orders-by-month-and-year.component';
import { AdminOrdersForTodayComponent } from './components/admin-orders-for-today/admin-orders-for-today.component';
import { UserInvoiceComponent } from './components/user-invoice/user-invoice.component';
import { AdminAllNewsletterReportComponent } from './components/admin-all-newsletter-report/admin-all-newsletter-report.component';
import { AdminAllViewerContactReportComponent } from './components/admin-all-viewer-contact-report/admin-all-viewer-contact-report.component';
import { AdminAllCustomRequestReportComponent } from './components/admin-all-custom-request-report/admin-all-custom-request-report.component';
import { AdminAllUsersReportComponent } from './components/admin-all-users-report/admin-all-users-report.component';
import { AllOrdersReportComponent } from './components/all-orders-report/all-orders-report.component';


const routes: Routes = [
  
  { path: "checkout", component: CheckoutComponent, canActivate: [AuthGuard], data: { roles: ['User'] } },
  { path: "cart-details", component: CartDetailsComponent, canActivate: [AuthGuard], data: { roles: ['User'] } },
  { path: "products/:id", component: ProductDetailsComponent },
  { path: "search/:keyword", component: ProductListComponent },
  { path: "category/:id", component: ProductListComponent },
  { path: "category", component: ProductListComponent },
  { path: "products", component: ProductListComponent, canActivate: [AuthGuard], data: { roles: ['User'] } },
  { path: "login", component: LoginComponent },
  { path: "forbidden", component: ForbiddenComponent },
  { path: "home", component: HomeComponent },
  { path: "user", component: UserComponent, canActivate: [AuthGuard], data: { roles: ['User'] } },
  { path: "userReceipt", component: UserReceiptComponent, canActivate: [AuthGuard], data: { roles: ['User'] } },
  { path: "userInvoice", component: UserInvoiceComponent, canActivate: [AuthGuard], data: { roles: ['User'] } },
  { path: "admin", component: AdminComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: "register", component: RegisterComponent},
  { path: "forgotPassword", component: ForgotPasswordComponent},
  { path: "careers", component: CareersComponent },
  { path: "contactUs", component: ContactUsComponent},
  { path: "ourPolicy", component: OurPolicyComponent},
  { path: "contactAdmin", component: ContactAdminComponent, canActivate: [AuthGuard], data: { roles: ['User'] }},
  { path: "updateUser", component: UpdateUserComponent, canActivate: [AuthGuard], data: { roles: ['User'] } },
  { path: "adminOrders", component: AdminOrdersComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: "adminUsers", component: AdminUsersComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: "adminCustomRequests", component: AdminCustomRequestsComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: "adminViewerContact", component: AdminViewerContactComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: "adminNewsletter", component: AdminNewsletterComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: "adminReports", component: AdminReportsComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: "adminOrderTrackingReceipt", component: AdminOrderTrackingReceiptComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: "adminCustomerEmailReceipt", component: AdminCustomerEmailReceiptComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: "adminCustomerEmailAndDateRange", component: AdminCustomerEmailAndDateRangeComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: "adminOrdersByMonthAndYear", component: AdminOrdersByMonthAndYearComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: "adminOrdersForToday", component: AdminOrdersForTodayComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: "adminAllNewsletterReport", component: AdminAllNewsletterReportComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: "adminAllViewerContactReport", component: AdminAllViewerContactReportComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: "adminAllCustomRequestReport", component: AdminAllCustomRequestReportComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: "adminAllUsersReport", component: AdminAllUsersReportComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: "allOrdersReport", component: AllOrdersReportComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } }, 
  { path: "", redirectTo: "/products", pathMatch: "full" },
  { path: "**", redirectTo: "/products", pathMatch: "full" },
];

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductCategoryMenuComponent,
    SearchComponent,
    ProductDetailsComponent,
    CartStatusComponent,
    CartDetailsComponent,
    CheckoutComponent,
    OrderHistoryComponent,
    LoginComponent,
    AdminComponent,
    ForbiddenComponent,
    HeaderComponent,
    HomeComponent,
    UserComponent,
    RegisterComponent,
    ForgotPasswordComponent,
    ContactUsComponent,
    OurPolicyComponent,
    UserHeaderComponent,
    FooterComponent,
    ContactAdminComponent,
    CareersComponent,
    UpdateUserComponent,
    AdminHeaderComponent,
    AdminOrdersComponent,
    AdminUsersComponent,
    AdminCustomRequestsComponent,
    AdminViewerContactComponent,
    AdminNewsletterComponent,
    UserReceiptComponent,
    AdminReportsComponent,
    AdminOrderTrackingReceiptComponent,
    AdminCustomerEmailReceiptComponent,
    AdminCustomerEmailAndDateRangeComponent,
    AdminOrdersByMonthAndYearComponent,
    AdminOrdersForTodayComponent,
    UserInvoiceComponent,
    AdminAllNewsletterReportComponent,
    AdminAllViewerContactReportComponent,
    AdminAllCustomRequestReportComponent,
    AdminAllUsersReportComponent,
    AllOrdersReportComponent,
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    NgbModule,
    ReactiveFormsModule,
    //AppRoutingModule,
    FormsModule,
    RouterModule
  ],
  providers: [
    ProductService,
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    },
    UserService
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}

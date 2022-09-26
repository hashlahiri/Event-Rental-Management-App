import { AdminAddress } from "./admin-address";
import { AdminCustomer } from "./admin-customer";

export class AdminOrder {

    id: number;
    orderTrackingNumber: string;
    totalQuantity: number;
    totalPrice: number;
    status: string;
    dateCreated: Date;
    lastUpdated: Date;
    shippingAddress: AdminAddress;
    billingAddress: AdminAddress;
    customer: AdminCustomer;
}

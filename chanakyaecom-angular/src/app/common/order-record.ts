import { BillingAddress } from "./billing-address";
import { OrderContent } from "./order-content";
import { ShippingAddress } from "./shipping-address";

export class OrderRecord {

    id: number;
    orderTrackingNumber: string;
    totalQuantity: number;
    totalPrice: number;
    status: string;
    dateCreated: Date;
    lastUpdated: Date;
    orderItems: OrderContent[];
    shippingAddress: ShippingAddress;
    billingAddress: BillingAddress;

}

import { AdminAddress } from "./admin-address";
import { OrderContent } from "./order-content";

export class AdminOrderContent {

    id: number;
    orderTrackingNumber: string;
    totalQuantity: number;
    totalPrice: number;
    status: string;
    dateCreated: Date;
    lastUpdated: Date;
    orderItems: OrderContent[];
    shippingAddress: AdminAddress;
    billingAddress: AdminAddress;
}

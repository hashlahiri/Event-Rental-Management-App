import { AdminOrderContent } from "./admin-order-content";
import { OrderContent } from "./order-content";

export class AdminCustomer {

    id: number;
    firstName: string;
    lastName: string;
    email: string;
    orders: AdminOrderContent[];
}

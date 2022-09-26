import { AdminUserRole } from "./admin-user-role";

export class AdminUser {

    userName: string;
    userFirstName: string;
    userLastName: string;
    userPassword: string;
    userEmail: string;
    userPhoneNumber: number;
    userAddress: string;
    userDob: Date;
    userSecretPin: number;
    userStatus: Boolean;
    userCreated: Date;
    userUpdated: Date;
    role: AdminUserRole[];
}

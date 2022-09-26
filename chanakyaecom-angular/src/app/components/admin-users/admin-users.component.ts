import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { AdminUsersService } from '../../services/admin-users.service';
import { AdminUser } from "../../common/admin-user";

@Component({
  selector: 'app-admin-users',
  templateUrl: './admin-users.component.html',
  styleUrls: ['./admin-users.component.css']
})
export class AdminUsersComponent implements OnInit {

  constructor(private userService: UserService,
    private adminUsersService: AdminUsersService) { }

  user: String = "";

  usersInfoList: AdminUser[] =[];

  async ngOnInit(): Promise<void> {

    this.user = this.userService.getUsername();

    await this.adminUsersService.getAllUsersInfo().subscribe(
      data => {
        this.usersInfoList = data;
      }
    );
  }

  onAllUsersReportGenerate() {

    console.log('On All Users Report Generate');

    window.sessionStorage.setItem("allUsersList", JSON.stringify(this.usersInfoList));
    location.replace('adminAllUsersReport');
  }

}

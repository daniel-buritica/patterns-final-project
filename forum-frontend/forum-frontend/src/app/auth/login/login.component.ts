import { Component, OnInit } from '@angular/core';
import { AuthService} from '../../shared/services/auth.service';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  userData: any;



  constructor(public authService: AuthService) {}

  login(): void {
    this.authService.GoogleAuth();
  }

  ngOnInit(): void {
    this.authService.isLoggedIn
      ? this.authService.router.navigate(['../shared/pages/home'])
      : '';
  }
}

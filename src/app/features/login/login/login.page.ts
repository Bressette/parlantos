import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {LoginService} from './login.service';
import {Router} from '@angular/router';
import {AuthService} from '../../../shared/auth/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: 'login.page.html',
  styleUrls: ['login.page.scss'],
})
export class LoginPage implements OnInit {

  constructor(private loginService: LoginService, private router: Router, private authService: AuthService) {}

  public loginGroup: FormGroup;

  public invalidPassword = false;

  async ngOnInit() {
    this.loginGroup = new FormGroup({
      username: new FormControl(null, [Validators.required]),
      password: new FormControl(null, [Validators.required])
    });
    if (await this.authService.checkAuthenticated()) {
      await this.router.navigateByUrl('navbar/chat');
    }
  }

  async submitLogin() {
    try {
      await this.authService.login(this.username.value, this.password.value);
    } catch (error) {
      this.invalidPassword = true;
    }
  }

  get username() {
    return this.loginGroup.get('username');
  }

  get password() {
    return this.loginGroup.get('password');
  }

}

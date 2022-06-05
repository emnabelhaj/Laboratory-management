import { Component, NgZone, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/Services/AuthService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService: AuthService,
    private router: Router,
    private ngZone: NgZone,) { }

  ngOnInit(): void {
  }
  tryGoogleLogin(): void {
    //wa9t temchi téxécuti la fonction doGoogleLogin donc rak
    // 5rajt min app mte3ik w mchit tahki ma3a il serveur d'auth mech i5arejlik les comptes authéntifiées 
    //donc mech narja3 lil mon app pour que je puisse éxécuter mes routes nesta3mlou   ngZone.run
    /* this.authService.doGoogleLogin()
       .then(() => this.successRedirect())
       .catch((error: any) => console.log(error))
       .finally(() => {
       });*/

  }
  successRedirect(): void {
    // noinspection JSIgnoredPromiseFromCall
    // this.ngZone.run(() => this.router.navigate(['/members']));

  }
}

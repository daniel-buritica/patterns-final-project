import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {CustomerService} from '../../services/customer.service';
import {UserI,PersonI} from '../../models/User.interface';
import { fromEvent, throttleTime, map, scan, filter, delay } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-complete-register',
  templateUrl: './complete-register.component.html',
  styleUrls: ['./complete-register.component.scss']
})
export class CompleteRegisterComponent implements OnInit {
  
  emailLocalStorage:string = JSON.parse(localStorage.getItem('user')!).email;
  
  User_register:FormGroup = new FormGroup({
    'personModel': new FormGroup({
      "name": new FormControl('', Validators.required),
      "lastname": new FormControl('', Validators.required),
      "cardId": new FormControl('', Validators.required),
      "dateBirth": new FormControl('', Validators.required),
      "email": new FormControl(this.emailLocalStorage, Validators.required),
      "profession": new FormControl('', Validators.required),
      "countries": new FormControl('', Validators.required),
      "city": new FormControl('', Validators.required)
    }),
    'userName': new FormControl(this.emailLocalStorage, Validators.required),
    'rolModel': new FormGroup({
      'rol': new FormControl('', Validators.required),
    }) 
  });

  

  constructor(
    private api:CustomerService,
    public router: Router,
  ) { }

  ngOnInit(): void {
  }

  postCompleteRegister(form:UserI){     
    // Crear usaurio Base de datos 
    this.api.createUser(form)
    .pipe(map((res) =>{
      this.User_register.reset();
      this.router.navigate(['home']);
      this.api.findByEmail(this.emailLocalStorage)
      .pipe(map((res: PersonI)=>{
        console.log(res);
        localStorage.setItem('userI', 'null');
        localStorage.setItem('userI', JSON.stringify(res));
        this.router.navigate(['home']);
      })).subscribe();
    })).subscribe();   
    this.router.navigate(['home']);
    
  }

  // Push al objeto user al local storage para ser 
  pushUserLocalStorage(boolean:Boolean){
    console.log("3");
    this.api.findByEmail(this.emailLocalStorage)
    .pipe(map((res: PersonI)=>{
      localStorage.setItem('userI', JSON.stringify(res));
    })).subscribe();
  }

}

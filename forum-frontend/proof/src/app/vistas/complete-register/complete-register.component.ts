import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ApiService} from '../../services/api/api.service';
import {CompleteRegisterI} from '../../modelos/complete-register.interface';



@Component({
  selector: 'app-complete-register',
  templateUrl: './complete-register.component.html',
  styleUrls: ['./complete-register.component.scss']
})
export class CompleteRegisterComponent implements OnInit {

  complete_register:FormGroup = new FormGroup({
    'name': new FormControl('', Validators.required),
    'lastname':new FormControl('', Validators.required),
    'cardId':new FormControl('', Validators.required),
    'dateBirth':new FormControl('', Validators.required),    
    'email':new FormControl('', Validators.required),    
    'profession':new FormControl('', Validators.required),    
    'countries':new FormControl('', Validators.required),    
    'city':new FormControl('', Validators.required),    
  })

  constructor(private api:ApiService) { }

  ngOnInit(): void {
  }

  postCompleteRegister(form:CompleteRegisterI){ 
    this.api.postPerson(form).subscribe(data => {
      console.log(data);
    })
  }
}

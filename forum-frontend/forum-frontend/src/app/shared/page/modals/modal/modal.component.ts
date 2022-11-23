import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { fromEvent, throttleTime, map, scan, filter, delay } from 'rxjs';
import { Router } from '@angular/router';
import {PostI, PostResponseI} from '../../../models/Post.interface';
import {CommentService} from '../../../services/post.service';
import { formatPercent } from '@angular/common';


@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.scss']
})
export class ModalComponent implements OnInit {

  idLocalStorage:string = JSON.parse(localStorage.getItem('userI')!).id;
  

  post_register:FormGroup = new FormGroup({    
    'idUser': new FormControl(this.idLocalStorage, Validators.required),
    'bodyPost': new FormControl(' ', Validators.required),
    'category': new FormControl('Pregunta', Validators.required),
  });
  constructor(
    private http:CommentService, 
    public router:Router
  ) { }

  ngOnInit(): void {
  }

  creatPost(form:PostI){
    this.http.createPost(form).subscribe(respose => {
      console.log(respose);
      this.post_register.reset('bodyPost');
      this.router.navigate(['home']);
    });    
    this.router.navigate(['home']);
  }

}

import { Injectable } from '@angular/core';
import {CompleteRegisterI} from '../../modelos/complete-register.interface';
import {ResponseCompleteRegisterI} from '../../modelos/response-complete-register.interface';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  basePath:string = 'http://localhost:8080/api/v1/person';
  constructor(private http:HttpClient) { }

  postPerson(form:CompleteRegisterI):Observable<ResponseCompleteRegisterI>{

    return this.http.post<ResponseCompleteRegisterI>(this.basePath, form);
  }
}

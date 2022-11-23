import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import {PersonResponseI} from '../../shared/models/person-Response.interface';
import {UserI} from '../../shared/models/User.interface';
import {UserResponseI} from '../../shared/models/UserResponse.interface';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private BASE_PATH_PERSON:string = 'http://localhost:8080/api/v1/person';
  private BASE_PATH_USER:string = 'http://localhost:8080/api/v1/user';
  

  constructor(private http:HttpClient) { }

  // Traer persona por el correo electronico 
  
  public findByEmail(email:string):Observable<PersonResponseI>{
    var path = this.BASE_PATH_PERSON +'/findByEmail/'+ email;
    return this.http.get<PersonResponseI>(path);
  }
  // Validar exitencia del email en base de datos response (true or false)
  public validateEmailDataBase(email:string):Observable<Boolean>{
    var path = this.BASE_PATH_PERSON +'/validate/'+ email;
    return this.http.get<Boolean>(path);
  }
  // Crear objeto user Base de datos
  public createUser(form:UserI):Observable<UserResponseI>{
    return this.http.post<UserResponseI>(this.BASE_PATH_USER,form);
  }

}

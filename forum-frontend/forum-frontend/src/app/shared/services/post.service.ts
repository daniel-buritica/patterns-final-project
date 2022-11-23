import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import {PostI, PostResponseI} from '../models/Post.interface';




@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private BASE_PATH_POST:string = 'http://localhost:8080/api/v1/post';  

  constructor(private http:HttpClient) { }


  // Crear post base de datos 
  public createPost(form:PostI):Observable<PostResponseI>{
    return this.http.post<PostResponseI>(this.BASE_PATH_POST,form);
  }

  // Get post por id 
  public findByIdPost(id:number):Observable<PostResponseI>{
    var path = this.BASE_PATH_POST +'/'+id;
    return this.http.get<PostResponseI>(path);
  }

  // Get post por id 
  public findByAll():Observable<PostResponseI[]>{
    var path = this.BASE_PATH_POST ;
    return this.http.get<PostResponseI[]>(path);
  }
}

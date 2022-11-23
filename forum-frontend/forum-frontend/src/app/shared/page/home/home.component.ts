import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service'
import {PostI, PostResponseI} from '../../models/Post.interface';
import {CommentService} from '../../services/post.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  listPost:PostResponseI[] | undefined;
  

  constructor(
    public authService:AuthService,
    private http:CommentService,
    public router: Router 
    ) { }

  ngOnInit(): void {
    //!this.authService.isLoggedIn? this.authService.router.navigate(['login']):"";

    this.http.findByAll().subscribe(response =>{
      this.listPost = response;
      console.log(this.listPost);
    })

  }

}

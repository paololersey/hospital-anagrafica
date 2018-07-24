import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  constructor(private router : Router) { }

  ngOnInit() {
    window.localStorage.setItem('key', 'value');
  }

  conferma(){
    this.router.navigate(['/compilaForm']);
  }

  ricerca(){
    this.router.navigate(['/search']);
  }
}

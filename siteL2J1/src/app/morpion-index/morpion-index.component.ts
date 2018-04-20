import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-morpion-index',
  templateUrl: './morpion-index.component.html',
  styleUrls: ['./morpion-index.component.css']
})
export class MorpionIndexComponent implements OnInit {

  constructor(private httpClient: HttpClient) { }

  reset(){
    this.httpClient
    .post("http://localhost:8080/morpion/reset", 1)
    .subscribe(
      (response) => {
        console.log("Reset envoyé !");
      },
      (error) => {
        console.log("Erreur: "+error);
      }
    )
  }

  ngOnInit() {
  }

}

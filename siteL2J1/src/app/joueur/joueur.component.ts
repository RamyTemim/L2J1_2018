import { Component, OnInit } from '@angular/core';
import { Joueur } from './joueur';

@Component({
  selector: 'app-joueur',
  templateUrl: './joueur.component.html',
  styleUrls: ['./joueur.component.css']
})
export class JoueurComponent implements OnInit {

  joueur: Joueur ={
    nom: ''
  }
  constructor() { }

  ngOnInit() {
  }

}

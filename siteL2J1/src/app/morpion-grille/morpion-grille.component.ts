import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-morpion-grille',
  templateUrl: './morpion-grille.component.html',
  styleUrls: ['./morpion-grille.component.css']
})
export class MorpionGrilleComponent implements OnInit {
  cases: number[] = [0,0,0];

  constructor() { }

  onClick(){
    console.log("test des conditions");
  }

  ngOnInit() {
  }

}

import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-joueur',
  templateUrl: './joueur.component.html',
  styleUrls: ['./joueur.component.css']
})
export class JoueurComponent{
  items = [];
  newItem = "";
  pushItem = function() {
    if(this.newItem != "" && this.items == "" ) {
      this.items.push(this.newItem);
      this.newItem = "";
    }
  }

  removeItems = function(index) {
    this.items.splice (index, 1);
  }

}

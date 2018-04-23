import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-pfc-index',
  templateUrl: './pfc-index.component.html',
  styleUrls: ['./pfc-index.component.css']
})
export class PfcIndexComponent implements OnInit {
case: string [] = ["Pierre","Feuille","Ciseau"];
win: number = 0;
lose: number = 0;
draw: number = 0;
bot: number;

  constructor(private httpClient: HttpClient) {
    this.reset()
  }

  onClick(i: number){
    console.log(i);

    this.httpClient
    .post("http://localhost:8080/pfc/mark", i)
    .subscribe(
      (response) => {
        console.log("C'est envoyé!");
      },
      (error) => {
        console.log("Erreur: "+error);
      }
    )
    this.getResultat();
  }

  getResultat(){
    this.httpClient
    .get("http://localhost:8080/pfc/resultat")
    .subscribe(resultat => {
        if (resultat==0){
            console.log("Nouvelle partie en cours");
        }
        if (resultat==1){
            alert("Vous avez gagné !");
            this.reset();
            this.win++;
        }
        if (resultat==2){
            alert("Vous avez perdu...");
            this.reset();
            this.lose++;
        }
        if (resultat==3){
            alert("Match nul");
            this.reset();
            this.draw++;
        }
    });
  }

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

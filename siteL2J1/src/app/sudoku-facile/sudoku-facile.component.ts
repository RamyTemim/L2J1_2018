import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/map';


@Component({
    selector: 'app-sudoku-facile',
    templateUrl: './sudoku-facile.component.html',
    styleUrls: ['./sudoku-facile.component.css']
})
    
export class SudokuFacileComponent {
    private sudokuFacileUrl = 'http://localhost:8080/sudoku/sudokuFacile';
    data1: number[][];
    data2: number[][];

    constructor(private http: Http) {
        this.getGrilleFacile();
	}
    


    getDataFacile() {
        return this.http.get(this.sudokuFacileUrl).map((res: Response) => res.json())
    }

    getGrilleFacile() {
        this.getDataFacile().subscribe(dataTmp => {
            this.data1 = dataTmp;	
		this.data2 = this.data1.map(function(arr) {
    return arr.slice();
});
        });
		
	
}

    saveNumber(x, i, j) {
        var y = +x;
        this.data2[i][j] = y;
    }


    validate() {

        var myJsonString = JSON.stringify(this.data2);

        this.http.post("http://localhost:8080/sudoku/result", { myJsonString }).subscribe(resultat => {
            if (resultat.json()){ 
                alert("you win !"); 
            }else{ 
                alert("you lose"); 
            }

        });
    }
}

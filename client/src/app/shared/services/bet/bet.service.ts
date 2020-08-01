import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Bet,BetQuery} from '../../../model'
import { AngularFireAuth } from '@angular/fire/auth';

@Injectable({
  providedIn: 'root'
})
export class BetService {

  constructor(private http: HttpClient,private afAuth:AngularFireAuth) { }


  placeBet(bet: Bet): Observable<any> {
    console.log('tried hard to place bet');
    console.log(bet);
    return this.http.post('http://localhost:8080/bets/place',bet);
  }

  // returns list of verboseBets
  queryBets(betQuery:BetQuery): Observable<any> {
    console.log('tried hard to queryBets');
    return this.http.post('http://localhost:8080/bets/query',betQuery);
  }
}

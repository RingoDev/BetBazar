import { Component, OnInit } from '@angular/core';
import { TournamentService } from '../shared';
import { BetService } from '../shared/services/bet/bet.service'
import { Bet } from '../model/bet'
import { AngularFireAuth } from '@angular/fire/auth';
import { ignoreElements } from 'rxjs/operators';

@Component({
  selector: 'app-tournament',
  templateUrl: './tournament.component.html',
  styleUrls: ['./tournament.component.css']
})
export class TournamentComponent implements OnInit {
  tournaments: Array<any>;

  constructor(private tournamentService: TournamentService,
    private betService: BetService,
    private afAuth: AngularFireAuth
  ) { }

  ngOnInit() {
    this.tournamentService.getAll().subscribe(
      data => {
        this.tournaments = data;
        console.log(this.tournaments)
      },
      error => console.log(error)
    )
  }

  tryPlaceBet(tournamentID: number, eventID: number, roundID: number,
    matchID: number, winningTeam: number) {
    console.log('Trying to place Bet');
    this.afAuth.currentUser.then(
      (user) => {
        if (user) {
          const bet:Bet = {
            posterID: user.uid,
            tournamentID: tournamentID,
            eventID: eventID,
            roundID: roundID,
            matchID: matchID,
            winningTeam: winningTeam
          }
          this.betService.placeBet(bet).subscribe((value) =>{
            console.log(value);
          })
        }
      }
    )
  }
}


import { Component, OnInit } from '@angular/core';
import {BetService} from '../../shared/services/bet/bet.service'
import { AngularFireAuth } from '@angular/fire/auth';
import { VerboseBet } from 'src/app/model/verboseBet';

@Component({
  selector: 'app-open-bets',
  templateUrl: './open-bets.component.html',
  styleUrls: ['./open-bets.component.css']
})
export class OpenBetsComponent implements OnInit {

  public vBets:[VerboseBet];

  constructor(private betService: BetService,private afAuth:AngularFireAuth) { }

  ngOnInit(): void {
    this.afAuth.currentUser.then((user) => {
      console.log(user.uid);
      this.betService.queryBets({
        amount:100,
        allUsers:false,
        userIDs:[user.uid],
        excludeUserIDs:[''],
        matchReferences:[{tournamentID:0,eventID:0,roundID:0,matchID:0}]
      }).subscribe(value => {
        this.vBets = value;
        console.log(value);
      })
    })
  }

  awayWon(vBet:VerboseBet):boolean{
    return(vBet.parent.winningTeam == 0);
}


}

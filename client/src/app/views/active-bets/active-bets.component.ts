import { Component, OnInit } from '@angular/core';
import { VerboseBet } from 'src/app/model';
import { BetService } from 'src/app/shared';
import { AngularFireAuth } from '@angular/fire/auth';
import { BetState } from 'src/app/model/bet-state.enum';

@Component({
  selector: 'app-active-bets',
  templateUrl: './active-bets.component.html',
  styleUrls: ['./active-bets.component.css','../bootstrap.min.css']
})
export class ActiveBetsComponent implements OnInit {

  public vBets: [VerboseBet];

  constructor(private betService: BetService, private afAuth: AngularFireAuth) { }

  ngOnInit(): void {
    console.log('init')
    this.afAuth.currentUser.then((user) => {
      console.log(user.uid);
      this.betService.queryBets({
        state: BetState.OPEN,
        amount: 100,
        allUsers: true,
        userIDs: [''],
        excludeUserIDs: [user.uid],
        matchReferences: [{ tournamentID: 0, eventID: 0, roundID: 0, matchID: 0 }]
      }).subscribe(value => {
        this.vBets = value;
        console.log(value);
      })
    })
  }

  awayWon(vBet: VerboseBet): boolean {
    return (vBet.parent.winningTeam != 0);
  }

  acceptBet(vBet: VerboseBet) {
    this.afAuth.currentUser.then((user) => {
      console.log(user.uid);
      this.betService.acceptBet({
        id: vBet.parent.id,
        userID: user.uid
      }).subscribe(value => {
        console.log(value);
        this.ngOnInit();
      })
    })
    
    return true;
  }
}

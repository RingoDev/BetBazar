import { Component, OnInit } from '@angular/core';
import { BetService, AuthService } from 'src/app/shared';
import { AngularFireAuth } from '@angular/fire/auth';
import { BetState } from 'src/app/model/bet-state.enum';
import { VerboseBet } from 'src/app/model';

@Component({
  selector: 'app-accepted-bets',
  templateUrl: './accepted-bets.component.html',
  styleUrls: ['./accepted-bets.component.css','../bootstrap.min.css']
})
export class AcceptedBetsComponent implements OnInit {

  public vBets:VerboseBet;

  constructor(private betService: BetService,
    private afAuth:AngularFireAuth,
    private authServive:AuthService) { }

  ngOnInit(): void {
    this.afAuth.currentUser.then((user) => {
      console.log(user.uid);
      this.betService.queryBets({
        state: BetState.ACCEPTED,
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

  isUserTeam(vBet:VerboseBet){
    if(vBet.parent.posterID == this.authServive.userID) return vBet.parent.winningTeam == 0;
    return vBet.parent.winningTeam != 0;
  }
}

import {MatchReference} from './matchReference'
export class Bet{
    posterID:String;
    accepterID:String;
    id : number;

    matchReference:MatchReference;
    // 0 or 1
    winningTeam: number;

}

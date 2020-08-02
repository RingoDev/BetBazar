import { MatchReference } from './matchReference';
import { BrowserTransferStateModule } from '@angular/platform-browser';
import {BetState} from './bet-state.enum'

export class BetQuery {
    state:BetState;
    allUsers: boolean;
    userIDs: [string];
    excludeUserIDs:[string];
    matchReferences: [MatchReference];
    amount:number;

}

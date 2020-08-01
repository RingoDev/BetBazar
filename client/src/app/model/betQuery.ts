import { MatchReference } from './matchReference';

export class BetQuery {
    allUsers: boolean;
    userIDs: [string];
    excludeUserIDs:[string];
    matchReferences: [MatchReference];
    amount:number;

}

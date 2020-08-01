package com.ringodev.server.data.bet;

import java.util.List;


public class BetQuery {



    int amount;

    /**
     * if flag is set, returns
     * bets from all Users except the one specifically
     * noted in excludeUserIDs List
     */
    boolean allUsers;

    List<String> userIDs;
    List<MatchReference> matchReferences;
    List<String> excludeUserIDs;

    public List<String> getUserIDs() {
        return userIDs;
    }

    public void setUserIDs(List<String> userIDs) {
        this.userIDs = userIDs;
    }

    public List<MatchReference> getMatchReferences() {
        return matchReferences;
    }

    public void setMatchReferences(List<MatchReference> matchReferences) {
        this.matchReferences = matchReferences;
    }

    public boolean isAllUsers() {
        return allUsers;
    }

    public void setAllUsers(boolean allUsers) {
        this.allUsers = allUsers;
    }

    public List<String> getExcludeUserIDs() {
        return excludeUserIDs;
    }

    public void setExcludeUserIDs(List<String> excludeUserIDs) {
        this.excludeUserIDs = excludeUserIDs;
    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

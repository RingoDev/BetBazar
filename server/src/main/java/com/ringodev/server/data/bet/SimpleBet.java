package com.ringodev.server.data.bet;

class SimpleBet {

    String posterID;
    MatchReference matchReference;
    int winningTeam;

    public String getPosterID() {
        return posterID;
    }

    public void setPosterID(String posterID) {
        this.posterID = posterID;
    }


    public int getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(int winningTeam) {
        this.winningTeam = winningTeam;
    }


    public MatchReference getMatchReference() {
        return matchReference;
    }

    public void setMatchReference(MatchReference matchReference) {
        this.matchReference = matchReference;
    }

    public Bet toBet() {
        return new Bet(this.posterID,
                this.matchReference,
                this.winningTeam);
    }

    @Override
    public String toString() {
        return "SimpleBet{" +
                "posterID='" + posterID + '\'' +
                ", matchReference=" + matchReference +
                ", winningTeam=" + winningTeam +
                '}';
    }
}

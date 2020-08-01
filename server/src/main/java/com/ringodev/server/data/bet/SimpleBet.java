package com.ringodev.server.data.bet;

class SimpleBet {

    String posterID;
    int tournamentID;
    int eventID;
    int roundID;
    int matchID;

    int winningTeam;

    public String getPosterID() {
        return posterID;
    }

    public void setPosterID(String posterID) {
        this.posterID = posterID;
    }

    public int getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getRoundID() {
        return roundID;
    }

    public void setRoundID(int roundID) {
        this.roundID = roundID;
    }

    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(int matchID) {
        this.matchID = matchID;
    }

    public int getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(int winningTeam) {
        this.winningTeam = winningTeam;
    }


    public Bet toBet() {
        return new Bet(this.posterID,
                this.tournamentID,
                this.eventID,
                this.roundID,
                this.matchID,
                this.winningTeam);
    }
}

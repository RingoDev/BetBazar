package com.ringodev.server.data.bet;

public class Bet {

    BetState state;

    // the User that opened the bet
    private final String posterID;

    //the User that agreed to the bet
    private String accepterID;

    int tournamentID, eventID, roundID, matchID, winningTeam;


    Bet(String posterID,
        int tournamentID,
        int eventID,
        int roundID,
        int matchID,
        int winningTeam) {
        this.posterID = posterID;
        this.tournamentID = tournamentID;
        this.eventID = eventID;
        this.roundID = roundID;
        this.matchID = matchID;
        this.winningTeam = winningTeam;

        state = BetState.OPEN;
    }

    public String getPosterID() {
        return posterID;
    }

    public String getAccepterID() {
        return accepterID;
    }

    public void setAccepterID(String accepterID) {
        this.accepterID = accepterID;
    }

    public BetState getState() {
        return state;
    }

    public void setState(BetState state) {
        this.state = state;
    }


    enum BetState {
        OPEN, ACCEPTED, CLOSED
    }

    public boolean acceptBet(String accepterID) {
        if (state != BetState.OPEN) return false;
        this.accepterID = accepterID;
        this.state = BetState.ACCEPTED;
        return true;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "state=" + state +

                ", posterID=" + posterID +
                ", accepterID=" + accepterID +
                '}';
    }
}




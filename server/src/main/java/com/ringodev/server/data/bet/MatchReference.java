package com.ringodev.server.data.bet;

public class MatchReference {

    public MatchReference(){}

    public MatchReference(long tournamentID,
                          long eventID,
                          long roundID,
                          long matchID
    ) {
        this.tournamentID = tournamentID;
        this.eventID = eventID;
        this.roundID = roundID;
        this.matchID = matchID;

    }

    long tournamentID;
    long eventID;
    long roundID;
    long matchID;

    public long getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(long tournamentID) {
        this.tournamentID = tournamentID;
    }

    public long getEventID() {
        return eventID;
    }

    public void setEventID(long eventID) {
        this.eventID = eventID;
    }

    public long getRoundID() {
        return roundID;
    }

    public void setRoundID(long roundID) {
        this.roundID = roundID;
    }

    public long getMatchID() {
        return matchID;
    }

    public void setMatchID(long matchID) {
        this.matchID = matchID;
    }

    @Override
    public String toString() {
        return "MatchReference{" +
                "tournamentID=" + tournamentID +
                ", eventID=" + eventID +
                ", roundID=" + roundID +
                ", matchID=" + matchID +
                '}';
    }
}

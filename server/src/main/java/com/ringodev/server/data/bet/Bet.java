package com.ringodev.server.data.bet;

public class Bet {

    BetState state;
    private final String name;

    // the User that opened the bet
    private final int posterID;

    //the User that agreed to the bet
    private int accepterID;

    private MatchReference matchRef;


    Bet(String name, int posterID){
        this.name = name;
        this.posterID = posterID;
        state = BetState.OPEN;
    }

    public int getPosterID() {
        return posterID;
    }

    public int getAccepterID() {
        return accepterID;
    }

    public void setAccepterID(int accepterID) {
        this.accepterID = accepterID;
    }

    public BetState getState() {
        return state;
    }

    public void setState(BetState state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    enum BetState{
        OPEN,ACCEPTED,CLOSED
    }

    public boolean acceptBet(int accepterID){
        if(state != BetState.OPEN)return false;
        this.accepterID = accepterID;
        this.state = BetState.ACCEPTED;
        return true;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "state=" + state +
                ", name='" + name + '\'' +
                ", posterID=" + posterID +
                ", accepterID=" + accepterID +
                ", matchRef=" + matchRef +
                '}';
    }
}




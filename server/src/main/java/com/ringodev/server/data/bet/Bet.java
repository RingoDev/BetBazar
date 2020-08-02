package com.ringodev.server.data.bet;

import com.ringodev.server.data.bet.database.BetState;
import com.ringodev.server.data.bet.database.SequenceGeneratorService;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Document(collection = "bets")
public class Bet {

    @Transient
    public static final String SEQUENCE_NAME = "bets_sequence";

    @Id
    private long id;

    BetState state;

    // the User that opened the bet
    private final String posterID;

    //the User that agreed to the bet
    private String accepterID;

    MatchReference matchReference;

    int  winningTeam;


    Bet(String posterID,
       MatchReference matchReference,
        int winningTeam) {
        this.posterID = posterID;
        this.matchReference = matchReference;
        this.winningTeam = winningTeam;

        state = BetState.OPEN;
    }




    public boolean acceptBet(String accepterID) {
        if (state != BetState.OPEN) return false;
        this.accepterID = accepterID;
        this.state = BetState.ACCEPTED;
        return true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BetState getState() {
        return state;
    }

    public void setState(BetState state) {
        this.state = state;
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

    public MatchReference getMatchReference() {
        return matchReference;
    }

    public void setMatchReference(MatchReference matchReference) {
        this.matchReference = matchReference;
    }

    public int getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(int winningTeam) {
        this.winningTeam = winningTeam;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "id=" + id +
                ", state=" + state +
                ", posterID='" + posterID + '\'' +
                ", accepterID='" + accepterID + '\'' +
                ", matchReference=" + matchReference +
                ", winningTeam=" + winningTeam +
                '}';
    }
}




package com.ringodev.server.data.bet;

/**
 * contains additional BetData such as tournament,event,round and player names
 */
public class BetData {
    String tournament,event,round,player1,player2;

    public BetData(String tournament, String event, String round, String player1, String player2) {
        this.tournament = tournament;
        this.event = event;
        this.round = round;
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

}

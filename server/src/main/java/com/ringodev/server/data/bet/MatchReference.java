package com.ringodev.server.data.bet;

public class MatchReference {

    public MatchReference(int tournament,
                          int event,
                          int round,
                          int match,
                          int winningPlayer) {
        this.tournament = tournament;
        this.event = event;
        this.round = round;
        this.match = match;
        this.winningPlayer = winningPlayer;
    }

    int tournament;
    int event;
    int round;    int match;
    int winningPlayer;

    @Override
    public String toString() {
        return "MatchReference{" +
                "tournament=" + tournament +
                ", event=" + event +
                ", round=" + round +
                ", match=" + match +
                '}';
    }
}

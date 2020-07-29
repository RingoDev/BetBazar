package com.ringodev.server.data.bet;

public class MatchReference {

    int tournament;
    int event;
    int round;
    int match;
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

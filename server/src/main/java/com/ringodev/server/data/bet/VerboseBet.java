package com.ringodev.server.data.bet;

import com.ringodev.server.data.tournaments.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * special format of a Bet that contains more discrete data
 */
public class VerboseBet {

    Bet parent;

    public Bet getParent() {
        return parent;
    }

    public void setParent(Bet parent) {
        this.parent = parent;
    }

    public BetData getData() {
        return data;
    }

    public void setData(BetData data) {
        this.data = data;
    }

    BetData data;

    private final TournamentRepository repository;

    public VerboseBet(TournamentRepository repository,Bet bet){
        this.parent = bet;
        this.repository = repository;
        this.data = getData(bet.matchReference);
    }

    @Override
    public String toString() {
        return "VerboseBet{" +
                "parent=" + parent +
                ", data=" + data +
                ", repository=" + repository +
                '}';
    }

    /**
     * searches the repository for the names of the matchReference
     * @param reference the MatchReference to transform
     * @return the verbose BetData
     */
    private BetData getData(MatchReference reference){

        Tournament tournament = repository.findById(reference.tournamentID).orElseThrow();
        Event event = tournament.getEvents().stream().filter(e -> e.getId().equals(reference.eventID)).findFirst().orElseThrow();
        Round round = event.getPhases().stream().filter(r -> r.getId().equals(reference.roundID)).findFirst().orElseThrow();
        Match match = round.getMatches().stream().filter(m -> m.getId().equals(reference.matchID)).findFirst().orElseThrow();
        Player p1 = match.getAway();
        Player p2 = match.getHome();
        return new BetData(tournament.getName(),event.getDesc(),round.getDesc(),p1.getDesc(),p2.getDesc());


    }
}

package com.ringodev.server.data.bet;

import com.ringodev.server.data.tournaments.TournamentRepository;
import com.ringodev.server.data.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("bets")
public class BetController {
    private final BetRepository bRepository;
    private final TournamentRepository tRepository;

    BetController(BetRepository bRepository,TournamentRepository tRepository) {
        this.bRepository = bRepository;
        this.tRepository = tRepository;

    }

    @GetMapping(path = "/byID/{userID}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Bet> getBets(@PathVariable("userID") String userID) {
        return this.bRepository.findAll().stream().filter(u -> (u.getPosterID().equals(userID) || u.getAccepterID().equals(userID))).collect(Collectors.toList());
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Bet> getOpenBets() {
        System.out.println("returned all bets");
        return this.bRepository.findAll().stream().filter(u -> (u.state == Bet.BetState.OPEN)).collect(Collectors.toList());
    }

    @PostMapping("/place")
    @CrossOrigin(origins = "http://localhost:4200")
    public boolean addUser(@RequestBody SimpleBet simpleBet) {
        System.out.println(simpleBet);
        bRepository.insert(simpleBet.toBet());
        bRepository.findAll().forEach(System.out::println);
        return true;
    }

    /**
     * accepts a posted JSON BetRequest Document and fulfills the query
     */
    @PostMapping("/query")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<VerboseBet> queryBets(@RequestBody BetQuery query) {

        List<VerboseBet> list = resolveQuery(query).stream().map(b -> new VerboseBet(tRepository,b)).collect(Collectors.toList());
        System.out.println(list);
        return list;
    }

    private List<Bet> resolveQuery(BetQuery query) {
        if (query.allUsers) return bRepository.findAll()
                .stream()
                .filter(bet-> !query.getExcludeUserIDs()
                        .contains(bet.getPosterID()))
                .limit(query.getAmount() == 0?10:query.getAmount())
                .collect(Collectors.toList());
        return bRepository.findAll().stream().filter(bet -> query.getUserIDs().contains(bet.getPosterID())).collect(Collectors.toList());
    }
}

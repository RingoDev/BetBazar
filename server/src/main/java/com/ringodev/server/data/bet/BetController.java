package com.ringodev.server.data.bet;

import com.ringodev.server.data.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("bets")
public class BetController {
    private final BetRepository repository;

    BetController(BetRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/byID/{userID}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Bet> getBets(@PathVariable("userID") String userID) {
        return this.repository.findAll().stream().filter(u -> (u.getPosterID().equals(userID) || u.getAccepterID().equals(userID))).collect(Collectors.toList());
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Bet> getOpenBets() {
        System.out.println("returned all bets");
        return this.repository.findAll().stream().filter(u -> (u.state == Bet.BetState.OPEN)).collect(Collectors.toList());
    }


    @PostMapping("/place")
    @CrossOrigin(origins = "http://localhost:4200")
    public boolean addUser(@RequestBody SimpleBet simpleBet) {
        repository.insert(simpleBet.toBet());
        System.out.println("ADDED BET" + simpleBet.toBet());
        return true;
    }
}

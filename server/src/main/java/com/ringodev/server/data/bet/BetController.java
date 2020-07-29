package com.ringodev.server.data.bet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("bets")
public class BetController {
    private final BetRepository repository;

    BetController(BetRepository repository){
        this.repository = repository;
    }

    @GetMapping(path = "/byID/{userID}")
    public List<Bet> getBets(@PathVariable("userID") int userID){
        return this.repository.findAll().stream().filter(u -> (u.getPosterID() == userID || u.getAccepterID() == userID)).collect(Collectors.toList());
    }

    @GetMapping("/all")
    public List<Bet> getOpenBets(){
       return this.repository.findAll().stream().filter(u -> (u.state == Bet.BetState.OPEN)).collect(Collectors.toList());
    }
}

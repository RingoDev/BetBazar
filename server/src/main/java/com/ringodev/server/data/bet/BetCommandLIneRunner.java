package com.ringodev.server.data.bet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BetCommandLIneRunner implements CommandLineRunner {

    private final BetRepository repository;

    BetCommandLIneRunner(BetRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... strings){
        repository.deleteAll();
        repository.save(new Bet("bet1",12345));
        repository.save(new Bet("bet2",12345));
        repository.findAll().forEach(System.out::println);
    }
}

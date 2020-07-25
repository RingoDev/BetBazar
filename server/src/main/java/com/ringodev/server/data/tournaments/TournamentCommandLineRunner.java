package com.ringodev.server.data.tournaments;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class TournamentCommandLineRunner implements CommandLineRunner {
    private final TournamentRepository repository;
    private final RestTemplate restTemplate;

    public TournamentCommandLineRunner(RestTemplate restTemplate, TournamentRepository repository) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... strings){
        //"M.DOUBLES","W.DOUBLES"
        List<Event> list = new ArrayList<>();
        String[] str = {"M.SINGLES", "W.SINGLES"};
        for (String s : str) {
            Event[] event = restTemplate.getForObject(
                    "https://results.ittf.com/ittf-web-results/html/TTE5146/brackets/" + s + "-----------.json", Event[].class);
            assert event != null;
            list.add(event[0]);
        }
        repository.save(new Tournament(list));
        repository.findAll().forEach(System.out::println);
    }
}

package com.ringodev.server.data.tournaments;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class TournamentController {
    private final TournamentRepository repository;

    public TournamentController(TournamentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tournaments")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Tournament> Tournaments() {
        return new ArrayList<>(repository.findAll());
    }
}

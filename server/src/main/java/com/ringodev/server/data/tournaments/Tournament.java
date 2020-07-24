package com.ringodev.server.data.tournaments;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tournament {

    public Tournament() {
    }

    public Tournament(List<Event> events) {
        this.events = events;
    }

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    List<Event> events;

    @Override
    public String toString() {
        return "Tournament{" +
                "events=" + events +
                '}';
    }
}

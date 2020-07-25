package com.ringodev.server.data.tournaments;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tournament {



    public Tournament() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tournament(List<Event> events) {
        this.events = events;
    }

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    List<Event> events;

    String name = "TESTNAME";

    @Override
    public String toString() {
        return "Tournament{" +
                "events=" + events +
                '}';
    }
}

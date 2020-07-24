package com.ringodev.server.data.tournaments;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Match {

    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("Home")
    @OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    Player home;
    @JsonProperty("Away")
    @OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    Player away;
    @JsonProperty("Info")
    @OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    Info info;

    @Override
    public String toString() {
        return "Match{" +
                "home=" + home +
                ", away=" + away +
                ", info=" + info +
                '}';
    }
}

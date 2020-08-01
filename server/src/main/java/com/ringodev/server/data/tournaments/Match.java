package com.ringodev.server.data.tournaments;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Match {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getHome() {
        return home;
    }

    public void setHome(Player home) {
        this.home = home;
    }

    public Player getAway() {
        return away;
    }

    public void setAway(Player away) {
        this.away = away;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("Home")
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    Player home;
    @JsonProperty("Away")
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    Player away;
    @JsonProperty("Info")
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
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

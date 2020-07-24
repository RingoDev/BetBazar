package com.ringodev.server.data.tournaments;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Round {


    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("Code")
    String code;
    @JsonProperty("Desc")
    String desc;
    @JsonProperty("Matches")
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    List<Match> matches;

    @Override
    public String toString() {
        return "Round{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                ", match=" + matches +
                '}';
    }
}

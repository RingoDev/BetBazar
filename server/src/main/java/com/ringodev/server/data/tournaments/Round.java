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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
    @Override
    public String toString() {
        return "Round{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                ", match=" + matches +
                '}';
    }
}

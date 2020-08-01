package com.ringodev.server.data.tournaments;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("Code")
    String code;
    @JsonProperty("Desc")
    String desc;
    @JsonProperty("isDoubles")
    boolean isDoubles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("Phases")
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    List<Round> phases;

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

    public boolean isDoubles() {
        return isDoubles;
    }

    public void setDoubles(boolean doubles) {
        isDoubles = doubles;
    }

    @ManyToMany
    public List<Round> getPhases() {
        return phases;
    }

    public void setPhases(List<Round> phases) {
        this.phases = phases;
    }

    @Override
    public String toString() {
        return "Event{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                ", isDoubles=" + isDoubles +
                ", phases=" + phases +
                '}';
    }
}

package com.ringodev.server.data.tournaments;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Info {


    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("Time")
    String time;
    @JsonProperty("Loc")
    String loc;
    @JsonProperty("LocDecs")
    String locDesc;
    @JsonProperty("HasTBD")
    boolean hasTBD;
    @JsonProperty("Status")
    String status;
    @JsonProperty("Code")
    String Code;
    @JsonProperty("isBye")
    boolean isBye;


    @Override
    public String toString() {
        return "Info{" +
                "time='" + time + '\'' +
                ", loc='" + loc + '\'' +
                ", locDesc='" + locDesc + '\'' +
                ", hasTBD=" + hasTBD +
                ", status='" + status + '\'' +
                ", Code='" + Code + '\'' +
                ", isBye=" + isBye +
                '}';
    }

}

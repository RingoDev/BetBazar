package com.ringodev.server.data.tournaments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("Reg")
    int reg;
    @JsonProperty("Desc")
    String Desc;
    @JsonProperty("Org")
    String country;
    @JsonProperty("Res")
    int result;
    @JsonProperty("Win")
    boolean win;

   // ranking position?
   @JsonProperty("RkPos")
    int RkPo;

    @Override
    public String toString() {
        return "Player{" +
                "reg=" + reg +
                ", Desc='" + Desc + '\'' +
                ", country='" + country + '\'' +
                ", result=" + result +
                ", win=" + win +
                ", RkPo=" + RkPo +
                '}';
    }
}

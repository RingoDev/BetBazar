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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getReg() {
        return reg;
    }

    public void setReg(int reg) {
        this.reg = reg;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public int getRkPo() {
        return RkPo;
    }

    public void setRkPo(int rkPo) {
        RkPo = rkPo;
    }

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

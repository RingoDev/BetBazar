package com.ringodev.server.data.bet;

public class AcceptBet {

    Long id;
    String userID;

    public AcceptBet(){}

    public Long getID() {
        return id;
    }

    public void setID(Long ID) {
        this.id = ID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "AcceptBet{" +
                "ID=" + id +
                ", UserID='" + userID + '\'' +
                '}';
    }
}

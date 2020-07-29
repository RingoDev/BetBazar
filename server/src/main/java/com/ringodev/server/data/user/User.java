package com.ringodev.server.data.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.MongoId;

public class User {

    public User() {

    }

    @MongoId
    @JsonProperty("uid")
    String id;
    @JsonProperty("email")
    String mail;
    @JsonProperty("displayName")
    String displayName;
    String firstName;
    String lastName;
    @JsonProperty("emailVerified")
    boolean verified;


    public User(String id, String mail, String displayName, String firstName, String lastName, boolean verified) {
        this.id = id;
        this.mail = mail;
        this.displayName = displayName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.verified = verified;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", displayName='" + displayName + '\'' +
                ", FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", verified=" + verified +
                '}';
    }

}

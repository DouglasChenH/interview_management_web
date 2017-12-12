package com.douglas.interview_management.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    @NotNull
    private String username;
    @NotNull
    private String password;

    @NotNull
    private String passwordConfirm;

    @NotNull
    private String emailAddress;

    @NotNull
    private String confirmationToken;

    @NotNull
    private Boolean enabled;

    public User(){}

    public User(String username, String password, String passwordConfirm, String emailAddress) {
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUserame(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    @Override
    //The convenient toString() method will print out the details about a customer.
    public String toString() {
        return String.format(
                "User[id=%s, username='%s', password='%s', passwordConfirm='%s' emailAddress='%s' confirmationToken='%s']",
                id, username, password, passwordConfirm, emailAddress, confirmationToken);
    }
}
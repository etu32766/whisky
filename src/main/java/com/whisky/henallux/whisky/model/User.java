package com.whisky.henallux.whisky.model;

import com.whisky.henallux.whisky.dataAccess.entity.OrderEntity;

import java.util.Set;

public class User {
    private String username;
    private String password;
    private String authorities;
    private String firstname;
    private String lastname;
    private String email;
    private String adresse;
    private String numberTVA;
    private boolean non_expired;
    private boolean non_locked;
    private boolean credentials_non_expired;
    private boolean enabled;

    public User(){}

    public void setEnabled(boolean enabled) { this.enabled = enabled; }
    public void setNon_locked(boolean non_locked) { this.non_locked = non_locked; }
    public void setNon_expired(boolean non_expired) { this.non_expired = non_expired; }
    public void setNumberTVA(String numberTVA) { this.numberTVA = numberTVA; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setEmail(String email) { this.email = email; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setAuthorities(String authorities) { this.authorities = authorities; }
    public void setPassword(String password) { this.password = password; }
    public void setUsername(String username) { this.username = username; }
    public void setCredentials_non_expired(boolean credentials_non_expired) {this.credentials_non_expired = credentials_non_expired; }

    public String getUsername() { return username; }
    public boolean isCredentials_non_expired() { return credentials_non_expired; }
    public boolean isNon_locked() { return non_locked; }
    public boolean isNon_expired() { return non_expired; }
    public String getAdresse() { return adresse; }
    public String getEmail() { return email; }
    public String getLastname() { return lastname;}
    public String getFirstname() { return firstname;}
    public String getAuthorities() { return authorities; }
    public boolean isEnabled() { return enabled; }
    public String getNumberTVA() { return numberTVA; }
    public String getPassword() { return password; }
}

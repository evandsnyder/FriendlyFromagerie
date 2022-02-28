package com.friendlygeek.friendly_rest.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {
    @Id
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private boolean isActive;
    private Set<Role> roles;

    public User(){}

//    public User(RegisterRequest registration, Role role){
//        username = registration.getUsername();
//        firstName = registration.getFirstName();
//        lastName = registration.getLastName();
//        phoneNumber = registration.getPhoneNumber();
//        email = registration.getEmail();
//        password = registration.getPassword();
//        isActive = true;
//        roles = new HashSet<>();
//        roles.add(role);
//    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<Role> getRoles() {
        if(roles == null){
            roles = new HashSet<>();
        }

        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

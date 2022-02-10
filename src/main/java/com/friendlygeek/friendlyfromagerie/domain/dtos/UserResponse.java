package com.friendlygeek.friendlyfromagerie.domain.dtos;

import com.friendlygeek.friendlyfromagerie.domain.models.User;

public class UserResponse {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public UserResponse(User user){
        id = user.getId();
        username = user.getUsername();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        phoneNumber = user.getPhoneNumber();
        email = user.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}

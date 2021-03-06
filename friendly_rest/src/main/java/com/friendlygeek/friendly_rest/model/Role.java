package com.friendlygeek.friendly_rest.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Role implements Serializable {
    @Id
    private String id;
    private String role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

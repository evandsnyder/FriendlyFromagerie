package com.friendlygeek.friendlyfromagerie.domain.models;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="role_id")
    private Integer id;
    private String role;
    
	public Integer getId() {
		return id;
	}
	public String getRole() {
		return role;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setRole(String role) {
		this.role = role;
	}
    
    
}

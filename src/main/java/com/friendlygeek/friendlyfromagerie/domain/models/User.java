package com.friendlygeek.friendlyfromagerie.domain.models;

import com.friendlygeek.friendlyfromagerie.domain.dtos.RegisterRequest;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="user_id")
	private Integer id;
	private String username;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String password;
	private boolean isActive;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;

	public User(){}

	public User(RegisterRequest registration, Role role){
		username = registration.getUsername();
		firstName = registration.getFirstName();
		lastName = registration.getLastName();
		phoneNumber = registration.getPhoneNumber();
		email = registration.getEmail();
		password = registration.getPassword();
		isActive = true;
		roles = new HashSet<>();
		roles.add(role);

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
		if(roles == null) {
			roles = new HashSet<>();
		}
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}

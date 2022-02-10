package com.friendlygeek.friendlyfromagerie.service;

import com.friendlygeek.friendlyfromagerie.domain.dtos.LoginRequest;
import com.friendlygeek.friendlyfromagerie.domain.dtos.RegisterRequest;
import com.friendlygeek.friendlyfromagerie.domain.models.User;
import com.friendlygeek.friendlyfromagerie.repository.RepositoryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private RepositoryWrapper repository;

	public User authenticate(LoginRequest loginRequest) {
		User user = repository.getUsers().findFirstByUsernameOrEmail(loginRequest.getUsername());
		return user.getPassword().equals(loginRequest.getPassword()) ? user : null;

	}

	public User register(RegisterRequest registerRequest){
		// convert
		repository.getUsers().save(new User(registerRequest));
		return null;
	}
}

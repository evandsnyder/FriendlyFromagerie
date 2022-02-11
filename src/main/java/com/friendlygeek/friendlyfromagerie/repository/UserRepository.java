package com.friendlygeek.friendlyfromagerie.repository;

import com.friendlygeek.friendlyfromagerie.domain.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	@Query("select u from User u where u.username = ?1 or u.email = ?1")
    User findFirstByUsernameOrEmail(String name);
}

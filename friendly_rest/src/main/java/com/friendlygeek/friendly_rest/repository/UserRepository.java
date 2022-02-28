package com.friendlygeek.friendly_rest.repository;

import com.friendlygeek.friendly_rest.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends MongoRepository<User, String> {

    User findFirstByUsername(@Param("username") String username);
}

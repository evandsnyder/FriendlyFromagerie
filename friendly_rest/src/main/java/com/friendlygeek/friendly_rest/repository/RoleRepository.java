package com.friendlygeek.friendly_rest.repository;


import com.friendlygeek.friendly_rest.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "role", path="role")
public interface RoleRepository extends MongoRepository<Role, String> {
}

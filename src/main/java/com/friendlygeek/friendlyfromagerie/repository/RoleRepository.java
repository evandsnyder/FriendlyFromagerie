package com.friendlygeek.friendlyfromagerie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}

package com.friendlygeek.friendlyfromagerie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.friendlygeek.friendlyfromagerie.domain.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}

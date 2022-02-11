package com.friendlygeek.friendlyfromagerie.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryWrapper {

    @Autowired
    private UserRepository users;
    @Autowired
    private RecipeRepository recipes;
    @Autowired
    private RoleRepository roles;

    public UserRepository getUsers() {
        return users;
    }

    public void setUsers(UserRepository users) {
        this.users = users;
    }

    public RecipeRepository getRecipes() {
        return recipes;
    }

    public void setRecipes(RecipeRepository recipes) {
        this.recipes = recipes;
    }

    public RoleRepository getRoles() {
        return roles;
    }

    public void setRoles(RoleRepository roles) {
        this.roles = roles;
    }
}

package com.friendlygeek.friendly_rest.repository;

import com.friendlygeek.friendly_rest.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "recipes", path="recipes")
public interface RecipeRepository extends MongoRepository<Recipe, String> {
    List<Recipe> findAllByPublishIsTrue();
}

package com.friendlygeek.friendlyfromagerie.repository;

import com.friendlygeek.friendlyfromagerie.domain.models.CheeseRecipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<CheeseRecipe, Integer> {
    List<CheeseRecipe> getAllRecipes();
}
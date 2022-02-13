package com.friendlygeek.friendlyfromagerie.repository;

import com.friendlygeek.friendlyfromagerie.domain.models.CheeseRecipe;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecipeRepository extends CrudRepository<CheeseRecipe, Integer> {
}

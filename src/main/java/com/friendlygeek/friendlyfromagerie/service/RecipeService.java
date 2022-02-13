package com.friendlygeek.friendlyfromagerie.service;

import com.friendlygeek.friendlyfromagerie.domain.models.CheeseRecipe;
import com.friendlygeek.friendlyfromagerie.repository.RepositoryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService {
	@Autowired
	private RepositoryWrapper repository;
	
	/**
	 * Validates that a recipe is valid
	 * @param recipe - recipe to validate
	 * @return boolean
	 */
	public boolean isValidRecipe(CheeseRecipe recipe) {
		return !recipe.getCheeseType().isEmpty() 
				&& !recipe.getHardness().isEmpty() 
				&& !recipe.getMilkType().isEmpty()
				&& !recipe.getIngredients().isEmpty() 
				&& !recipe.getWarmTheMilk().isEmpty()
				&& !recipe.getCultureAndCoagulate().isEmpty() 
				&& !recipe.getLadleTheCurd().isEmpty()
				&& !recipe.getDrainTheCurd().isEmpty() 
				&& !recipe.getTargetFlavorAndTexture().isEmpty()
				&& !recipe.getStorage().isEmpty();
	}

	public CheeseRecipe saveRecipe(CheeseRecipe recipe){
		return repository.getRecipes().save(recipe);
	}

	public Iterable<CheeseRecipe> getAllRecipes(){
		return repository.getRecipes().findAll();
	}

	public Optional<CheeseRecipe> getRecipe(Integer id){
		return repository.getRecipes().findById(id);
	}
}

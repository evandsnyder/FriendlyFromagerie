package com.friendlygeek.friendlyfromagerie.managers;

import com.friendlygeek.friendlyfromagerie.domain.CheeseRecipe;

public class CheeseRecipeManager {
	public CheeseRecipeManager() {
	}
	
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
}

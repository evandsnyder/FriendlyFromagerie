package managers;

import domain.CheeseRecipeBean;

public class EditCheeseRecipeManager {
	public EditCheeseRecipeManager() {}
	
	public boolean isValidRecipe(CheeseRecipeBean recipe) {
		return !recipe.getCheeseType().isEmpty() &&
				!recipe.getHardness().isEmpty() &&
				!recipe.getMilkType().isEmpty() &&
				!recipe.getIngredients().isEmpty() &&
				!recipe.getWarmTheMilk().isEmpty() &&
				!recipe.getCultureAndCoagulate().isEmpty() &&
				!recipe.getLadleTheCurd().isEmpty() &&
				!recipe.getDrainTheCurd().isEmpty() &&
				!recipe.getTargetFlavorAndTexture().isEmpty() &&
				!recipe.getStorage().isEmpty();
	}
}

package test;

import static org.junit.Assert.*;

import domain.CheeseRecipeBean;
import managers.EditCheeseRecipeManager;

import org.junit.Test;

public class EditCheeseRecipeManagerTest {

	@Test
	public void testValidRecipe() {
		CheeseRecipeBean recipe = new CheeseRecipeBean();
		recipe.setCheeseType("recipe-info");
		recipe.setHardness("recipe-info");
		recipe.setMilkType("recipe-info");
		recipe.setIngredients("recipe-info");
		recipe.setWarmTheMilk("recipe-info");
		recipe.setCultureAndCoagulate("recipe-info");
		recipe.setLadleTheCurd("recipe-info");
		recipe.setDrainTheCurd("recipe-info");
		recipe.setTargetFlavorAndTexture("recipe-info");
		recipe.setStorage("recipe-info");
		assertTrue("This is should be a valid recipe", (new EditCheeseRecipeManager()).isValidRecipe(recipe));
	}
	
	@Test
	public void testInvalidRecipe() {
		CheeseRecipeBean recipe = new CheeseRecipeBean();
		recipe.setCheeseType("recipe-info");
		recipe.setHardness("recipe-info");
		recipe.setMilkType("recipe-info");
		recipe.setIngredients("recipe-info");
		recipe.setWarmTheMilk("recipe-info");
		recipe.setCultureAndCoagulate("recipe-info");
		recipe.setLadleTheCurd("recipe-info");
		recipe.setDrainTheCurd("recipe-info");
		recipe.setTargetFlavorAndTexture("recipe-info");
		recipe.setStorage("");
		assertFalse("This is should be an invalid recipe", (new EditCheeseRecipeManager()).isValidRecipe(recipe));
	}

}

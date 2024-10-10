package org.joutak.customjoucrafting.crafts;

import org.joutak.customjoucrafting.CustomJouCrafting;

import java.util.ArrayList;
import java.util.List;

public class Recipes {

    private static List<Recipe> recipes = new ArrayList<>();

    public static List<Recipe> getRecipes() {
        return recipes;
    }

    public static void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        CustomJouCrafting.getInstance().getServer().addRecipe(recipe.getRecipe());
    }
}

package org.joutak.customjoucrafting.crafts;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public abstract class Recipe {

    protected ShapedRecipe recipe;
    protected NamespacedKey namespacedKey;

    public abstract boolean checkIfThisRecipe(ItemStack[] matrix, ItemStack result);

    public abstract boolean checkIfRecipeIsOk(ItemStack[] matrix, ItemStack result);

    public ShapedRecipe getRecipe() {
        return recipe;
    }

    public NamespacedKey getNamespacedKey() {
        return namespacedKey;
    }
}

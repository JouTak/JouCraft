package org.joutak.customjoucrafting.event;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.joutak.customjoucrafting.crafts.Recipe;
import org.joutak.customjoucrafting.crafts.Recipes;

import java.util.EventListener;

public class CraftingEventHandler implements EventListener, Listener {

    @EventHandler
    public void playerPrepareCraftEvent(PrepareItemCraftEvent event) {

        if (event.getRecipe() == null) {
            return;
        }
        ItemStack[] matrix = event.getInventory().getMatrix();
        ItemStack result = event.getRecipe().getResult();

        Recipe recipe = checkIfCustomRecipe(matrix, result);
        if (recipe == null) {
            return;
        }

        if (!recipe.checkIfRecipeIsOk(matrix, result)) {
            event.getInventory().setResult(ItemStack.of(Material.AIR));
        }

    }

    @EventHandler
    public void playerCraftEvent(CraftItemEvent event) {

        ItemStack[] matrix = event.getInventory().getMatrix();
        ItemStack result = event.getRecipe().getResult();

        Recipe recipe = checkIfCustomRecipe(matrix, result);
        if (recipe == null) {
            return;
        }

        if (!event.getWhoClicked().hasDiscoveredRecipe(recipe.getNamespacedKey())) {
            event.getWhoClicked().discoverRecipe(recipe.getNamespacedKey());
        }
    }

    private Recipe checkIfCustomRecipe(ItemStack[] matrix, ItemStack result) {
        return Recipes.getRecipes().stream()
                .filter(it -> it.checkIfThisRecipe(matrix, result))
                .findFirst().orElseGet(null);
    }

}

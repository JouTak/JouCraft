package org.joutak.customjoucrafting.crafts.recipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.data.type.Light;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.BlockDataMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.joutak.customjoucrafting.crafts.Recipe;

public class LightLvl15Recipe extends Recipe {

    public LightLvl15Recipe() {
        ItemStack itemStack = new ItemStack(Material.LIGHT, 32);

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.getAsString();

        Light light = (Light) Material.LIGHT.createBlockData();
        light.setLevel(15);

        ((BlockDataMeta) itemMeta).setBlockData(light);
        itemStack.setItemMeta(itemMeta);

        namespacedKey = new NamespacedKey("jou_craft", "light_lvl_15");

        recipe = new ShapedRecipe(namespacedKey, itemStack);

        recipe.shape("ALA", "LBL", "ALA");

        recipe.setIngredient('A', Material.AMETHYST_CLUSTER);
        recipe.setIngredient('L', Material.LIGHT);
        recipe.setIngredient('B', Material.BEACON);
    }

    @Override
    public boolean checkIfThisRecipe(ItemStack[] matrix, ItemStack result) {
        return result.getItemMeta().getAsString().contains("level:\"15\"");
    }

    @Override
    public boolean checkIfRecipeIsOk(ItemStack[] matrix, ItemStack result) {
        return matrix[1].getItemMeta().getAsString().contains("level:\"10\"") &&
                matrix[3].getItemMeta().getAsString().contains("level:\"10\"") &&
                matrix[5].getItemMeta().getAsString().contains("level:\"10\"") &&
                matrix[7].getItemMeta().getAsString().contains("level:\"10\"");
    }

}

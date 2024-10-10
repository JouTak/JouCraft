package org.joutak.customjoucrafting.crafts.recipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.data.type.Light;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.BlockDataMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;
import org.joutak.customjoucrafting.crafts.Recipe;

import java.util.Objects;

public class LightLvl5Recipe extends Recipe {

    public LightLvl5Recipe() {
        ItemStack itemStack = new ItemStack(Material.LIGHT, 4);

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.getAsString();

        Light light = (Light) Material.LIGHT.createBlockData();
        light.setLevel(5);

        ((BlockDataMeta) itemMeta).setBlockData(light);
        itemStack.setItemMeta(itemMeta);

        namespacedKey = new NamespacedKey("jou_craft", "light_lvl_5");

        recipe = new ShapedRecipe(namespacedKey, itemStack);

        recipe.shape("*C*", "GIS", "*B*");

        recipe.setIngredient('C', Material.CANDLE);
        recipe.setIngredient('G', Material.GLOWSTONE);
        recipe.setIngredient('I', Material.POTION);
        recipe.setIngredient('S', Material.SHROOMLIGHT);
        recipe.setIngredient('B', Material.COPPER_BULB);
    }

    @Override
    public boolean checkIfThisRecipe(ItemStack[] matrix, ItemStack result) {
        return result.getItemMeta().getAsString().contains("level:\"5\"");
    }

    @Override
    public boolean checkIfRecipeIsOk(ItemStack[] matrix, ItemStack result) {
        return Objects.equals(((PotionMeta) matrix[4].getItemMeta()).getBasePotionType(), PotionType.INVISIBILITY);
    }
}

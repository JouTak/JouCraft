package org.joutak.customjoucrafting;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.joutak.customjoucrafting.crafts.Recipes;
import org.joutak.customjoucrafting.crafts.recipes.LightLvl10Recipe;
import org.joutak.customjoucrafting.crafts.recipes.LightLvl15Recipe;
import org.joutak.customjoucrafting.crafts.recipes.LightLvl5Recipe;
import org.joutak.customjoucrafting.event.CraftingEventHandler;

public final class CustomJouCrafting extends JavaPlugin {

    private static CustomJouCrafting instance;

    @Override
    public void onEnable() {

        instance = this;

        Bukkit.getPluginManager().registerEvents(new CraftingEventHandler(), this);

        addRecipes();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void addRecipes() {
        Recipes.addRecipe(new LightLvl5Recipe());
        Recipes.addRecipe(new LightLvl10Recipe());
        Recipes.addRecipe(new LightLvl15Recipe());
    }

    public static CustomJouCrafting getInstance() {
        return instance;
    }
}

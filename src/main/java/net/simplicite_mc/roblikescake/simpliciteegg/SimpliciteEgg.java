package net.simplicite_mc.roblikescake.simpliciteegg;

import org.bukkit.plugin.java.JavaPlugin;

import net.simplicite_mc.roblikescake.simpliciteegg.listeners.PlayerListener;

public class SimpliciteEgg extends JavaPlugin{

    @Override
    public void onEnable() {
        PlayerListener playerListener = new PlayerListener(this);
        getServer().getPluginManager().registerEvents(playerListener, this);
        this.getServer().addRecipe(playerListener.getAnimalCatcherRecipe());
    }

    @Override
    public void onDisable() {
        getServer().clearRecipes();
    }
}

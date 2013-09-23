package net.simplicite_mc.roblikescake.simpliciteegg;

import net.simplicite_mc.roblikescake.simpliciteegg.listeners.PlayerListener;

import org.bukkit.plugin.java.JavaPlugin;

public class SimpliciteEgg extends JavaPlugin{

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
        this.getServer().addRecipe(AnimalCatcher);
    }

    @Override
    public void onDisable() {
        getServer().clearRecipes();
    }


}

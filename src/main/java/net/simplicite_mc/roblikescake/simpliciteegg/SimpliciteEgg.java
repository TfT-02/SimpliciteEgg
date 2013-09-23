package net.simplicite_mc.roblikescake.simpliciteegg;

import net.simplicite_mc.roblikescake.simpliciteegg.listeners.PlayerListener;

import org.bukkit.plugin.java.JavaPlugin;

public class SimpliciteEgg extends JavaPlugin{

    @Override
    public void onEnable() {
        PlayerListener listener = new PlayerListener(this);
        getServer().getPluginManager().registerEvents(listener, this);
        this.getServer().addRecipe(listener.AnimalCatcher);
    }

    @Override
    public void onDisable() {
        getServer().clearRecipes();
    }


}

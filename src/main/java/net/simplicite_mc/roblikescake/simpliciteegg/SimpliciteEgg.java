package net.simplicite_mc.roblikescake.simpliciteegg;

import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpliciteEgg extends JavaPlugin{

    @Override
    public void onEnable() {
        loadConfig();
    }

    @Override
    public void onDisable() {
        unloadConfig();
    }

    public void loadConfig() {
        saveDefaultConfig();
        saveConfig();
    }

    public void unloadConfig() {
        reloadConfig();
        saveConfig();
    }

    public void onSpawnEggUse(CreatureSpawnEvent event) {
    }

    public void onCaptureMob() {
    }
}

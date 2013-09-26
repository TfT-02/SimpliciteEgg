package net.simplicite_mc.roblikescake.simpliciteegg.listeners;

import net.simplicite_mc.roblikescake.simpliciteegg.SimpliciteEgg;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;


public class PlayerListener implements Listener {
    public SimpliciteEgg plugin;
    public PlayerListener(SimpliciteEgg i) {
        plugin = i;
    }


    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void PlayerCatchAnimal(PlayerInteractEntityEvent event) {
        String pluginPrefix = ChatColor.BLACK + "[" + ChatColor.AQUA + "SMC" + ChatColor.GRAY + "-" + ChatColor.DARK_AQUA + "Egg" + ChatColor.BLACK + "]";
        Player player = event.getPlayer();
        Entity interactedEntity = event.getRightClicked();
        EntityType interactedEntityType = interactedEntity.getType();
        String interactedEntityName = interactedEntity.getType().name();
        Location location = interactedEntity.getLocation();
        ItemStack itemStack = player.getItemInHand();

        if (itemStack.getType() != Material.EGG) {
            return;
        }
        if (itemStack.isSimilar(setName(new ItemStack(Material.EGG), ChatColor.AQUA + "AnimalCatcher"))) {
            if (interactedEntityType == EntityType.CHICKEN) {
                player.getWorld().dropItemNaturally(location, new ItemStack(Material.MONSTER_EGG, 1, (short) 93));
            } else if (interactedEntityType == EntityType.COW) {
                player.getWorld().dropItemNaturally(location, new ItemStack(Material.MONSTER_EGG, 1, (short) 92));
            } else if (interactedEntityType == EntityType.HORSE) {
                player.getWorld().dropItemNaturally(location, new ItemStack(Material.MONSTER_EGG, 1, (short) 100));
            } else if (interactedEntityType == EntityType.MUSHROOM_COW) {
                player.getWorld().dropItemNaturally(location, new ItemStack(Material.MONSTER_EGG, 1, (short) 96));
            } else if (interactedEntityType == EntityType.OCELOT) {
                player.getWorld().dropItemNaturally(location, new ItemStack(Material.MONSTER_EGG, 1, (short) 98));
            } else if (interactedEntityType == EntityType.PIG) {
                player.getWorld().dropItemNaturally(location, new ItemStack(Material.MONSTER_EGG, 1, (short) 90));
            } else if (interactedEntityType == EntityType.SHEEP) {
                player.getWorld().dropItemNaturally(location, new ItemStack(Material.MONSTER_EGG, 1, (short) 91));
            } else if (interactedEntityType == EntityType.SQUID) {
                player.getWorld().dropItemNaturally(location, new ItemStack(Material.MONSTER_EGG, 1, (short) 94));
            } else if (interactedEntityType == EntityType.WOLF) {
                player.getWorld().dropItemNaturally(location, new ItemStack(Material.MONSTER_EGG, 1, (short) 95));
            } else if (interactedEntityType == EntityType.VILLAGER) {
                player.getWorld().dropItemNaturally(location, new ItemStack(Material.MONSTER_EGG, 1, (short) 120));
            } else {
                event.setCancelled(true);
                return;
            }
            player.launchProjectile(Egg.class);
            interactedEntity.remove();
            location.getWorld().playEffect(location, Effect.SMOKE, 4);
            player.sendMessage(pluginPrefix + ChatColor.GREEN + " You caught a " + ChatColor.BLUE + interactedEntityName + ChatColor.GREEN + "!");
        }
    }
    public ShapedRecipe AnimalCatcher = new ShapedRecipe(setName(new ItemStack(Material.EGG), ChatColor.AQUA + "AnimalCatcher")).shape(" ! ","!!!"," ! ").setIngredient('!', Material.EGG);

    public ItemStack setName(ItemStack item, String name) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }
}

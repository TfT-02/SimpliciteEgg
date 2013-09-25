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
        String pluginPrefix = ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "SMC " + ChatColor.BLUE + "-" + ChatColor.AQUA + "Egg" + ChatColor.DARK_GRAY + "]";
        Player player = event.getPlayer();
        Entity interactedEntity = event.getRightClicked();
        String interactedEntityName = interactedEntity.getType().name();
        Location location = interactedEntity.getLocation();
        ItemStack itemStack = player.getItemInHand();
        ItemStack interactedEntityEgg = new ItemStack(Material.MONSTER_EGG).setDurability(interactedEntity.getEntityId());

        if (itemStack.getType() != Material.EGG) {
            System.out.println("This aint an egg!");
            return;
        }
        if (itemStack.equals(setName(new ItemStack(Material.EGG), ChatColor.AQUA + "AnimalCatcher"))) {
            System.out.println("Its a custom egg!");
            player.launchProjectile(Egg.class);
            System.out.println("Egg launched!");
            location.getWorld().playEffect(location, Effect.POTION_BREAK, 4);
            System.out.println("Potion sound!");
            interactedEntity.remove();
            System.out.println("Entity removed!");
            location.getWorld().playEffect(location, Effect.SMOKE, 4);
            System.out.println("Smoke effect!");
            interactedEntity.getWorld().dropItemNaturally(location, new ItemStack(interactedEntityEgg));
            System.out.println("Spawn egg dropped!");
            player.sendMessage(pluginPrefix + ChatColor.GREEN + " You caught a " + ChatColor.DARK_AQUA + interactedEntityName + ChatColor.GREEN + "!");
        } else {  System.out.println("Shit aint custom named tho!"); }
    }
    public ShapedRecipe AnimalCatcher = new ShapedRecipe(setName(new ItemStack(Material.EGG), ChatColor.AQUA + "AnimalCatcher")).shape(" ! ","!!!"," ! ").setIngredient('!', Material.EGG);

    public ItemStack setName(ItemStack item, String name) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }
}

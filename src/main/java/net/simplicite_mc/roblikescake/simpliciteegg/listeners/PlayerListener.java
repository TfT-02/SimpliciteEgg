package net.simplicite_mc.roblikescake.simpliciteegg.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import net.simplicite_mc.roblikescake.simpliciteegg.SimpliciteEgg;


public class PlayerListener implements Listener {
    public SimpliciteEgg plugin;

    public PlayerListener(SimpliciteEgg i) {
        plugin = i;
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void PlayerCatchAnimal(PlayerInteractEntityEvent event) {
        String pluginPrefix = ChatColor.BLACK + "[" + ChatColor.AQUA + "SMC" + ChatColor.GRAY + "-" + ChatColor.DARK_AQUA + "Egg" + ChatColor.BLACK + "]";
        Player player = event.getPlayer();
        ItemStack itemStack = player.getItemInHand();

        if (!itemStack.isSimilar(getAnimalCatcher())) {
            return;
        }

        Entity entity = event.getRightClicked();

        short dataValue = getEntityShort(entity.getType());

        if (dataValue == 0) {
            event.setCancelled(true);
            return;
        }

        Location location = entity.getLocation();

        player.getWorld().dropItemNaturally(location, new ItemStack(Material.MONSTER_EGG, 1, dataValue));
        player.launchProjectile(Egg.class);
        entity.remove();
        location.getWorld().playEffect(location, Effect.SMOKE, 4);
        player.sendMessage(pluginPrefix + ChatColor.GREEN + " You caught a " + ChatColor.BLUE + entity.getType().name() + ChatColor.GREEN + "!");
    }

    public short getEntityShort(EntityType entityType) {
        switch (entityType) {
            case PIG:
                return 90;
            case SHEEP:
                return 91;
            case COW:
                return 92;
            case CHICKEN:
                return 93;
            case SQUID:
                return 94;
            case WOLF:
                return 95;
            case MUSHROOM_COW:
                return 96;
            case OCELOT:
                return 98;
            case HORSE:
                return 100;
            case VILLAGER:
                return 120;
            default:
                return 0;
        }
    }

    public ShapedRecipe getAnimalCatcherRecipe() {
        ShapedRecipe AnimalCatcher = new ShapedRecipe(getAnimalCatcher());
        AnimalCatcher.shape(" X ", "XXX", " X ");
        AnimalCatcher.setIngredient('X', Material.EGG);

        return AnimalCatcher;
    }

    public ItemStack getAnimalCatcher() {
        ItemStack itemStack = new ItemStack(Material.EGG);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.AQUA + "AnimalCatcher");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}

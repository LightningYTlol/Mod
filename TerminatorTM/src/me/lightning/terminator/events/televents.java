package me.lightning.terminator.events;

import me.lightning.terminator.items.itemManager;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import static org.bukkit.Sound.ENTITY_ENDERMAN_TELEPORT;

public class televents implements Listener {

    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() !=null) {
                if (event.getItem().getItemMeta().equals(itemManager.Telewand.getItemMeta())) {
                    Player player = event.getPlayer();
                    Location l = player.getLocation().clone();
                    l.add(player.getEyeLocation().getDirection().multiply(8));
                    player.playSound(player.getLocation(), ENTITY_ENDERMAN_TELEPORT, 1f, 1f);
                    player.teleport(l);
                }
            }
        }
    }
}

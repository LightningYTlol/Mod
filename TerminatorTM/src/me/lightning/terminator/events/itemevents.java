package me.lightning.terminator.events;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import me.lightning.terminator.items.itemManager;
import org.bukkit.util.Vector;

import static org.bukkit.Sound.ENTITY_ENDERMAN_TELEPORT;

public class itemevents implements Listener {

    @EventHandler
    public static void onLeftClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(itemManager.Terminator.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.launchProjectile(Arrow.class);
                    player.launchProjectile(Arrow.class);
                    player.launchProjectile(Arrow.class);
                }
            }
        }
    }
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Arrow) {
            Arrow arrow = (Arrow)e.getDamager();
            if (arrow.getShooter() instanceof Player) {
                e.setDamage(100);
            }
        }
    }
}

package me.lightning.terminator.events;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import me.lightning.terminator.items.itemManager;

import java.util.Objects;

import static org.bukkit.Sound.ENTITY_ENDERMAN_TELEPORT;

public class itemevents implements Listener {

    @EventHandler
    public static void onLeftClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (Objects.requireNonNull(event.getItem().getItemMeta()).equals(itemManager.Terminator.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.launchProjectile(Arrow.class);
                    player.launchProjectile(Arrow.class);
                    player.launchProjectile(Arrow.class);
                }
            }
        }
    }
    public void onEnitityDamageByEntity(EntityDamageByEntityEvent e){
        Player damager;
        if(e.getDamager() instanceof Player){
            damager = (Player) e.getDamager();
        }
        if(e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE){
            e.setDamage(100);
        }

    }
}

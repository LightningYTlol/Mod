package me.lightning.terminator;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftLivingEntity;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public abstract class terminator implements Listener {
    @NotNull
    @Contract(" -> new")
    public static ItemStack getTerminator() {
        return new ItemStack(Material.BOW);
    }
    @EventHandler
    public void onLeftClick(@org.jetbrains.annotations.NotNull PlayerInteractEvent event, Object plugin) {
        Player p = event.getPlayer();
        if (event.getAction() == Action.LEFT_CLICK_AIR) {
            if (Objects.requireNonNull(event.getItem()).getType() == Material.BOW){
                CraftLivingEntity player = null;
                assert false;
                player.launchProjectile(Arrow.class);
            }
        }
    }

    public terminator(Main plugin) {

    }
}

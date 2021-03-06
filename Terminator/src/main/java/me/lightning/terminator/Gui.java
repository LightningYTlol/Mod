package me.lightning.terminator;

import me.lightning.terminator.items.itemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class Gui implements Listener {

    private Inventory gui;

    public void openNewGui(Player p) {
        gui = Bukkit.createInventory(null, 54, "Test");

        ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 100);

        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.GOLD + "This is button o.o");
        item.setItemMeta(meta);


        gui.setItem(2, item);
        gui.setItem(3, item);
        gui.setItem(4, item);
        gui.setItem(5, item);

        p.openInventory(gui);

    }


    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory() != gui) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType().isAir()) return;

        final Player p = (Player) e.getWhoClicked();

        // Using slots click is a best option for your inventory click's
        p.getInventory().addItem(itemManager.Terminator);
        p.getInventory().addItem(itemManager.Telewand);
    }

    @EventHandler
    public void openGuiEvent(GuiEvent e) {
        openNewGui(e.getPlayer());
    }

    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory().equals(gui)) {
            e.setCancelled(true);
        }
    }
}

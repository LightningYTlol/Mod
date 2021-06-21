package me.lightning.terminator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Gui implements Listener {

    public void openNewGui(Player p) {
        Inventory gui = Bukkit.createInventory(null, InventoryType.ENDER_CHEST);

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
    public void guiClickEvent(InventoryClickEvent e, Inventory gui) {
        if (!e.getInventory().equals(gui)) {
            return;
        }

        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();

        if (e.getSlot() == 2) {
            p.closeInventory();
            p.sendMessage(ChatColor.BLUE + "Button Clicked");
        }

    }

    @EventHandler
    public void openGuiEvent(GuiEvent e) {
        openNewGui(e.getPlayer());
    }
}

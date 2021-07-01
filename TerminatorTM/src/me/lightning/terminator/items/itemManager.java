package me.lightning.terminator.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class itemManager {

    public static ItemStack Terminator;

    public static void init() {
        createTerminator();
        createTelewand();
    }

    private static void createTerminator() {
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Terminator");
        List<String> lore = new ArrayList<>();
        lore.add("Shoots 3 arrows at once");
        meta.setLore(lore);
        item.setItemMeta(meta);
        Terminator = item;
    }

    public static ItemStack Telewand;

    private static void createTelewand() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("TeleWand");
        List<String> lore = new ArrayList<>();
        lore.add("Teleports you");
        meta.setLore(lore);
        item.setItemMeta(meta);
        Telewand = item;
    }
}

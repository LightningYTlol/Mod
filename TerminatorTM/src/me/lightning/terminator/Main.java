package me.lightning.terminator;

import me.lightning.terminator.events.itemevents;
import me.lightning.terminator.events.televents;
import me.lightning.terminator.items.ItemCommands;
import me.lightning.terminator.items.itemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.plugin.java.JavaPlugin;
import me.lightning.terminator.Gui;

public class Main extends JavaPlugin{

        @Override
        public void onEnable() {
                getLogger().info(ChatColor.GOLD + "[TerminatorTM] Terminator plugin initiated");
                Bukkit.getServer().getPluginManager().registerEvents(new Gui(), this);
                getServer().getPluginCommand("opengui").setExecutor(new GuiCommand());
                itemManager.init();
                getCommand("term").setExecutor(new ItemCommands());
                getServer().getPluginManager().registerEvents(new itemevents(), this);
                getServer().getPluginManager().registerEvents(new televents(), this);
        }

        @Override
        public void onDisable(){
                getLogger().info(ChatColor.BLUE + "[TerminatorTM] Terminator plugin shutting down");
        }

        private void getLogger(String s) {
        }

}

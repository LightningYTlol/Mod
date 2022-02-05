package me.lightning.terminator;

import me.lightning.terminator.GuiCommand;
import me.lightning.terminator.events.itemevents;
import me.lightning.terminator.events.televents;
import me.lightning.terminator.items.ItemCommands;
import me.lightning.terminator.items.itemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import me.lightning.terminator.Gui;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Main extends JavaPlugin{

        @Override
        public void onEnable() {
                getLogger().info(ChatColor.GOLD + "[Voltage] Plugin has been initiated");
                Bukkit.getServer().getPluginManager().registerEvents(new Gui(), this);
                Objects.requireNonNull(getServer().getPluginCommand("opengui")).setExecutor(new GuiCommand());
                itemManager.init();
                Objects.requireNonNull(getCommand("term")).setExecutor(new ItemCommands());
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

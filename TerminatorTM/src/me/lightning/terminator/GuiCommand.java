package me.lightning.terminator;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GuiCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(sender instanceof Player) {
            Bukkit.getServer().getPluginManager().callEvent(new GuiEvent((Player) sender));
            return true;
        } else {
            Bukkit.getLogger().info("Breh do this ingame");
        }

        return false;
    }
}

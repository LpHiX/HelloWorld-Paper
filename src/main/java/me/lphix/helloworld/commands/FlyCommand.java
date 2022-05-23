package me.lphix.helloworld.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player p) {
            if (p.getAllowFlight()) {
                p.setAllowFlight(false);
                p.sendMessage(ChatColor.GREEN + "you cannot fly");
            } else {
                p.setAllowFlight(true);
                p.sendMessage(ChatColor.GREEN + "you can fly");
            }
        }
        return true;
    }
}

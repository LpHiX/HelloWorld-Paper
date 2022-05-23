package me.lphix.helloworld.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.isInvulnerable()){
                p.setInvulnerable(false);
                p.sendMessage(ChatColor.GREEN + "God mode disabled");
            } else {
                p.setInvulnerable(true);
                p.sendMessage(ChatColor.GREEN + "God mode enabled");
            }
        }
        return true;
    }
}

package me.lphix.helloworld.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SurvivalCommand implements CommandExecutor{
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage(ChatColor.GREEN + "You are now in survival");
            p.setGameMode(GameMode.SURVIVAL);
        } else if (sender instanceof ConsoleCommandSender) {
            System.out.println("Only can be run by players");
        }

        return true;
    }
}

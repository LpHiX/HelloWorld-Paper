package me.lphix.helloworld.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player p){
            try{
                if(p.isFlying()){
                    p.setFlySpeed(Float.parseFloat(args[0]));
                    p.sendMessage("Flying speed = " + args[0] );
                } else {
                    p.setWalkSpeed(Float.parseFloat(args[0]));
                    p.sendMessage("Walking Speed = " + args[0] );
                }
            }catch (Exception e){
                p.sendMessage("Must be between -1 and 1");
            }
        }
        return true;
    }
}

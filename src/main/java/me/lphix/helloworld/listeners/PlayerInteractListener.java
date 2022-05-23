package me.lphix.helloworld.listeners;

import me.lphix.helloworld.inventories.MenuInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        ItemStack item = e.getItem();
        if(item != null){
            switch (item.getType()){
                case BOOK:
                    MenuInventory gui = new MenuInventory();
                    p.openInventory(gui.getInventory());
                    break;
                case STONE:
                    item.add();
                    break;
                default:
                    break;
            }
        }
    }
}

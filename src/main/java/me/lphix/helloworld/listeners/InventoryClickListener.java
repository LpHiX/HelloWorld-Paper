package me.lphix.helloworld.listeners;

import me.lphix.helloworld.HelloWorld;
import me.lphix.helloworld.inventories.MenuInventory;
import me.lphix.helloworld.inventories.SpecialsInventory;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        try{
            if (e.getClickedInventory().getHolder() instanceof MenuInventory){
                onMenuClick(e);
            } else if (e.getClickedInventory().getHolder() instanceof SpecialsInventory) {
                onAbilityMenuClick(e);
            }
        }catch (Exception ex){
            return;
        }
    }
    private void onMenuClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        switch(e.getCurrentItem().getType()){
            case COMPASS:
                p.teleport(new Location(p.getWorld(), 0.5, 64, 0.5, 0,0));
                e.getClickedInventory().close();
                e.setCancelled(true);
                break;
            case CHEST:
                SpecialsInventory inv = new SpecialsInventory();
                p.openInventory(inv.getInventory());
                e.setCancelled(true);
                break;
            default:
                e.setCancelled(true);
                break;
        }
    }
    private void onAbilityMenuClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        switch(e.getSlot()){
            case 10:{
                ItemStack tpBow = new ItemStack(Material.BOW);
                tpBow.addUnsafeEnchantment(HelloWorld.teleportEnchantment, 1);
                ItemMeta tpMeta = tpBow.getItemMeta();
                ArrayList<String> lore = new ArrayList<>();
                lore.add(ChatColor.GRAY + "Teleport 1");
                tpMeta.setLore(lore);
                tpMeta.setDisplayName(ChatColor.RESET + "Teleport Bow");
                tpBow.setItemMeta(tpMeta);
                p.getInventory().addItem(tpBow);
                e.setCancelled(true);
                break;
            }
            case 11:{
                ItemStack massiveBow = new ItemStack(Material.BOW);
                massiveBow.addUnsafeEnchantment(HelloWorld.massiveEnchantment, 1);
                ItemMeta massiveMeta = massiveBow.getItemMeta();
                ArrayList<String> lore = new ArrayList<>();
                lore.add(ChatColor.GRAY + "Massive 1");
                massiveMeta.setLore(lore);
                massiveMeta.setDisplayName(ChatColor.RESET + "Massive Bow");
                massiveBow.setItemMeta(massiveMeta);
                p.getInventory().addItem(massiveBow);
                e.setCancelled(true);
                break;
            }
            default:
                break;
        }
    }
}

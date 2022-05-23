package me.lphix.helloworld.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class MenuInventory implements InventoryHolder {
    Inventory inv;

    public MenuInventory(){
        inv = Bukkit.createInventory(this, 27);
        init();
    }

    private void init(){
        for (int i = 0; i <= 26; i++){
            inv.setItem(i,new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1));
        }
        inv.setItem(11, new ItemStack(Material.CHEST, 1));
        inv.setItem(13, new ItemStack(Material.COMPASS, 1));
        inv.setItem(15, new ItemStack(Material.COMMAND_BLOCK, 1));
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}

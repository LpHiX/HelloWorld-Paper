package me.lphix.helloworld.inventories;

import me.lphix.helloworld.HelloWorld;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SpecialsInventory implements InventoryHolder {
    Inventory inv;
    public SpecialsInventory(){
        inv = Bukkit.createInventory(this, 54);
        init();
    }

    private void init() {
        for (int i = 0; i <= 53 ; i++) {
            inv.setItem(i, new ItemStack(Material.LIME_STAINED_GLASS_PANE));
        }
        ItemStack tpBow = new ItemStack(Material.BOW);
        ItemMeta tpMeta = tpBow.getItemMeta();
        tpMeta.setDisplayName("Teleport Bow");
        tpBow.setItemMeta(tpMeta);
        inv.setItem(10, tpBow);

        ItemStack massiveBow = new ItemStack(Material.BOW);
        ItemMeta massiveMeta = tpBow.getItemMeta();
        massiveMeta.setDisplayName("Massive Bow");
        massiveBow.setItemMeta(massiveMeta);
        inv.setItem(11,massiveBow);

    }

    @Override
    public @NotNull Inventory getInventory() {
        return inv;
    }
}

package me.lphix.helloworld;

import me.lphix.helloworld.commands.*;
import me.lphix.helloworld.customenchants.MassiveEnchantment;
import me.lphix.helloworld.customenchants.TeleportEnchantment;
import me.lphix.helloworld.listeners.InventoryClickListener;
import me.lphix.helloworld.listeners.PlayerInteractListener;
import me.lphix.helloworld.listeners.PlayerJoinListener;
import me.lphix.helloworld.listeners.XPBottleBreakListener;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.HashMap;

public final class HelloWorld extends JavaPlugin{

    private static HelloWorld plugin;
    public static TeleportEnchantment teleportEnchantment;
    public static MassiveEnchantment massiveEnchantment;

    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        System.out.println("starting hello world!");

        teleportEnchantment = new TeleportEnchantment("teleport");
        registerEnchantment(teleportEnchantment);

        massiveEnchantment = new MassiveEnchantment("massive");
        registerEnchantment(massiveEnchantment);

        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(teleportEnchantment, this);
        getServer().getPluginManager().registerEvents(massiveEnchantment, this);

        getCommand("god").setExecutor(new GodCommand());
        getCommand("gmc").setExecutor(new CreativeCommand());
        getCommand("gms").setExecutor(new SurvivalCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("speed").setExecutor(new SpeedCommand());
    }

    public void onDisable() {
        try {
            Field keyField = Enchantment.class.getDeclaredField("byKey");

            keyField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<NamespacedKey, Enchantment> byKey = (HashMap<NamespacedKey, Enchantment>) keyField.get(null);

            if(byKey.containsKey(teleportEnchantment.getKey())) {
                byKey.remove(teleportEnchantment.getKey());
            }
            if(byKey.containsKey(massiveEnchantment.getKey())) {
                byKey.remove(massiveEnchantment.getKey());
            }
        } catch (Exception ignored) { }
    }
    public static HelloWorld getPlugin(){
        return plugin;
    }

    public static void registerEnchantment(Enchantment enchantment){
        boolean registered = true;
        try{
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        } catch (Exception e){
            registered = false;
            e.printStackTrace();
        }
        if(registered){

        }
    }



}

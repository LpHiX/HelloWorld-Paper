package me.lphix.helloworld.customenchants;

import io.papermc.paper.enchantments.EnchantmentRarity;
import me.lphix.helloworld.HelloWorld;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class MassiveEnchantment extends Enchantment implements Listener {

    public MassiveEnchantment(String namespace) {
        super(new NamespacedKey(HelloWorld.getPlugin(), namespace));
    }

    @EventHandler
    public void onBowShoot(EntityShootBowEvent e){
        if(!(e.getEntity() instanceof Player || e.getProjectile() instanceof Arrow)){
            return;
        }
        Player p = (Player) e.getEntity();
        if(e.getBow().getEnchantments().containsKey(Enchantment.getByKey(HelloWorld.massiveEnchantment.getKey()))){
            BukkitScheduler scheduler = Bukkit.getScheduler();
            scheduler.runTaskLater(HelloWorld.getPlugin(), () -> {
                for (int i = 0; i < 20; i++) {
                    p.getWorld().spawnArrow(e.getProjectile().getLocation(), e.getProjectile().getVelocity(), (float) e.getProjectile().getVelocity().length(), 30);
                }
            }, 3L);
        }
    }

    @Override
    public @NotNull String getName() {
        return "Massive";
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public @NotNull EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.BOW;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(@NotNull Enchantment other) {
        return false;
    }

    @Override
    public boolean canEnchantItem(@NotNull ItemStack item) {
        return true;
    }

    @Override
    public @NotNull Component displayName(int level) {
        return null;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    @Override
    public boolean isDiscoverable() {
        return false;
    }

    @Override
    public @NotNull EnchantmentRarity getRarity() {
        return null;
    }

    @Override
    public float getDamageIncrease(int level, @NotNull EntityCategory entityCategory) {
        return 0;
    }

    @Override
    public @NotNull Set<EquipmentSlot> getActiveSlots() {
        return null;
    }

    @Override
    public @NotNull String translationKey() {
        return null;
    }
}

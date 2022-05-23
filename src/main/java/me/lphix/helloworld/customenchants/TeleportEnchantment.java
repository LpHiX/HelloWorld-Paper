package me.lphix.helloworld.customenchants;

import io.papermc.paper.enchantments.EnchantmentRarity;
import me.lphix.helloworld.HelloWorld;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TeleportEnchantment extends Enchantment implements Listener {

    List<Arrow> teleportArrows = new ArrayList<>();

    @EventHandler
    public void onBowShoot(EntityShootBowEvent e){
        if(!(e.getEntity() instanceof Player || e.getProjectile() instanceof Arrow)){
            return;
        }
        Player p = (Player) e.getEntity();
        if(e.getBow().getEnchantments().containsKey(Enchantment.getByKey(HelloWorld.teleportEnchantment.getKey()))){
            teleportArrows.add((Arrow) e.getProjectile());
        }
    }
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e){
        if(e.getEntity() instanceof Arrow a){
            if(!teleportArrows.contains(a)){
                return;
            }
            Player p = (Player) a.getShooter();
            p.teleport(a.getLocation().add(0,1,0).setDirection(p.getLocation().getDirection()));
            teleportArrows.remove(a);
        }
    }

    public TeleportEnchantment(String namespace){
        super(new NamespacedKey(HelloWorld.getPlugin(), namespace));
    }

    @Override
    public @NotNull String getName() {
        return "Teleport";
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

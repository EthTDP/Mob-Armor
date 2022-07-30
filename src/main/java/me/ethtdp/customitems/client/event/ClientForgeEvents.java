package me.ethtdp.customitems.client.event;

import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.client.KeyInit;
import me.ethtdp.customitems.common.item.ModArmorMaterials;
import me.ethtdp.customitems.common.item.custom.CreeperArmorItem;
import me.ethtdp.customitems.common.item.custom.SkeletonArmorItem;
import me.ethtdp.customitems.common.item.custom.WardenArmorItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = CustomItems.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ClientForgeEvents {

    @SubscribeEvent
    public static void onFoodEaten(LivingEntityUseItemEvent.Finish event) {
        LivingEntity player = event.getEntity();
        if(player instanceof Player) {
            if (event.getItem().getItem() == Items.ROTTEN_FLESH) {
                if(hasCorrectArmorOn(ModArmorMaterials.ZOMBIE, (Player) player)) {
                    if (player.hasEffect(MobEffects.HUNGER))
                        player.removeEffect(Objects.requireNonNull(MobEffects.HUNGER));
                }
            }
        }
    }

    private static boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private static boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        if (hasFullSuitOfArmorOn(player)) {
            ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
            ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
            ArmorItem breastplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
            ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

            return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                    leggings.getMaterial() == material && boots.getMaterial() == material;
        }
        return false;
    }

    private ClientForgeEvents() {

    }
}

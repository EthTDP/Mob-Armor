package me.ethtdp.customitems.client.event;

import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.client.KeyInit;
import me.ethtdp.customitems.common.item.ModArmorMaterials;
import me.ethtdp.customitems.common.item.custom.ZombieArmorItem;
import me.ethtdp.customitems.core.network.ModMessages;
import me.ethtdp.customitems.core.network.packet.*;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CustomItems.MODID, value = Dist.CLIENT)
public class ClientEvent {

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        final var player = Minecraft.getInstance().player;

        if(KeyInit.armorKey.consumeClick()) {
            if(hasCorrectArmorOn(ModArmorMaterials.CREEPER, player)) {
                ModMessages.sendToServer(new CreeperExplosionC2SPacket());
            } else if(hasCorrectArmorOn(ModArmorMaterials.WARDEN, player)) {
                ModMessages.sendToServer(new WardenShootingC2SPacket());
            } else if(hasCorrectArmorOn(ModArmorMaterials.SKELETON, player)) {
                ModMessages.sendToServer(new SkeletonBowGiveC2SPacket());
            } else if(hasCorrectArmorOn(ModArmorMaterials.ZOMBIE, player)) {
                ModMessages.sendToServer(new ZombieGiveFoodC2SPacket());
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
}

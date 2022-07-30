package me.ethtdp.customitems.core.network.packet;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SkeletonBowGiveC2SPacket {

    public SkeletonBowGiveC2SPacket() {

    }

    public SkeletonBowGiveC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            //HERE WE ARE ON THE SERVER
            ServerPlayer player = context.getSender();

            ItemStack item = new ItemStack(Items.BOW);
            item.enchant(Enchantments.INFINITY_ARROWS, 1);
            item.enchant(Enchantments.POWER_ARROWS, 5);

            assert player != null;
            if(player.getInventory().contains(item)) {
                player.getInventory().removeItem(item);
            } else {
                player.getInventory().add(item);
            }
            });
        return true;
    }
}

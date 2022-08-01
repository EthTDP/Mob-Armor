package me.ethtdp.customitems.core.network.packet;

import me.ethtdp.customitems.client.Cooldowns;
import me.ethtdp.customitems.client.config.MobArmorCommonConfigs;
import me.ethtdp.customitems.core.init.ItemInit;
import me.ethtdp.customitems.core.network.ModMessages;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ZombieGiveFoodC2SPacket {

    public ZombieGiveFoodC2SPacket() {

    }

    public ZombieGiveFoodC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            //HERE WE ARE ON THE SERVER
            ServerPlayer player = context.getSender();

            player.getInventory().add(ItemInit.NO_HUNGER_ROTTEN_FLESH.get().getDefaultInstance());

            Cooldowns.setZombieCooldown(100);
            Cooldowns.startZombieCooldown();
            ModMessages.sendToPlayer(new ZombieCooldownS2CPacket(MobArmorCommonConfigs.ZOMBIE_COOLDOWN.get()), player);
        });
        return true;
    }
}

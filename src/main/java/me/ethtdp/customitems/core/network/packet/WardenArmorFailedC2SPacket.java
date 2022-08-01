package me.ethtdp.customitems.core.network.packet;

import me.ethtdp.customitems.client.Cooldowns;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class WardenArmorFailedC2SPacket {

    public WardenArmorFailedC2SPacket() {

    }

    public WardenArmorFailedC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            //HERE WE ARE ON THE SERVER
            ServerPlayer player = context.getSender();

            player.sendSystemMessage(Component.literal("Cooldown: " + Cooldowns.getWardenCooldown()/20));

            });
        return true;
    }
}

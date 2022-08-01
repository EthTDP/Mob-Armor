package me.ethtdp.customitems.core.network.packet;

import me.ethtdp.customitems.client.Cooldowns;
import me.ethtdp.customitems.client.config.MobArmorCommonConfigs;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class CreeperCooldownS2CPacket {
    private final int creeperCooldown;

    public CreeperCooldownS2CPacket(int creeperCooldown) {
        this.creeperCooldown = creeperCooldown;
    }

    public CreeperCooldownS2CPacket(FriendlyByteBuf buf) {
        this.creeperCooldown = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(creeperCooldown);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();

        context.enqueueWork(() -> {
            //HERE WE ARE ON THE CLIENT!
            Cooldowns.setCreeperCooldown(MobArmorCommonConfigs.CREEPER_COOLDOWN.get());
            Cooldowns.startCreeperCooldown();
        });
        return true;
    }
}

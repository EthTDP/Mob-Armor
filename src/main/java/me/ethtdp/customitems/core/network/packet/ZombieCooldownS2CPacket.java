package me.ethtdp.customitems.core.network.packet;

import me.ethtdp.customitems.client.Cooldowns;
import me.ethtdp.customitems.client.config.MobArmorCommonConfigs;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ZombieCooldownS2CPacket {
    private final int creeperCooldown;

    public ZombieCooldownS2CPacket(int creeperCooldown) {
        this.creeperCooldown = creeperCooldown;
    }

    public ZombieCooldownS2CPacket(FriendlyByteBuf buf) {
        this.creeperCooldown = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(creeperCooldown);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();

        context.enqueueWork(() -> {
            //HERE WE ARE ON THE CLIENT!
        Cooldowns.setZombieCooldown(MobArmorCommonConfigs.ZOMBIE_COOLDOWN.get());
            Cooldowns.startZombieCooldown();
        });
        return true;
    }
}

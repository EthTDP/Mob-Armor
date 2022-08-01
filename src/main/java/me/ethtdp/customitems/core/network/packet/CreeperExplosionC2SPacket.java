package me.ethtdp.customitems.core.network.packet;

import me.ethtdp.customitems.client.Cooldowns;
import me.ethtdp.customitems.common.item.custom.CreeperArmorItem;
import me.ethtdp.customitems.core.network.ModMessages;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class CreeperExplosionC2SPacket {

    private int creeperCooldown;

    public CreeperExplosionC2SPacket(int creeperCooldown) {
        this.creeperCooldown = creeperCooldown;
    }

    public CreeperExplosionC2SPacket(FriendlyByteBuf buf) {
        this.creeperCooldown = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(creeperCooldown);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            //HERE WE ARE ON THE SERVER
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            HitResult block = player.pick(20.0D, 0.0F, false);
            HitResult fluid = player.pick(20.0D, 0.0F, true);

            BlockPos blockpos = ((BlockHitResult) block).getBlockPos();
            BlockPos fluidpos = ((BlockHitResult) fluid).getBlockPos();
                if (block.getType() == HitResult.Type.BLOCK) {
                    level.explode(player, blockpos.getX(), blockpos.getY(), blockpos.getZ(), 4.0f, Explosion.BlockInteraction.NONE);
                }

                if (fluid.getType() == HitResult.Type.BLOCK) {
                    level.explode(player, fluidpos.getX(), fluidpos.getY(), fluidpos.getZ(), 4.0f, Explosion.BlockInteraction.NONE);
                }

                Cooldowns.setCreeperCooldown(200);
                Cooldowns.startCreeperCooldown();

                ModMessages.sendToPlayer(new CreeperCooldownS2CPacket(creeperCooldown), player);
        });
        return true;
    }
}

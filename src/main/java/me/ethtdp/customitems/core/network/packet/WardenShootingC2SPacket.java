package me.ethtdp.customitems.core.network.packet;

import me.ethtdp.customitems.common.item.custom.WardenArmorItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;

import java.util.List;
import java.util.function.Supplier;

public class WardenShootingC2SPacket {

    public WardenShootingC2SPacket() {

    }

    public WardenShootingC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            //HERE WE ARE ON THE SERVER
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            List<LivingEntity> entities = level.getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT, player, player.getBoundingBox().inflate(5.0D, 5.0D, 5.0D));

            double lowestDistanceSoFar = Double.MAX_VALUE;
            Entity closestEntity = null;

            for (LivingEntity entity : entities) {
                double distance = entity.getPosition(0).distanceTo(player.getPosition(0));
                if (distance < lowestDistanceSoFar) {
                    lowestDistanceSoFar = distance;
                    closestEntity = entity;
                }
            }

            Vec3 vec3 = player.position().add(0.0D, 1.65D, 0.0D);

            if (closestEntity != null) {

                Vec3 vec31 = closestEntity.getEyePosition().subtract(vec3);
                Vec3 vec32 = vec31.normalize();
                for (int i = 1; i < Mth.floor(vec31.length()) + 7; ++i) {
                    Vec3 vec33 = vec3.add(vec32.scale((double) i));
                    level.sendParticles(ParticleTypes.SONIC_BOOM, vec33.x, vec33.y, vec33.z,  1, 0.0D, 0.0D, 0.0D, 0.0D  );
                    level.playSound(player, player.blockPosition(), SoundEvents.WARDEN_SONIC_BOOM, SoundSource.PLAYERS, 1.0f, 1.0f);
                }

                closestEntity.hurt(DamageSource.sonicBoom(closestEntity), 20.0F);
            }
        });
        return true;
    }
}

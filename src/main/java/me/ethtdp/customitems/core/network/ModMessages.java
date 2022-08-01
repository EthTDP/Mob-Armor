package me.ethtdp.customitems.core.network;

import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.core.network.packet.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(CustomItems.MODID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(WardenShootingC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(WardenShootingC2SPacket::new)
                .encoder(WardenShootingC2SPacket::toBytes)
                .consumerMainThread(WardenShootingC2SPacket::handle)
                .add();

        net.messageBuilder(CreeperExplosionC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(CreeperExplosionC2SPacket::new)
                .encoder(CreeperExplosionC2SPacket::toBytes)
                .consumerMainThread(CreeperExplosionC2SPacket::handle)
                .add();

        net.messageBuilder(SkeletonBowGiveC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
            .decoder(SkeletonBowGiveC2SPacket::new)
            .encoder(SkeletonBowGiveC2SPacket::toBytes)
            .consumerMainThread(SkeletonBowGiveC2SPacket::handle)
            .add();

        net.messageBuilder(ZombieGiveFoodC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(ZombieGiveFoodC2SPacket::new)
                .encoder(ZombieGiveFoodC2SPacket::toBytes)
                .consumerMainThread(ZombieGiveFoodC2SPacket::handle)
                .add();

        net.messageBuilder(CreeperArmorFailedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(CreeperArmorFailedC2SPacket::new)
                .encoder(CreeperArmorFailedC2SPacket::toBytes)
                .consumerMainThread(CreeperArmorFailedC2SPacket::handle)
                .add();

        net.messageBuilder(WardenArmorFailedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(WardenArmorFailedC2SPacket::new)
                .encoder(WardenArmorFailedC2SPacket::toBytes)
                .consumerMainThread(WardenArmorFailedC2SPacket::handle)
                .add();

        net.messageBuilder(ZombieArmorFailedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(ZombieArmorFailedC2SPacket::new)
                .encoder(ZombieArmorFailedC2SPacket::toBytes)
                .consumerMainThread(ZombieArmorFailedC2SPacket::handle)
                .add();

        net.messageBuilder(CreeperCooldownS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(CreeperCooldownS2CPacket::new)
                .encoder(CreeperCooldownS2CPacket::toBytes)
                .consumerMainThread(CreeperCooldownS2CPacket::handle)
                .add();

        net.messageBuilder(WardenCooldownS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(WardenCooldownS2CPacket::new)
                .encoder(WardenCooldownS2CPacket::toBytes)
                .consumerMainThread(WardenCooldownS2CPacket::handle)
                .add();

        net.messageBuilder(ZombieCooldownS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(ZombieCooldownS2CPacket::new)
                .encoder(ZombieCooldownS2CPacket::toBytes)
                .consumerMainThread(ZombieCooldownS2CPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}

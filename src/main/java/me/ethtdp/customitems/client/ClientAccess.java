package me.ethtdp.customitems.client;

import me.ethtdp.customitems.common.item.custom.WardenArmorItem;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class ClientAccess {
    public static boolean updateExplosion(BlockPos pos) {
        final Player player = Minecraft.getInstance().player;
        final Level world = player.level;

        world.explode(player, pos.getX(), pos.getY(), pos.getZ(), 4.0f, Explosion.BlockInteraction.NONE);

        return true;
    }

    public static boolean updateWarden(BlockPos pos) {
        WardenArmorItem.canShoot = false;
        return true;
    }

}

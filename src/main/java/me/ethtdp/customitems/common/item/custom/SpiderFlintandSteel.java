package me.ethtdp.customitems.common.item.custom;

import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.common.block.custom.CreeperPortalBlock;
import me.ethtdp.customitems.common.block.custom.SpiderPortalBlock;
import me.ethtdp.customitems.core.init.BlockInit;
import me.ethtdp.customitems.core.world.dimension.ModDimensions;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class SpiderFlintandSteel extends Item{
    public SpiderFlintandSteel() {
        super(new Item.Properties()
                .tab(CustomItems.ITEMS_TAB)
                .stacksTo(1)
                .durability(100)
                .rarity(Rarity.RARE)
        );
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(context.getPlayer() != null) {
            Player player = context.getPlayer();
            if(context.getPlayer().level.dimension() == ModDimensions.SPIDER_KEY
                    || context.getPlayer().level.dimension() == Level.OVERWORLD) {
                for(Direction direction : Direction.Plane.VERTICAL) {
                    BlockPos framePos = context.getClickedPos().relative(direction);
                    BlockPos pos = context.getClickedPos();

                    if(((SpiderPortalBlock) BlockInit.SPIDER_PORTAL.get()).trySpawnPortal(context.getLevel(), framePos)) {
                        context.getLevel().playSound(context.getPlayer(), pos,
                                SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                        ItemStack item = context.getItemInHand();
                        Level level = context.getLevel();
                        level.gameEvent(player, GameEvent.BLOCK_PLACE, pos);

                        if (player instanceof ServerPlayer) {
                            CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, pos, item);
                            item.hurtAndBreak(1, player, (p_41300_) -> {
                                p_41300_.broadcastBreakEvent(context.getHand());
                            });
                        }
                        level.gameEvent(player, GameEvent.BLOCK_PLACE, pos);

                        return InteractionResult.sidedSuccess(level.isClientSide());
                    }
                    else return InteractionResult.FAIL;
                }
            }
        }
        return InteractionResult.FAIL;
    }
}

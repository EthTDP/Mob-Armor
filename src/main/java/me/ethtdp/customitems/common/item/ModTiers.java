package me.ethtdp.customitems.common.item;

import me.ethtdp.customitems.core.init.ItemInit;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier CREEPER = new ForgeTier(2, 1400, 1.5f, 2f, 22, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ItemInit.CREEPER_INGOT.get()));

    public static final ForgeTier SPIDER = new ForgeTier(2, 1400, 1.5f, 2f, 22, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ItemInit.SPIDER_INGOT.get()));

    public static final ForgeTier SKELETON = new ForgeTier(2, 1400, 1.5f, 2f, 22, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ItemInit.SKELETON_INGOT.get()));

    public static final ForgeTier ZOMBIE = new ForgeTier(2, 1400, 1.5f, 2f, 22, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ItemInit.ZOMBIE_INGOT.get()));

    public static final ForgeTier WARDEN = new ForgeTier(3, 1400, 0f, 4f, 22, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.EMPTY);
}


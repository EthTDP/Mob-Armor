package me.ethtdp.customitems.common.util;

import me.ethtdp.customitems.CustomItems;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class UGTags {

    public static class Blocks {
        public static final TagKey<Block> PORTAL_FRAME_BLOCKS = tag("creeper_frame_blocks");

        public static final TagKey<Block> SPIDER_FRAME_BLOCKS = tag("spider_frame_blocks");

        public static final TagKey<Block> SKELETON_FRAME_BLOCKS = tag("skeleton_frame_blocks");

        public static final TagKey<Block> ZOMBIE_FRAME_BLOCKS = tag("zombie_frame_blocks");

        public static final TagKey<Block> CREEPER_ORE_REPLACEABLE = create("creeper_ore_replaceable");

        public static final TagKey<Block> SPIDER_ORE_REPLACEABLE = create("spider_ore_replaceable");

        public static final TagKey<Block> SKELETON_ORE_REPLACEABLE = create("skeleton_ore_replaceable");

        public static final TagKey<Block> ZOMBIE_ORE_REPLACEABLE = create("zombie_ore_replaceable");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(CustomItems.MODID, name));
        }

        private static TagKey<Block> create(String name) {
            return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(CustomItems.MODID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}

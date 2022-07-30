package me.ethtdp.customitems.core.world.feature;

import me.ethtdp.customitems.common.util.UGTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class ModOreFeatures {

    public static final RuleTest CREEPER_ORE_REPLACEABLE = new TagMatchTest(UGTags.Blocks.CREEPER_ORE_REPLACEABLE);

    public static final RuleTest SPIDER_ORE_REPLACEABLE = new TagMatchTest(UGTags.Blocks.SPIDER_ORE_REPLACEABLE);

    public static final RuleTest SKELETON_ORE_REPLACEABLE = new TagMatchTest(UGTags.Blocks.SKELETON_ORE_REPLACEABLE);

    public static final RuleTest ZOMBIE_ORE_REPLACEABLE = new TagMatchTest(UGTags.Blocks.ZOMBIE_ORE_REPLACEABLE);
}

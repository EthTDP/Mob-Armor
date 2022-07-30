package me.ethtdp.customitems.core.world.dimension;

import me.ethtdp.customitems.CustomItems;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceKey<Level> CREEPER_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(CustomItems.MODID, "creeperdim"));
    public static final ResourceKey<DimensionType> CREEPER_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,
                    new ResourceLocation(CustomItems.MODID, "creeper_type"));

    public static final ResourceKey<Level> SPIDER_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(CustomItems.MODID, "spiderdim"));
    public static final ResourceKey<DimensionType> SPIDER_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,
                    new ResourceLocation(CustomItems.MODID, "spider_type"));

    public static final ResourceKey<Level> SKELETON_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(CustomItems.MODID, "skeletondim"));
    public static final ResourceKey<DimensionType> SKELETON_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,
                    new ResourceLocation(CustomItems.MODID, "skeleton_type"));

    public static final ResourceKey<Level> ZOMBIE_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(CustomItems.MODID, "zombiedim"));
    public static final ResourceKey<DimensionType> ZOMBIE_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,
                    new ResourceLocation(CustomItems.MODID, "zombie_type"));


    public static void register() {
        System.out.println("Registering ModDimensions for " + CustomItems.MODID);
    }
}

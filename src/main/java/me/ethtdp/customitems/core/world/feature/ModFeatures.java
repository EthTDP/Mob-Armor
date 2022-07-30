package me.ethtdp.customitems.core.world.feature;

import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.core.init.BlockInit;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModFeatures {
    private static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, CustomItems.MODID);
    private static final DeferredRegister<PlacedFeature> PLACED_FEATURE = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, CustomItems.MODID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> CREEPER_ORE_CONFIGURED = CONFIGURED_FEATURES.register("creeper_ore",
            () -> {
                var block = BlockInit.CREEPER_ORE.get();
                var target = List.of(OreConfiguration.target(ModOreFeatures.CREEPER_ORE_REPLACEABLE, block.defaultBlockState()));
                return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(target, 7));
            });

    public static final RegistryObject<ConfiguredFeature<?, ?>> ZOMBIE_ORE_CONFIGURED = CONFIGURED_FEATURES.register("zombie_ore",
            () -> {
                var block = BlockInit.ZOMBIE_ORE.get();
                var target = List.of(OreConfiguration.target(ModOreFeatures.ZOMBIE_ORE_REPLACEABLE, block.defaultBlockState()));
                return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(target, 7));
            });

    public static final RegistryObject<ConfiguredFeature<?, ?>> SPIDER_ORE_CONFIGURED = CONFIGURED_FEATURES.register("spider_ore",
            () -> {
                var block = BlockInit.SPIDER_ORE.get();
                var target = List.of(OreConfiguration.target(ModOreFeatures.SPIDER_ORE_REPLACEABLE, block.defaultBlockState()));
                return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(target, 7));
            });

    public static final RegistryObject<ConfiguredFeature<?, ?>> SKELETON_ORE_CONFIGURED = CONFIGURED_FEATURES.register("skeleton_ore",
            () -> {
                var block = BlockInit.SKELETON_ORE.get();
                var target = List.of(OreConfiguration.target(ModOreFeatures.SKELETON_ORE_REPLACEABLE, block.defaultBlockState()));
                return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(target, 7));
            });

    public static final RegistryObject<PlacedFeature> CREEPER_ORE_PLACED = PLACED_FEATURE.register("creeper_ore_placed",
            () -> new PlacedFeature(CREEPER_ORE_CONFIGURED.getHolder().get(),
                    ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(100)))));

    public static final RegistryObject<PlacedFeature> SPIDER_ORE_PLACED = PLACED_FEATURE.register("spider_ore_placed",
            () -> new PlacedFeature(SPIDER_ORE_CONFIGURED.getHolder().get(),
                    ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(100)))));

    public static final RegistryObject<PlacedFeature> SKELETON_ORE_PLACED = PLACED_FEATURE.register("skeleton_ore_placed",
            () -> new PlacedFeature(SKELETON_ORE_CONFIGURED.getHolder().get(),
                    ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(100)))));

    public static final RegistryObject<PlacedFeature> ZOMBIE_ORE_PLACED = PLACED_FEATURE.register("zombie_ore_placed",
            () -> new PlacedFeature(ZOMBIE_ORE_CONFIGURED.getHolder().get(),
                    ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(100)))));

    public static void register(IEventBus bus) {
        CONFIGURED_FEATURES.register(bus);
        PLACED_FEATURE.register(bus);
    }
}

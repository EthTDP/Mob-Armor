package me.ethtdp.customitems.core.world.dimension.portal;

import com.google.common.collect.ImmutableSet;
import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.core.init.BlockInit;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPOIs {

    public static final DeferredRegister<PoiType> POI =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, CustomItems.MODID);

    public static final RegistryObject<PoiType> CREEPER_PORTAL =
            POI.register("creeper_portal",
                    () -> new PoiType(
                            ImmutableSet.copyOf(BlockInit.CREEPER_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));

    public static final RegistryObject<PoiType> SPIDER_PORTAL =
            POI.register("spider_portal",
                    () -> new PoiType(
                            ImmutableSet.copyOf(BlockInit.SPIDER_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));

    public static final RegistryObject<PoiType> SKELETON_PORTAL =
            POI.register("skeleton_portal",
                    () -> new PoiType(
                            ImmutableSet.copyOf(BlockInit.SKELETON_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1
                    ));

    public static final RegistryObject<PoiType> ZOMBIE_PORTAL =
            POI.register("zombie_portal",
                    () -> new PoiType(
                            ImmutableSet.copyOf(BlockInit.ZOMBIE_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1
                    ));

    public static void register(IEventBus bus) {
        POI.register(bus);
    }
}

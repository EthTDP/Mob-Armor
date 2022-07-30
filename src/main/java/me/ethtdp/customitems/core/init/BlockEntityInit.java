package me.ethtdp.customitems.core.init;

import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.common.block.entity.custom.MobCuttingStationBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CustomItems.MODID);

    public static final RegistryObject<BlockEntityType<MobCuttingStationBlockEntity>> MOB_CUTTING_STATION_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("mob_cutting_station_block_entity", () ->
                    BlockEntityType.Builder.of(MobCuttingStationBlockEntity::new,
                    BlockInit.MOB_GEM_CUTTING_STATION.get()).build(null));

    public static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }


}

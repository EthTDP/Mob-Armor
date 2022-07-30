package me.ethtdp.customitems.common.event;

import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.common.recipes.MobCuttingStationRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid = CustomItems.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void register(RegisterEvent event) {

        event.register(ForgeRegistries.Keys.RECIPE_TYPES, helper -> {
            helper.register(new ResourceLocation(CustomItems.MODID, MobCuttingStationRecipe.Type.ID),
                    MobCuttingStationRecipe.Type.INSTANCE);
        });
    }
}

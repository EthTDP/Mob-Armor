package me.ethtdp.customitems.common.recipes;

import me.ethtdp.customitems.CustomItems;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipe {

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CustomItems.MODID);

    public static final RegistryObject<RecipeSerializer<MobCuttingStationRecipe>> MOB_CUTTING_SERIALIZER =
            SERIALIZERS.register("mob_cutting", () -> MobCuttingStationRecipe.Serializer.INSTANCE);

    public static void register(IEventBus bus) {
        SERIALIZERS.register(bus);
    }
}

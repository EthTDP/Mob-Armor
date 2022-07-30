package me.ethtdp.customitems;

import me.ethtdp.customitems.client.screen.ModMenuTypes;
import me.ethtdp.customitems.common.event.GlobalLootModifierInit;
import me.ethtdp.customitems.common.recipes.ModRecipe;
import me.ethtdp.customitems.common.villager.ModVillagers;
import me.ethtdp.customitems.core.init.BlockEntityInit;
import me.ethtdp.customitems.core.init.BlockInit;
import me.ethtdp.customitems.core.init.ItemInit;
import me.ethtdp.customitems.core.world.dimension.ModDimensions;
import me.ethtdp.customitems.core.world.dimension.portal.ModPOIs;
import me.ethtdp.customitems.core.world.feature.ModFeatures;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CustomItems.MODID)
public class CustomItems {

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "mobarmor";

    public static final CreativeModeTab ITEMS_TAB = new CreativeModeTab(CustomItems.MODID) {
        @Override
        public ItemStack makeIcon() {
            return ItemInit.CREEPER_INGOT.get().getDefaultInstance();
        }
    };

    public CustomItems() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        BlockEntityInit.register(bus);

        ModVillagers.register(bus);

        ModMenuTypes.register(bus);
        ModRecipe.register(bus);

        ModFeatures.register(bus);

        ModDimensions.register();
        ModPOIs.register(bus);

        GlobalLootModifierInit.GLM.register(bus);

        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);
    }
}

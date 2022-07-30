package me.ethtdp.customitems.client.event;

import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.client.KeyInit;
import me.ethtdp.customitems.client.overlay.AbilityOverlay;
import me.ethtdp.customitems.client.screen.mobcutting.MobCuttingStationScreen;
import me.ethtdp.customitems.client.screen.ModMenuTypes;
import me.ethtdp.customitems.common.entity.client.armor.creeper.CreeperArmorRenderer;
import me.ethtdp.customitems.common.entity.client.armor.skeleton.SkeletonArmorRenderer;
import me.ethtdp.customitems.common.entity.client.armor.spider.SpiderArmorRenderer;
import me.ethtdp.customitems.common.entity.client.armor.warden.WardenArmorRenderer;
import me.ethtdp.customitems.common.entity.client.armor.zombie.ZombieArmorRenderer;
import me.ethtdp.customitems.common.item.custom.*;
import me.ethtdp.customitems.common.recipes.MobCuttingStationRecipe;
import me.ethtdp.customitems.core.init.BlockInit;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = CustomItems.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvent {
    private ClientModEvent() {

    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BlockInit.CREEPER_PORTAL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.SPIDER_PORTAL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.SKELETON_PORTAL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.ZOMBIE_PORTAL.get(), RenderType.translucent());

        MenuScreens.register(ModMenuTypes.MOB_CUTTING_STATION_MENU.get(), MobCuttingStationScreen::new);
    }

    @SubscribeEvent
    public static void registerArmorRenderer(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(ZombieArmorItem.class, new ZombieArmorRenderer());
        GeoArmorRenderer.registerArmorRenderer(CreeperArmorItem.class, new CreeperArmorRenderer());
        GeoArmorRenderer.registerArmorRenderer(SpiderArmorItem.class, new SpiderArmorRenderer());
        GeoArmorRenderer.registerArmorRenderer(WardenArmorItem.class, new WardenArmorRenderer());
        GeoArmorRenderer.registerArmorRenderer(SkeletonArmorItem.class, new SkeletonArmorRenderer());
    }

    @SubscribeEvent
    public static void registerKeybinds(RegisterKeyMappingsEvent event) {
        event.register(KeyInit.armorKey);
    }

    @SubscribeEvent
    public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
        event.registerBelowAll("creeper", AbilityOverlay.CREEPER);
    }
}

package me.ethtdp.customitems.common.event;

import com.mojang.serialization.Codec;
import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.common.event.loot.CreeperIngotFromMob;
import me.ethtdp.customitems.common.event.loot.SkeletonIngotFromMob;
import me.ethtdp.customitems.common.event.loot.SpiderIngotFromMob;
import me.ethtdp.customitems.common.event.loot.ZombieIngotFromMob;
import me.ethtdp.customitems.common.event.loot.warden.chest.WardenArmorFromChestAdditionModifier;
import me.ethtdp.customitems.common.event.loot.warden.entity.WardenArmorFromWardenAdditionModifier;
import me.ethtdp.customitems.core.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GlobalLootModifierInit {
    public static final boolean ENABLE = true;

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, CustomItems.MODID);

    private static final RegistryObject<Codec<WardenArmorFromWardenAdditionModifier>> WardenHelmetWarden = GLM.register("warden_armor_from_warden", WardenArmorFromWardenAdditionModifier.CODEC);

    private static final RegistryObject<Codec<WardenArmorFromChestAdditionModifier>> WardenArmorChest = GLM.register("warden_armor_from_chest", WardenArmorFromChestAdditionModifier.CODEC);

    private static final RegistryObject<Codec<CreeperIngotFromMob>> CreeperIngot = GLM.register("creeper_ingot_from_creeper", CreeperIngotFromMob.CODEC);

    private static final RegistryObject<Codec<SpiderIngotFromMob>> SpiderIngot = GLM.register("spider_ingot_from_spider", SpiderIngotFromMob.CODEC);

    private static final RegistryObject<Codec<SkeletonIngotFromMob>> SkeletonIngot = GLM.register("skeleton_ingot_from_skeleton", SkeletonIngotFromMob.CODEC);

    private static final RegistryObject<Codec<ZombieIngotFromMob>> ZombieIngot = GLM.register("zombie_ingot_from_zombie", ZombieIngotFromMob.CODEC);


    @Mod.EventBusSubscriber(modid = CustomItems.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class EventHandler {
        @SubscribeEvent
        public static void runData(GatherDataEvent event) {
            if (ENABLE)
                event.getGenerator().addProvider(event.includeServer(), new DataProvider(event.getGenerator(), CustomItems.MODID));
        }

        private static class DataProvider extends GlobalLootModifierProvider {
            public DataProvider(DataGenerator gen, String modid) {
                super(gen, modid);
            }

            @Override
            protected void start() {
                add("warden_armor_from_warden", new WardenArmorFromWardenAdditionModifier(
                        new LootItemCondition[]{LootTableIdCondition.builder(new ResourceLocation("entities/warden")).build()},
                        ItemInit.WARDEN_HELMET.get(), ItemInit.WARDEN_CHESTPLATE.get(), ItemInit.WARDEN_LEGGINGS.get(), ItemInit.WARDEN_BOOTS.get())
                );

                add("warden_armor_from_chest", new WardenArmorFromChestAdditionModifier(
                        new LootItemCondition[]{LootTableIdCondition.builder(new ResourceLocation("chests/ancient_city")).build()},
                        ItemInit.WARDEN_HELMET.get(), ItemInit.WARDEN_CHESTPLATE.get(), ItemInit.WARDEN_LEGGINGS.get(), ItemInit.WARDEN_BOOTS.get())
                );

                add("creeper_ingot_from_creeper", new CreeperIngotFromMob(new LootItemCondition[]{LootTableIdCondition.builder(new ResourceLocation("entities/creeper")).build()},
                        ItemInit.CREEPER_INGOT.get()));

                add("spider_ingot_from_spider", new SpiderIngotFromMob(new LootItemCondition[]{LootTableIdCondition.builder(new ResourceLocation("entities/spider")).build()},
                        ItemInit.SPIDER_INGOT.get()));

                add("skeleton_ingot_from_skeleton", new SkeletonIngotFromMob(new LootItemCondition[]{LootTableIdCondition.builder(new ResourceLocation("entities/skeleton")).build()},
                        ItemInit.SKELETON_INGOT.get()));

                add("zombie_ingot_from_zombie", new ZombieIngotFromMob(new LootItemCondition[]{LootTableIdCondition.builder(new ResourceLocation("entities/zombie")).build()},
                        ItemInit.ZOMBIE_INGOT.get()));
            }
        }
    }
}




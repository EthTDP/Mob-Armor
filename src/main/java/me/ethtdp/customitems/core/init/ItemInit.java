package me.ethtdp.customitems.core.init;

import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.common.item.ModArmorMaterials;
import me.ethtdp.customitems.common.item.ModTiers;
import me.ethtdp.customitems.common.item.custom.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CustomItems.MODID);



    //Ingots
    public static final RegistryObject<Item> CREEPER_INGOT = ITEMS.register("creeper_ingot",
            () -> new Item(new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> SPIDER_INGOT = ITEMS.register("spider_ingot",
            () -> new Item(new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> ZOMBIE_INGOT = ITEMS.register("zombie_ingot",
            () -> new Item(new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> SKELETON_INGOT = ITEMS.register("skeleton_ingot",
            () -> new Item(new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    //Raw Ingots
    public static final RegistryObject<Item> RAW_CREEPER = ITEMS.register("raw_creeper",
            () -> new Item(new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> RAW_SPIDER = ITEMS.register("raw_spider",
            () -> new Item(new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> RAW_ZOMBIE = ITEMS.register("raw_zombie",
            () -> new Item(new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> RAW_SKELETON = ITEMS.register("raw_skeleton",
            () -> new Item(new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    //Items
    public static final RegistryObject<Item> CREEPER_FLINT_AND_STEEL = ITEMS.register("creeper_and_steel", CreeperFlintAndSteel::new);

    public static final RegistryObject<Item> SPIDER_FLINT_AND_STEEL = ITEMS.register("spider_and_steel", SpiderFlintandSteel::new);

    public static final RegistryObject<Item> SKELETON_FLINT_AND_STEEL = ITEMS.register("skeleton_and_steel", SkeletonFlintAndSteel::new);

    public static final RegistryObject<Item> ZOMBIE_FLINT_AND_STEEL = ITEMS.register("zombie_and_steel", ZombieFlintAndSteel::new);

    public static final RegistryObject<Item> LIGHTER = ITEMS.register("lighter",
            () -> new Item(new Item.Properties().tab(CustomItems.ITEMS_TAB).durability(100)));

    public static final RegistryObject<Item> MOB_CUTTER = ITEMS.register("mob_cutter",
            () -> new Item(new Item.Properties().tab(CustomItems.ITEMS_TAB).durability(100)));

    //Weapons
    public static final RegistryObject<Item> CREEPER_SWORD = ITEMS.register("creeper_sword",
            () -> new SwordItem(ModTiers.CREEPER, 2, 3f,
                    new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> SPIDER_SWORD = ITEMS.register("spider_sword",
            () -> new SwordItem(ModTiers.SPIDER, 2, 3f,
                    new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> SKELETON_SWORD = ITEMS.register("skeleton_sword",
            () -> new SwordItem(ModTiers.SKELETON, 2, 3f,
                    new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> ZOMBIE_SWORD = ITEMS.register("zombie_sword",
            () -> new SwordItem(ModTiers.ZOMBIE, 2, 3f,
                    new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> WARDEN_WAR_AXE = ITEMS.register("warden_war_axe",
            () -> new SwordItem(ModTiers.WARDEN, 2, 1f,
                    new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    //Armors

    //Creeper
    public static final RegistryObject<Item> CREEPER_HELMET = ITEMS.register("creeper_helmet",
            () -> new CreeperArmorItem(ModArmorMaterials.CREEPER, EquipmentSlot.HEAD, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> CREEPER_CHESTPLATE = ITEMS.register("creeper_chestplate",
            () -> new CreeperArmorItem(ModArmorMaterials.CREEPER, EquipmentSlot.CHEST, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> CREEPER_LEGGINGS = ITEMS.register("creeper_leggings",
            () -> new CreeperArmorItem(ModArmorMaterials.CREEPER, EquipmentSlot.LEGS, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> CREEPER_BOOTS = ITEMS.register("creeper_boots",
            () -> new CreeperArmorItem(ModArmorMaterials.CREEPER, EquipmentSlot.FEET, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    //Spider
    public static final RegistryObject<Item> SPIDER_HELMET = ITEMS.register("spider_helmet",
            () -> new SpiderArmorItem(ModArmorMaterials.SPIDER, EquipmentSlot.HEAD, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> SPIDER_CHESTPLATE = ITEMS.register("spider_chestplate",
            () -> new SpiderArmorItem(ModArmorMaterials.SPIDER, EquipmentSlot.CHEST, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> SPIDER_LEGGINGS = ITEMS.register("spider_leggings",
            () -> new SpiderArmorItem(ModArmorMaterials.SPIDER, EquipmentSlot.LEGS, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> SPIDER_BOOTS = ITEMS.register("spider_boots",
            () -> new SpiderArmorItem(ModArmorMaterials.SPIDER, EquipmentSlot.FEET, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    //Zombie
    public static final RegistryObject<Item> ZOMBIE_HELMET = ITEMS.register("zombie_helmet",
            () -> new ZombieArmorItem(ModArmorMaterials.ZOMBIE, EquipmentSlot.HEAD, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> ZOMBIE_CHESTPLATE = ITEMS.register("zombie_chestplate",
            () -> new ZombieArmorItem(ModArmorMaterials.ZOMBIE, EquipmentSlot.CHEST, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> ZOMBIE_LEGGINGS = ITEMS.register("zombie_leggings",
            () -> new ZombieArmorItem(ModArmorMaterials.ZOMBIE, EquipmentSlot.LEGS, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> ZOMBIE_BOOTS = ITEMS.register("zombie_boots",
            () -> new ZombieArmorItem(ModArmorMaterials.ZOMBIE, EquipmentSlot.FEET, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> NO_HUNGER_ROTTEN_FLESH = ITEMS.register("no_hunger_rotten_flesh",
            () -> new Item(new Item.Properties().tab(CustomItems.ITEMS_TAB)
                    .food(new FoodProperties.Builder().nutrition(6).saturationMod(0.2F).build())));

    //Skeleton
    public static final RegistryObject<Item> SKELETON_HELMET = ITEMS.register("skeleton_helmet",
            () -> new SkeletonArmorItem(ModArmorMaterials.SKELETON, EquipmentSlot.HEAD, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> SKELETON_CHESTPLATE = ITEMS.register("skeleton_chestplate",
            () -> new SkeletonArmorItem(ModArmorMaterials.SKELETON, EquipmentSlot.CHEST, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> SKELETON_LEGGINGS = ITEMS.register("skeleton_leggings",
            () -> new SkeletonArmorItem(ModArmorMaterials.SKELETON, EquipmentSlot.LEGS, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> SKELETON_BOOTS = ITEMS.register("skeleton_boots",
            () -> new SkeletonArmorItem(ModArmorMaterials.SKELETON, EquipmentSlot.FEET, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    //Warden
    public static final RegistryObject<Item> WARDEN_HELMET = ITEMS.register("warden_helmet",
            () -> new WardenArmorItem(ModArmorMaterials.WARDEN, EquipmentSlot.HEAD, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> WARDEN_CHESTPLATE = ITEMS.register("warden_chestplate",
            () -> new WardenArmorItem(ModArmorMaterials.WARDEN, EquipmentSlot.CHEST, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> WARDEN_LEGGINGS = ITEMS.register("warden_leggings",
            () -> new WardenArmorItem(ModArmorMaterials.WARDEN, EquipmentSlot.LEGS, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<Item> WARDEN_BOOTS = ITEMS.register("warden_boots",
            () -> new WardenArmorItem(ModArmorMaterials.WARDEN, EquipmentSlot.FEET, new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    //Block items
    public static final RegistryObject<BlockItem> CREEPER_ORE_BLOCK = ITEMS.register("creeper_ore",
            () -> new BlockItem(BlockInit.CREEPER_ORE.get(), new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<BlockItem> SPIDER_ORE_BLOCK = ITEMS.register("spider_ore",
            () -> new BlockItem(BlockInit.SPIDER_ORE.get(), new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<BlockItem> SKELETON_ORE_BLOCK = ITEMS.register("skeleton_ore",
            () -> new BlockItem(BlockInit.SKELETON_ORE.get(), new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<BlockItem> ZOMBIE_ORE_BLOCK = ITEMS.register("zombie_ore",
            () -> new BlockItem(BlockInit.ZOMBIE_ORE.get(), new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<BlockItem> CREEPER_BLOCK = ITEMS.register("creeper_block",
            () -> new BlockItem(BlockInit.CREEPER_BLOCK.get(), new Item.Properties().tab(CustomItems.ITEMS_TAB)));

    public static final RegistryObject<BlockItem> MOB_GEM_CUTTING_STATION = ITEMS.register("mob_gem_cutting_station",
            () -> new BlockItem(BlockInit.MOB_GEM_CUTTING_STATION.get(), new Item.Properties().tab(CustomItems.ITEMS_TAB)));

}

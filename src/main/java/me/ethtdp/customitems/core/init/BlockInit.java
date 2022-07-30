package me.ethtdp.customitems.core.init;

import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.common.block.custom.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CustomItems.MODID);

    public static final RegistryObject<Block> CREEPER_ORE = BLOCKS.register("creeper_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(3.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SPIDER_ORE = BLOCKS.register("spider_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(3.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SKELETON_ORE = BLOCKS.register("skeleton_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(3.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ZOMBIE_ORE = BLOCKS.register("zombie_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(3.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CREEPER_BLOCK = BLOCKS.register("creeper_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
            .strength(5.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SPIDER_BLOCK = registerBlock("spider_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
            .strength(5.0f).requiresCorrectToolForDrops()), CustomItems.ITEMS_TAB);

    public static final RegistryObject<Block> SKELETON_BLOCK = registerBlock("skeleton_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
            .strength(5.0f).requiresCorrectToolForDrops()), CustomItems.ITEMS_TAB);

    public static final RegistryObject<Block> ZOMBIE_BLOCK = registerBlock("zombie_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
            .strength(5.0f).requiresCorrectToolForDrops()), CustomItems.ITEMS_TAB);


    public static final RegistryObject<Block> CREEPER_PORTAL = registerBlockWithoutBlockItem("creeper_portal",
            CreeperPortalBlock::new);

    public static final RegistryObject<Block> SPIDER_PORTAL = registerBlockWithoutBlockItem("spider_portal",
            SpiderPortalBlock::new);

    public static final RegistryObject<Block> SKELETON_PORTAL = registerBlockWithoutBlockItem("skeleton_portal",
            SkeletonPortalBlock::new);

    public static final RegistryObject<Block> ZOMBIE_PORTAL = registerBlockWithoutBlockItem("zombie_portal",
            ZombiePortalBlock::new);

    public static final RegistryObject<Block> MOB_GEM_CUTTING_STATION = BLOCKS.register("mob_gem_cutting_station",
            () -> new MobGemCutting(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab, String tooltipKey) {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)) {
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(Component.translatable(tooltipKey));
            }
        });
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }
}

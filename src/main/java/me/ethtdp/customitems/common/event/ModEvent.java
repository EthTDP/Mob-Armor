package me.ethtdp.customitems.common.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.common.villager.ModVillagers;
import me.ethtdp.customitems.core.init.ItemInit;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = CustomItems.MODID)
public class ModEvent {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        int villagerLevel;
        if(event.getType() == ModVillagers.WARDEN_MASTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.WARDEN_WAR_AXE.get(), 1);
            ItemStack stack1 = new ItemStack(ItemInit.WARDEN_HELMET.get(), 1);
            ItemStack stack2 = new ItemStack(ItemInit.WARDEN_CHESTPLATE.get(), 1);
            ItemStack stack3 = new ItemStack(ItemInit.WARDEN_LEGGINGS.get(), 1);
            ItemStack stack4 = new ItemStack(ItemInit.WARDEN_BOOTS.get(), 1);
            ItemStack stack5 = new ItemStack(Items.SCULK, 1);
            ItemStack stack6 = new ItemStack(Items.SCULK_CATALYST, 1);
            ItemStack stack7 = new ItemStack(Items.SCULK_SENSOR, 1);
            ItemStack stack8 = new ItemStack(Items.SCULK_SHRIEKER, 1);
            ItemStack stack9 = new ItemStack(Items.SCULK_VEIN, 1);
            ItemStack stack10 = new ItemStack(ItemInit.MOB_GEM_CUTTING_STATION.get(), 1);
            ItemStack woolStack = new ItemStack(Items.BLACK_WOOL, RandomSource.create().nextInt(1, 64));
            ItemStack woolStack1 = new ItemStack(Items.BLUE_WOOL, RandomSource.create().nextInt(1, 64));
            ItemStack woolStack2 = new ItemStack(Items.WHITE_WOOL, RandomSource.create().nextInt(1, 64));
            ItemStack woolStack3 = new ItemStack(Items.BROWN_WOOL, RandomSource.create().nextInt(1, 64));
            ItemStack woolStack4 = new ItemStack(Items.CYAN_WOOL, RandomSource.create().nextInt(1, 64));
            ItemStack woolStack5 = new ItemStack(Items.GRAY_WOOL, RandomSource.create().nextInt(1, 64));
            ItemStack woolStack6 = new ItemStack(Items.GREEN_WOOL, RandomSource.create().nextInt(1, 64));
            ItemStack woolStack7 = new ItemStack(Items.LIGHT_BLUE_WOOL, RandomSource.create().nextInt(1, 64));
            ItemStack woolStack8 = new ItemStack(Items.LIGHT_GRAY_WOOL, RandomSource.create().nextInt(1, 64));
            ItemStack woolStack9 = new ItemStack(Items.LIME_WOOL, RandomSource.create().nextInt(1, 64));
            ItemStack woolStack10 = new ItemStack(Items.MAGENTA_WOOL, RandomSource.create().nextInt(1, 64));
            ItemStack woolStack11 = new ItemStack(Items.ORANGE_WOOL, RandomSource.create().nextInt(1, 64));
            ItemStack woolStack12 = new ItemStack(Items.PINK_WOOL, RandomSource.create().nextInt(1, 64));
            ItemStack woolStack13 = new ItemStack(Items.PURPLE_WOOL, RandomSource.create().nextInt(1, 64));
            ItemStack woolStack14 = new ItemStack(Items.RED_WOOL, RandomSource.create().nextInt(1, 64));
            ItemStack woolStack15 = new ItemStack(Items.YELLOW_WOOL, RandomSource.create().nextInt(1, 64));


            villagerLevel = 1;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.SCULK, rand.nextInt(5, 15)),
                    new ItemStack(Items.EMERALD, rand.nextInt(1, 5)),
                    20, 8, 0.02F
            ));

            villagerLevel = 2;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(10, 15)),
                    stack5, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(10, 15)),
                    stack6, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(10, 15)),
                    stack7, 20, 8, 0.02F
            ));

            villagerLevel = 3;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(10, 15)),
                    stack8, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(10, 15)),
                    stack9, 20, 8, 0.02F
            ));

            villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(1, 5)),
                    woolStack, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(1, 5)),
                    woolStack1, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(1, 5)),
                    woolStack2, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(1, 5)),
                    woolStack3, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(1, 5)),
                    woolStack4, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(1, 5)),
                    woolStack5, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(1, 5)),
                    woolStack6, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(1, 5)),
                    woolStack7, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(1, 5)),
                    woolStack8, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(1, 5)),
                    woolStack9, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(1, 5)),
                    woolStack10, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(1, 5)),
                    woolStack11, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(1, 5)),
                    woolStack12, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(1, 5)),
                    woolStack13, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(1, 5)),
                    woolStack14, 20, 8, 0.02F
            ));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(1, 5)),
                    woolStack15, 20, 8, 0.02F
            ));

            villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(25, 30)),
                    stack, 20, 8, 0.02F)
            );

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(25, 35)),
                    stack1, 20, 8, 0.02F)
            );

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(35, 50)),
                    stack2, 20, 8, 0.02F)
            );

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(30, 45)),
                    stack3, 20, 8, 0.02F)
            );

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, rand.nextInt(20, 30)),
                    stack4, 20, 8, 0.02F)
            );
        }
    }
}

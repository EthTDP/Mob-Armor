package me.ethtdp.customitems.common.event.loot.warden.entity;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.function.Supplier;

public class WardenArmorFromWardenAdditionModifier extends LootModifier {

        public static final Supplier<Codec<WardenArmorFromWardenAdditionModifier>> CODEC =
            Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).and(
                            inst.group(
                                    ForgeRegistries.ITEMS.getCodec().fieldOf("helmet").forGetter(m -> m.helmet),
                                    ForgeRegistries.ITEMS.getCodec().fieldOf("chestplate").forGetter(m -> m.chestplate),
                                    ForgeRegistries.ITEMS.getCodec().fieldOf("leggings").forGetter(m -> m.leggings),
                                    ForgeRegistries.ITEMS.getCodec().fieldOf("boots").forGetter(m -> m.boots))
                            )
                    .apply(inst, WardenArmorFromWardenAdditionModifier::new)
            ));

        private final Item helmet;
        private final Item chestplate;
        private final Item leggings;
        private final Item boots;

    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    public WardenArmorFromWardenAdditionModifier(LootItemCondition[] conditionsIn, Item helmet, Item chestplate, Item leggings, Item boots) {
        super(conditionsIn);
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.boots = boots;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        ArrayList<Item> armor = new ArrayList<>();

        armor.add(helmet); armor.add(chestplate);
        armor.add(leggings); armor.add(boots);

        int randomArmor = context.getRandom().nextIntBetweenInclusive(0, 3);
        if(context.getRandom().nextIntBetweenInclusive(0, 100) <= 10) {
            generatedLoot.add(armor.get(randomArmor).getDefaultInstance());
        }
        return generatedLoot;
    }

        @Override
        public Codec<? extends IGlobalLootModifier> codec() {
            return CODEC.get();
            }
}
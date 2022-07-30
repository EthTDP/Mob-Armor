package me.ethtdp.customitems.common.event.loot;

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

import java.util.function.Supplier;

public class SkeletonIngotFromMob extends LootModifier {

    public static final Supplier<Codec<SkeletonIngotFromMob>> CODEC =
            Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).and(
                                            ForgeRegistries.ITEMS.getCodec().fieldOf("ingot").forGetter(m -> m.ingot)
            ).apply(inst, SkeletonIngotFromMob::new)));

    private final Item ingot;

    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    public SkeletonIngotFromMob(LootItemCondition[] conditionsIn, Item ingot) {
        super(conditionsIn);
        this.ingot = ingot;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(context.getRandom().nextIntBetweenInclusive(0, 100) <= 30) {
            generatedLoot.add(ingot.getDefaultInstance());
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}

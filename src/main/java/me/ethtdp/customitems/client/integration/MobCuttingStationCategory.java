package me.ethtdp.customitems.client.integration;

import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.common.recipes.MobCuttingStationRecipe;
import me.ethtdp.customitems.core.init.BlockInit;
import me.ethtdp.customitems.core.init.ItemInit;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class MobCuttingStationCategory implements IRecipeCategory<MobCuttingStationRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(CustomItems.MODID, "mob_cutting");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(CustomItems.MODID, "textures/gui/mob_cutting_station_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public MobCuttingStationCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 166);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockInit.MOB_GEM_CUTTING_STATION.get()));
    }

    @Override
    public RecipeType<MobCuttingStationRecipe> getRecipeType() {
        return RecipeType.create(CustomItems.MODID, MobCuttingStationRecipe.Type.ID, MobCuttingStationRecipe.class);
    }

    @Override
    public Component getTitle() {
        return Component.literal("Mob Cutting Station");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, MobCuttingStationRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 37, 43).addIngredients(Ingredient.of(ItemInit.LIGHTER.get()));
        builder.addSlot(RecipeIngredientRole.INPUT, 56, 9).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 106, 9).addIngredients(Ingredient.of(ItemInit.MOB_CUTTER.get()));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 81, 54).addItemStack(recipe.getResultItem());
    }
}

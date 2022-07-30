package me.ethtdp.customitems.client.integration;

import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.common.block.custom.MobGemCutting;
import me.ethtdp.customitems.common.recipes.MobCuttingStationRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IPlatformFluidHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.*;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEI implements IModPlugin {
    public static final ResourceLocation ID = new ResourceLocation(CustomItems.MODID, "jei");

    public JEI() {

    }


    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new MobCuttingStationCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<MobCuttingStationRecipe> recipes = rm.getAllRecipesFor(MobCuttingStationRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(MobCuttingStationCategory.UID, MobCuttingStationRecipe.class), recipes);
    }


}

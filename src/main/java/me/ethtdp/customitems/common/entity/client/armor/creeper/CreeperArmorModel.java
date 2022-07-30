package me.ethtdp.customitems.common.entity.client.armor.creeper;

import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.common.item.custom.CreeperArmorItem;
import me.ethtdp.customitems.common.item.custom.SpiderArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CreeperArmorModel extends AnimatedGeoModel<CreeperArmorItem> {
    @Override
    public ResourceLocation getModelResource(CreeperArmorItem object) {
        return new ResourceLocation(CustomItems.MODID, "geo/zombie_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CreeperArmorItem object) {
        return new ResourceLocation(CustomItems.MODID, "textures/models/armor/creeper_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CreeperArmorItem animatable) {
        return new ResourceLocation(CustomItems.MODID, "animations/armor_animation.json");
    }
}

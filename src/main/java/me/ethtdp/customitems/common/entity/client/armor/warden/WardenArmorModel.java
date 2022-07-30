package me.ethtdp.customitems.common.entity.client.armor.warden;

import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.common.item.custom.CreeperArmorItem;
import me.ethtdp.customitems.common.item.custom.WardenArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WardenArmorModel extends AnimatedGeoModel<WardenArmorItem> {

    @Override
    public ResourceLocation getModelResource(WardenArmorItem object) {
        return new ResourceLocation(CustomItems.MODID, "geo/wardenarmor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WardenArmorItem object) {
        return new ResourceLocation(CustomItems.MODID, "textures/models/armor/warden_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WardenArmorItem animatable) {
        return new ResourceLocation(CustomItems.MODID, "animations/armor_animation.json");
    }
}

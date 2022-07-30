package me.ethtdp.customitems.common.entity.client.armor.spider;

import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.common.item.custom.SpiderArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SpiderArmorModel extends AnimatedGeoModel<SpiderArmorItem> {


    @Override
    public ResourceLocation getModelResource(SpiderArmorItem object) {
        return new ResourceLocation(CustomItems.MODID, "geo/spiderarmor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpiderArmorItem object) {
        return new ResourceLocation(CustomItems.MODID, "textures/models/armor/spider_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpiderArmorItem animatable) {
        return new ResourceLocation(CustomItems.MODID, "animations/armor_animation.json");
    }
}

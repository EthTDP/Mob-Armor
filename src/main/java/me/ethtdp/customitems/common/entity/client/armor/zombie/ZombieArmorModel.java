package me.ethtdp.customitems.common.entity.client.armor.zombie;

import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.common.item.custom.ZombieArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ZombieArmorModel extends AnimatedGeoModel<ZombieArmorItem> {

    @Override
    public ResourceLocation getModelResource(ZombieArmorItem object) {
        return new ResourceLocation(CustomItems.MODID, "geo/zombie_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ZombieArmorItem object) {
        return new ResourceLocation(CustomItems.MODID, "textures/models/armor/zombie_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ZombieArmorItem animatable) {
        return new ResourceLocation(CustomItems.MODID, "animations/armor_animation.json");
    }
}

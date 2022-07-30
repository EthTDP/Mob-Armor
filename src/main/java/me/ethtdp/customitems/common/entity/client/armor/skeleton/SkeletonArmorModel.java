package me.ethtdp.customitems.common.entity.client.armor.skeleton;

import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.common.item.custom.CreeperArmorItem;
import me.ethtdp.customitems.common.item.custom.SkeletonArmorItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Skeleton;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SkeletonArmorModel extends AnimatedGeoModel<SkeletonArmorItem> {
    @Override
    public ResourceLocation getModelResource(SkeletonArmorItem object) {
        return new ResourceLocation(CustomItems.MODID, "geo/zombie_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SkeletonArmorItem object) {
        return new ResourceLocation(CustomItems.MODID, "textures/models/armor/creeper_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SkeletonArmorItem animatable) {
        return new ResourceLocation(CustomItems.MODID, "animations/armor_animation.json");
    }
}

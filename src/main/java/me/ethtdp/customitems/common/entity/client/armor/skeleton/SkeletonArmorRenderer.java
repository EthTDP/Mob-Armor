package me.ethtdp.customitems.common.entity.client.armor.skeleton;

import me.ethtdp.customitems.common.item.custom.CreeperArmorItem;
import me.ethtdp.customitems.common.item.custom.SkeletonArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class SkeletonArmorRenderer extends GeoArmorRenderer<SkeletonArmorItem> {

    public SkeletonArmorRenderer() {
        super(new SkeletonArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";
    }
}

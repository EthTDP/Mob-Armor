package me.ethtdp.customitems.common.entity.client.armor.creeper;

import me.ethtdp.customitems.common.item.custom.CreeperArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class CreeperArmorRenderer extends GeoArmorRenderer<CreeperArmorItem> {

    public CreeperArmorRenderer() {
        super(new CreeperArmorModel());

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

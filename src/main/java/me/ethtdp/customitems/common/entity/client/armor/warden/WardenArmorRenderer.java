package me.ethtdp.customitems.common.entity.client.armor.warden;

import me.ethtdp.customitems.common.item.custom.CreeperArmorItem;
import me.ethtdp.customitems.common.item.custom.WardenArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class WardenArmorRenderer extends GeoArmorRenderer<WardenArmorItem> {

    public WardenArmorRenderer() {

        super(new WardenArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";
    }
}

package me.ethtdp.customitems.common.entity.client.armor.spider;

import me.ethtdp.customitems.common.item.custom.SpiderArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class SpiderArmorRenderer extends GeoArmorRenderer<SpiderArmorItem> {

    public SpiderArmorRenderer() {
        super(new SpiderArmorModel());

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

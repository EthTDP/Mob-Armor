package me.ethtdp.customitems.common.entity.client.armor.zombie;

import me.ethtdp.customitems.common.item.custom.ZombieArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ZombieArmorRenderer extends GeoArmorRenderer<ZombieArmorItem> {

    public ZombieArmorRenderer() {
        super(new ZombieArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}

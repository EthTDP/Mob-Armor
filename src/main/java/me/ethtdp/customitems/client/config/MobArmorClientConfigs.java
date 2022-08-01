package me.ethtdp.customitems.client.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class MobArmorClientConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Configs for Mob Armor");

        // HERE DEFINE YOUR CONFIGS

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}

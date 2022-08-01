package me.ethtdp.customitems.client.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class MobArmorCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> CREEPER_COOLDOWN;
    public static final ForgeConfigSpec.ConfigValue<Integer> WARDEN_COOLDOWN;
    public static final ForgeConfigSpec.ConfigValue<Integer> ZOMBIE_COOLDOWN;

    static {
        BUILDER.push("Configs for Mob Armor");

        BUILDER.comment("All cooldowns are in ticks. 20 Ticks = 1 second.");

        CREEPER_COOLDOWN = BUILDER.comment("How long should the creeper cooldown be?")
                .define("Creeper Cooldown", 200);

        WARDEN_COOLDOWN = BUILDER.comment("How long should the warden cooldown be?")
                        .define("Warden Cooldown", 1000);

        ZOMBIE_COOLDOWN = BUILDER.comment("How long should the zombie cooldown be?")
                        .define("Zombie Cooldown", 100);


        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}

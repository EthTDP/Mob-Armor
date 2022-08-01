package me.ethtdp.customitems.client;

public class Cooldowns {
    private static int creeperCooldown = 0;
    private static int wardenCooldown = 0;
    private static int zombieCooldown = 0;

    public static boolean creeperStart;
    public static boolean wardenStart;
    public static boolean zombieStart;

    public static void startCreeperCooldown() {
        creeperStart = true;
    }

    public static void startWardenCooldown() {
        wardenStart = true;
    }

    public static void startZombieCooldown() {
        zombieStart = true;
    }

    public static int getCreeperCooldown() {
        return creeperCooldown;
    }

    public static void setCreeperCooldown(int creeperCooldown) {
        Cooldowns.creeperCooldown = creeperCooldown;
    }

    public static void changeCreeperCooldown() {
        Cooldowns.creeperCooldown--;
    }

    public static void changeZombieCooldown() {
        Cooldowns.zombieCooldown--;
    }

    public static void changeWardenCooldown() {
        Cooldowns.wardenCooldown--;
    }

    public static int getWardenCooldown() {
        return wardenCooldown;
    }

    public static void setWardenCooldown(int wardenCooldown) {
        Cooldowns.wardenCooldown = wardenCooldown;
    }

    public static int getZombieCooldown() {
        return zombieCooldown;
    }

    public static void setZombieCooldown(int zombieCooldown) {
        Cooldowns.zombieCooldown = zombieCooldown;
    }
}

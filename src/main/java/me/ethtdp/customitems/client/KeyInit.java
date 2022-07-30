package me.ethtdp.customitems.client;

import com.mojang.blaze3d.platform.InputConstants;
import jdk.jfr.Event;
import me.ethtdp.customitems.CustomItems;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.registries.RegisterEvent;
import org.jline.keymap.KeyMap;
import org.lwjgl.glfw.GLFW;

import java.awt.event.KeyEvent;

public final class KeyInit {
    public static final String KEY_CATEGORY_MOB = "key.category.mobarmor.mobarmor";
    public static final String armor_key = "key.mobarmor.armor_key";

    public static final KeyMapping armorKey = new KeyMapping(armor_key, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, InputConstants.KEY_V, KEY_CATEGORY_MOB);

    private KeyInit() {

    }
}

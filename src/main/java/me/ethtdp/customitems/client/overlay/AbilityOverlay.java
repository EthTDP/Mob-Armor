package me.ethtdp.customitems.client.overlay;

import com.mojang.blaze3d.systems.RenderSystem;
import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.client.Cooldowns;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import java.awt.*;

public class AbilityOverlay {
    private static final ResourceLocation CREEPER_ABILITY = new ResourceLocation(CustomItems.MODID,
            "textures/abilities/creeper.png");

    public static final IGuiOverlay CREEPER = ((gui, poseStack, partialTick, width, height) -> {
       int x = width / 2;
       int y = height;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, CREEPER_ABILITY);
        for(int i = 0; i < 10; i++) {
            GuiComponent.blit(poseStack, x - 94 + (i * 9), y - 54, 0, 0, 12, 12,
                    12, 12);
        }
    });
}

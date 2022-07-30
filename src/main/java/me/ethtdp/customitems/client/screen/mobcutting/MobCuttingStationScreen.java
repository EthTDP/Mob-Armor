package me.ethtdp.customitems.client.screen.mobcutting;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import me.ethtdp.customitems.CustomItems;
import me.ethtdp.customitems.client.screen.mobcutting.upgrade.MobCuttingStationUpgradeScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.client.gui.widget.ExtendedButton;
import net.minecraftforge.network.NetworkHooks;

public class MobCuttingStationScreen extends AbstractContainerScreen<MobCuttingStationMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(CustomItems.MODID, "textures/gui/mob_cutting_station_gui.png");

    private static final ResourceLocation BUTTON =
            new ResourceLocation(CustomItems.MODID, "textures/gui/upgrade_button.png");

    private ExtendedButton upgradeButton;

    public MobCuttingStationScreen(MobCuttingStationMenu pMenu, Inventory playerInventory, Component pTitle) {
        super(pMenu, playerInventory, pTitle);
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        if(menu.isCrafting()) {
            blit(pPoseStack, x + 107, y + 32, 179, 1, 7, menu.getScaledProgress());
        }
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, BUTTON);
    }
}

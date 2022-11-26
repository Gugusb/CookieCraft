package com.cookiecraft.client.gui;

import com.cookiecraft.CookieCraftMod;
import com.cookiecraft.capability.CCCapabilities;
import com.cookiecraft.capability.common.HappyCapability;
import com.cookiecraft.capability.common.IHappyCapability;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.util.LazyOptional;

public class HUDHappyState extends AbstractGui {
    private final int width;
    private final int height;
    private final Minecraft minecraft;
    private final ResourceLocation HUD = new ResourceLocation(CookieCraftMod.MODID, "textures/gui/gui_san.png");

    public HUDHappyState() {
        this.width = Minecraft.getInstance().getMainWindow().getScaledWidth();
        this.height = Minecraft.getInstance().getMainWindow().getScaledHeight();
        this.minecraft = Minecraft.getInstance();
    }

    public void render(MatrixStack matrixStack, PlayerEntity playerIn) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(HUD);

        blit(matrixStack, width / 2 - 195, height - 32, 0, 0, 98, 31, 256, 256);

        LazyOptional<IHappyCapability> capability = playerIn.getCapability(CCCapabilities.HAPPY);
        capability.ifPresent((l) -> {
                    int happy = l.getHappyLevel();
                    int length = (int)((happy * 1.0 / 100) * 81);
                    blit(matrixStack, width / 2 - 195 + 8, height - 32 + 18, 0, 37, length, 5, 256, 256);
                }
        );
    }
}

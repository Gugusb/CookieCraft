package com.cookiecraft;

import com.cookiecraft.client.gui.ContainerScreenCookieChest;
import com.cookiecraft.container.CCContainerTypeRegistry;
import com.cookiecraft.container.ContainerCookieChest;
import com.cookiecraft.entity.CCEntityTypeRegistry;
import com.cookiecraft.client.entityrenderer.BuffZombieRenderer;
import com.cookiecraft.client.entityrenderer.RenderCookiePig;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CCClientEventHandler {
    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(CCEntityTypeRegistry.COOKIE_PIG.get(), (EntityRendererManager manager) -> {
            return new RenderCookiePig(manager);
        });
        RenderingRegistry.registerEntityRenderingHandler(CCEntityTypeRegistry.BUFF_ZOMBIE.get(), (EntityRendererManager manager) -> {
            return new BuffZombieRenderer(manager);
        });
        //Register bind between screen and container
        ScreenManager.registerFactory(CCContainerTypeRegistry.COOKIE_CHEST.get(), (ContainerCookieChest screenContainer, PlayerInventory inv, ITextComponent titleIn) -> {
            return new ContainerScreenCookieChest(screenContainer, inv, titleIn);
        });
    }
}

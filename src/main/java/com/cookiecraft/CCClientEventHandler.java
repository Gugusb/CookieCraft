package com.cookiecraft;

import com.cookiecraft.entity.CCEntityTypeRegistry;
import com.cookiecraft.entityrenderer.BuffZombieRenderer;
import com.cookiecraft.entityrenderer.RenderCookiePig;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CCClientEventHandler {
    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        System.out.println("register final");
        RenderingRegistry.registerEntityRenderingHandler(CCEntityTypeRegistry.COOKIE_PIG.get(), (EntityRendererManager manager) -> {
            return new RenderCookiePig(manager);
        });
        RenderingRegistry.registerEntityRenderingHandler(CCEntityTypeRegistry.BUFF_ZOMBIE.get(), (EntityRendererManager manager) -> {
            return new BuffZombieRenderer(manager);
        });
        System.out.println("register final");
    }
}

package com.cookiecraft;

import com.cookiecraft.entity.BuffZombieEntity;
import com.cookiecraft.entity.CCEntityTypeRegistry;
import com.cookiecraft.entity.EntityCookiePig;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CookieCraftMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(CCEntityTypeRegistry.BUFF_ZOMBIE.get(), BuffZombieEntity.setCustomAttributes().create());
        event.put(CCEntityTypeRegistry.COOKIE_PIG.get(), EntityCookiePig.setCustomAttributes().create());
    }
}

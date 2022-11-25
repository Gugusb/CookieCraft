package com.cookiecraft;

import com.cookiecraft.block.CCBlockRegistry;
import com.cookiecraft.entity.BuffZombieEntity;
import com.cookiecraft.entity.CCEntityTypeRegistry;
import com.cookiecraft.entity.EntityCookiePig;
import com.cookiecraft.item.CCItemRegistry;
import com.cookiecraft.tileentity.CCTileEntityTypeRegistry;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("cookiecraft")
public class CookieCraftMod {
    public static final String MODID = "cookiecraft";
    public static final String NAME = "CookieCraft";
    public static final String VERSION = "1.0";
    public static final String AMV = "1.16.5";

    public CookieCraftMod(){
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        CCEntityTypeRegistry.register(eventBus);
        CCItemRegistry.ITEMS.register(eventBus);
        CCBlockRegistry.BLOCKS.register(eventBus);
        CCTileEntityTypeRegistry.TILE_ENTITY_TYPE_DEFERRED_REGISTER.register(eventBus);
        //CCEntityTypeRegistry.ENTITY_TYPES.register(eventBus);

        eventBus.addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(CCEntityTypeRegistry.COOKIE_PIG.get(), EntityCookiePig.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(CCEntityTypeRegistry.BUFF_ZOMBIE.get(), BuffZombieEntity.setCustomAttributes().create());
        });
    }

}

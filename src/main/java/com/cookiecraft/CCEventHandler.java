package com.cookiecraft;

import com.cookiecraft.capability.CCCapabilities;
import com.cookiecraft.capability.common.IHappyCapability;
import com.cookiecraft.capability.provider.HappyCapabilityProvider;
import com.cookiecraft.entity.BuffZombieEntity;
import com.cookiecraft.entity.CCEntityTypeRegistry;
import com.cookiecraft.entity.EntityCookiePig;
import com.cookiecraft.network.CCNetWork;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber()
public class CCEventHandler {

    @SubscribeEvent
    public static void onAttachCapabilityEvent(AttachCapabilitiesEvent<Entity> event) {
        Entity entity = event.getObject();
        if (entity instanceof PlayerEntity) {
            event.addCapability(new ResourceLocation(CookieCraftMod.MODID, "happy"), new HappyCapabilityProvider());
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (!event.isWasDeath()) {
            LazyOptional<IHappyCapability> oldCapability = event.getOriginal().getCapability(CCCapabilities.HAPPY);
            LazyOptional<IHappyCapability> newCapability = event.getPlayer().getCapability(CCCapabilities.HAPPY);
            if (oldCapability.isPresent() && newCapability.isPresent()) {
                newCapability.ifPresent((newCap) -> {
                    oldCapability.ifPresent((oldCap) -> {
                        newCap.deserializeNBT(oldCap.serializeNBT());
                    });
                });
            }
        }
    }
}

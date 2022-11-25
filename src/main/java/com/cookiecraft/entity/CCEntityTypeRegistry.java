package com.cookiecraft.entity;

import com.cookiecraft.CookieCraftMod;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CCEntityTypeRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, CookieCraftMod.MODID);

    public static final RegistryObject<EntityType<EntityCookiePig>> COOKIE_PIG =
            ENTITY_TYPES.register("cookie_pig",
                    () -> EntityType.Builder.create(EntityCookiePig::new,
                                    EntityClassification.MISC).size(1.0f, 1.0f)
                            .build(new ResourceLocation(CookieCraftMod.MODID, "cookie_pig").toString()));

    public static final RegistryObject<EntityType<BuffZombieEntity>> BUFF_ZOMBIE =
            ENTITY_TYPES.register("buff_zombie",
                    () -> EntityType.Builder.create(BuffZombieEntity::new,
                                    EntityClassification.MONSTER).size(1f, 3f)
                            .build(new ResourceLocation(CookieCraftMod.MODID, "buff_zombie").toString()));
    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}

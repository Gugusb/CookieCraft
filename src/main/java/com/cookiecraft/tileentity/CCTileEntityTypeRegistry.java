package com.cookiecraft.tileentity;

import com.cookiecraft.CookieCraftMod;
import com.cookiecraft.block.CCBlockRegistry;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CCTileEntityTypeRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, CookieCraftMod.MODID);
    public static final RegistryObject<TileEntityType<TileEntityCookieMaker>> COOKIEMAKER =
            TILE_ENTITY_TYPE_DEFERRED_REGISTER.register("tileentity_cookie_maker", () -> {
        return TileEntityType.Builder.create(() -> {
            return new TileEntityCookieMaker();
        }, CCBlockRegistry.COOKIE_NAKER.get()).build(null);
    });

    public static final RegistryObject<TileEntityType<TileEntityCookieChest>> COOKIE_CHEST =
            TILE_ENTITY_TYPE_DEFERRED_REGISTER.register("tileentity_cookie_chest", () -> {
                return TileEntityType.Builder.create(() -> {
                    return new TileEntityCookieChest();
                }, CCBlockRegistry.COOKIE_CHEST.get()).build(null);
            });
}

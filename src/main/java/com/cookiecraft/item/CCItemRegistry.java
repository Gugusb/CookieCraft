package com.cookiecraft.item;

import com.cookiecraft.CookieCraftMod;
import com.cookiecraft.block.CCBlockRegistry;
import com.cookiecraft.itemgroup.CCItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CCItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CookieCraftMod.MODID);

    public static RegistryObject<Item> SPECIAL_COOKIE = ITEMS.register("special_cookie", ItemSpecialCookie::new);
    public static RegistryObject<Item> COOKIE_INGOT = ITEMS.register("cookie_ingot", ItemCookieIngot::new);
    public static RegistryObject<Item> COOKIE_SWORD = ITEMS.register("cookie_sword", ItemCookieSword::new);
    public static RegistryObject<Item> MIX_COOKIE = ITEMS.register("mix_cookie", () -> {
        return new BlockItem(CCBlockRegistry.MIX_COOKIE.get(), new Item.Properties().group(CCItemGroup.COOKIE_CRAFT_MAIN));
    });
}

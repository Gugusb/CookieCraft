package com.cookiecraft.itemgroup;

import com.cookiecraft.item.CCItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroupCookieCraft extends ItemGroup {
    public ItemGroupCookieCraft() {
        super("cookiecraft");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(CCItemRegistry.COOKIE_INGOT.get());
    }
}

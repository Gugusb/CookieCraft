package com.cookiecraft.item;

import com.cookiecraft.enums.CookieCraftItemTier;
import com.cookiecraft.itemgroup.CCItemGroup;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;

public class ItemCookieSword extends SwordItem {

    public ItemCookieSword() {
        super(CookieCraftItemTier.TOOL_COOKIE, 3, -2.4F, new Properties().group(CCItemGroup.COOKIE_CRAFT_MAIN));
    }
}

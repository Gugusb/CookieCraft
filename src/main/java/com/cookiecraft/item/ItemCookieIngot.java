package com.cookiecraft.item;

import com.cookiecraft.itemgroup.CCItemGroup;
import net.minecraft.item.Item;

public class ItemCookieIngot extends Item {
    public ItemCookieIngot() {
        super(new Properties().group(CCItemGroup.COOKIE_CRAFT_MAIN));
    }
}

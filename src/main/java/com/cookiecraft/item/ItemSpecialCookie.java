package com.cookiecraft.item;

import com.cookiecraft.itemgroup.CCItemGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ItemSpecialCookie extends Item {
    private static Food food = (new Food.Builder())
            .hunger(20)
            .saturation(20)
            .effect(() -> new EffectInstance(Effects.POISON, 3 * 20, 1) ,1)
            .build();

    public ItemSpecialCookie() {
        super(new Properties().food(food).group(CCItemGroup.COOKIE_CRAFT_MAIN));
    }
}

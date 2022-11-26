package com.cookiecraft.item;

import com.cookiecraft.itemgroup.CCItemGroup;
import com.cookiecraft.world.WorldSavedDataOverWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class ItemSpecialCookie extends Item {
    private static Food food = (new Food.Builder())
            .hunger(20)
            .saturation(20)
            .effect(() -> new EffectInstance(Effects.POISON, 3 * 20, 1) ,1)
            .build();

    public ItemSpecialCookie() {
        super(new Properties().food(food).group(CCItemGroup.COOKIE_CRAFT_MAIN));
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemStack = super.onItemUseFinish(stack, worldIn, entityLiving);
        if(!worldIn.isRemote){
            WorldSavedDataOverWorld data = WorldSavedDataOverWorld.get(worldIn);
            data.putItem(stack);
            for(int i = 0;i < data.getItemCount();i ++){
                System.out.println("" + data.getItem(i).getItem().getName() + data.getItem(i).getCount());
            }
        }
        return itemStack;
    }
}

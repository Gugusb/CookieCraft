package com.cookiecraft.item;

import com.cookiecraft.capability.CCCapabilities;
import com.cookiecraft.capability.common.IHappyCapability;
import com.cookiecraft.enums.CookieCraftItemTier;
import com.cookiecraft.itemgroup.CCItemGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;

public class ItemCookieSword extends SwordItem {

    public ItemCookieSword() {
        super(CookieCraftItemTier.TOOL_COOKIE, 3, -2.4F, new Properties().group(CCItemGroup.COOKIE_CRAFT_MAIN));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote && handIn == Hand.MAIN_HAND) {
            LazyOptional<IHappyCapability> capability = playerIn.getCapability(CCCapabilities.HAPPY);
            capability.ifPresent((l) -> {
                        int level = l.getHappyLevel();
                        playerIn.sendStatusMessage(new StringTextComponent("HappyLevel: " + level), false);
                    }
            );
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}

package com.cookiecraft.item;

import com.cookiecraft.itemgroup.CCItemGroup;
import com.cookiecraft.network.CCNetWork;
import com.cookiecraft.network.CCSendPack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class ItemCookieIngot extends Item {
    public ItemCookieIngot() {
        super(new Properties().group(CCItemGroup.COOKIE_CRAFT_MAIN));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (worldIn.isRemote) {
            CCNetWork.INSTANCE.sendToServer(new CCSendPack("From the Client"));
        }
        if (!worldIn.isRemote) {
            CCNetWork.INSTANCE.send(
                    PacketDistributor.PLAYER.with(
                            () -> {
                                return (ServerPlayerEntity) playerIn;
                            }
                    ),
                    new CCSendPack("From Server, " + playerIn.getName()));
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}

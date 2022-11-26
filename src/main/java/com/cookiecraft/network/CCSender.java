package com.cookiecraft.network;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.fml.network.PacketDistributor;

public class CCSender {
    public static void send(PlayerEntity playerIn, int value){
        CCNetWork.INSTANCE.send(
                PacketDistributor.PLAYER.with(
                        () -> {
                            return (ServerPlayerEntity) playerIn;
                        }
                ),
                new CCSendPack(value));
    }
}

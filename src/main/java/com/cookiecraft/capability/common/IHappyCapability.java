package com.cookiecraft.capability.common;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;
import net.minecraftforge.common.util.INBTSerializable;

public interface IHappyCapability extends INBTSerializable<CompoundNBT> {
    int getHappyLevel();
    int setHappyLevel(World world, PlayerEntity player, int value);
}

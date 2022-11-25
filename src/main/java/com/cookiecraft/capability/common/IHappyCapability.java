package com.cookiecraft.capability.common;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public interface IHappyCapability extends INBTSerializable<CompoundNBT> {
    int getHappyLevel();
}

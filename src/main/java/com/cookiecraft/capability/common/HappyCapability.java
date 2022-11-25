package com.cookiecraft.capability.common;

import net.minecraft.nbt.CompoundNBT;

public class HappyCapability implements IHappyCapability {
    private int level;

    public HappyCapability(int level) {
        this.level = level;
    }

    @Override
    public int getHappyLevel() {
        return level;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.putInt("happy_level", this.level);
        return compoundNBT;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.level = nbt.getInt("happy_level");
    }
}

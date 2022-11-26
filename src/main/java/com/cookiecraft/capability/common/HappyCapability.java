package com.cookiecraft.capability.common;

import com.cookiecraft.network.CCSender;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;

public class HappyCapability implements IHappyCapability {
    private int level;

    public HappyCapability(int level) {
        this.level = level;
    }

    @Override
    public int getHappyLevel() {
        if(level < 0){
            level = 0;
        }
        return level;
    }

    @Override
    public int setHappyLevel(World world, PlayerEntity player, int value) {
        this.level = value;
        if(this.level < 0){
            this.level = 100;
        }
        if(world != null && !world.isRemote){
            CCSender.send(player, this.getHappyLevel());
        }
        return this.getHappyLevel();
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

package com.cookiecraft.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCookieMaker extends TileEntity {
    private int energy = 0;
    public TileEntityCookieMaker() {
        super(CCTileEntityTypeRegistry.COOKIEMAKER.get());
    }

    public int getEnergy(){
        return this.energy;
    }

    public int changeEnergy(int value){
        this.energy += value;
        markDirty();
        return this.energy;
    }

    @Override
    public void read(BlockState state, CompoundNBT compound) {
        this.energy = compound.getInt("energy");
        super.read(state, compound);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putInt("energy", this.energy);
        return super.write(compound);
    }
}

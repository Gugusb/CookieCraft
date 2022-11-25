package com.cookiecraft.capability.provider;

import com.cookiecraft.capability.CCCapabilities;
import com.cookiecraft.capability.common.HappyCapability;
import com.cookiecraft.capability.common.IHappyCapability;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class HappyCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundNBT> {
    private IHappyCapability happyCapability;
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == CCCapabilities.HAPPY ? LazyOptional.of(() -> {
            return this.getOrCreateCapability();
        }).cast() : LazyOptional.empty();
    }

    @Nonnull
    IHappyCapability getOrCreateCapability() {
        if (happyCapability == null) {
            Random random = new Random();
            this.happyCapability = new HappyCapability(random.nextInt(1000) + 1);
        }
        return this.happyCapability;
    }

    @Override
    public CompoundNBT serializeNBT() {
        return getOrCreateCapability().serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        getOrCreateCapability().deserializeNBT(nbt);
    }
}

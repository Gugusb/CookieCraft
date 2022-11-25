package com.cookiecraft.capability;

import com.cookiecraft.capability.common.IHappyCapability;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class CCCapabilities {
    @CapabilityInject(IHappyCapability.class)
    public static Capability<IHappyCapability> HAPPY;
}

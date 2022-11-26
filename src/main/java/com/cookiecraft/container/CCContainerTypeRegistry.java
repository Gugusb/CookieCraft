package com.cookiecraft.container;

import com.cookiecraft.CookieCraftMod;
import com.cookiecraft.tileentity.IntArray.CommonIntArray;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CCContainerTypeRegistry {
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, CookieCraftMod.MODID);
    public static RegistryObject<ContainerType<ContainerCookieChest>> COOKIE_CHEST = CONTAINERS.register("container_cookie_chest", () -> {
        return IForgeContainerType.create((int windowId, PlayerInventory inv, PacketBuffer data) -> {
            return new ContainerCookieChest(windowId, inv, data.readBlockPos(), Minecraft.getInstance().world, new CommonIntArray());
        });
    });
}

package com.cookiecraft.network;

import com.cookiecraft.CookieCraftMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class CCNetWork {
    public static SimpleChannel INSTANCE;
    public static final String VERSION = "1.0";
    private static int ID = 0;

    public static int getID(){
        return ID++;
    }
    public static void registerMessage() {
        INSTANCE = NetworkRegistry.newSimpleChannel(
                new ResourceLocation(CookieCraftMod.MODID, "cc_networking"),
                () -> {
                    return VERSION;
                },
                (version) -> {
                    return version.equals(VERSION);
                },
                (version) -> {
                    return version.equals(VERSION);
                });
        INSTANCE.registerMessage(
                getID(),
                CCSendPack.class,
                (pack, buffer) -> {
                    pack.toBytes(buffer);
                },
                (buffer) -> {
                    return new CCSendPack(buffer);
                },
                (pack, ctx) -> {
                    pack.handler(ctx);
                }
        );
    }
}

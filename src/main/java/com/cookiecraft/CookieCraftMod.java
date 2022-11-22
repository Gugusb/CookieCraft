package com.cookiecraft;

import com.cookiecraft.block.CCBlockRegistry;
import com.cookiecraft.item.CCItemRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("cookiecraft")
public class CookieCraftMod {
    public static final String MODID = "cookiecraft";
    public static final String NAME = "CookieCraft";
    public static final String VERSION = "1.0";
    public static final String AMV = "1.16.5";

    public CookieCraftMod(){
        CCItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        CCBlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}

package com.cookiecraft.block;

import com.cookiecraft.CookieCraftMod;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CCBlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CookieCraftMod.MODID);
    public static RegistryObject<Block> MIX_COOKIE = BLOCKS.register("mix_cookie", BlockMixCookie::new);
}

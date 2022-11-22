package com.cookiecraft.block;

import net.minecraft.block.CakeBlock;
import net.minecraft.block.material.Material;

public class BlockMixCookie extends CakeBlock {
    public BlockMixCookie() {
        super(Properties.create(Material.CAKE).hardnessAndResistance(10.0f, 10.0f));
    }
}

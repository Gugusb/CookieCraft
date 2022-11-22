package com.cookiecraft.block;

import com.cookiecraft.tileentity.TileEntityCookieMaker;
import javafx.animation.TranslateTransition;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockCookieMaker extends Block {
    public BlockCookieMaker() {
        super(Properties.create(Material.CAKE).hardnessAndResistance(5));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityCookieMaker();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote && handIn == Hand.MAIN_HAND){
            TileEntityCookieMaker entity = (TileEntityCookieMaker) worldIn.getTileEntity(pos);
            int energy = entity.changeEnergy(3);
            TranslationTextComponent text = new TranslationTextComponent("message.cookiecraft.tip1", energy);
            player.sendStatusMessage(text, false);
        }
        return ActionResultType.SUCCESS;
    }
}

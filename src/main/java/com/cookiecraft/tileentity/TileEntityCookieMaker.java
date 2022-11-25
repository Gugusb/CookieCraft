package com.cookiecraft.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.Constants;
import org.lwjgl.system.CallbackI;

import javax.annotation.Nullable;

public class TileEntityCookieMaker extends TileEntity implements ITickableTileEntity {
    private int energy = 0;
    private static final int MAX_TIME = 20 * 3;
    private int timer = 0;
    private boolean flag = false;
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
    public void tick() {
        if(!this.world.isRemote){
            if(this.timer >= this.MAX_TIME){
                this.timer = 0;
                PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);
                if(player != null){
                    TranslationTextComponent text = new TranslationTextComponent("message.cookiecraft.hello", player.getName());
                    player.sendStatusMessage(text, false);
                    this.flag = true;
                    world.notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
                }
            }else{
                this.timer ++;
            }
        }else{
            if(this.flag){
                this.flag = false;
                PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);
                StringTextComponent text = new StringTextComponent("Im client, given you a surprise!");
                player.sendMessage(text, player.getUniqueID());
                this.world.playSound(player, this.getPos(), SoundEvents.ENTITY_CREEPER_PRIMED, SoundCategory.AMBIENT, 1.0f, 1.0f);
            }
        }
    }

    //将方块实体的数据存盘 实例对象：energy
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

    //将方块实体的数据开启服务端客户端互通 实例对象：flag
    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(pos, 1, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        handleUpdateTag(pkt.getNbtCompound());
    }

    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT compoundNBT = super.getUpdateTag();
        compoundNBT.putBoolean("flag", flag);
        return compoundNBT;
    }

    public void handleUpdateTag(CompoundNBT tag) {
        flag = tag.getBoolean("flag");
    }
}

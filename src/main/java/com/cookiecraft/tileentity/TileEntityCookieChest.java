package com.cookiecraft.tileentity;

import com.cookiecraft.container.ContainerCookieChest;
import com.cookiecraft.tileentity.IntArray.CommonIntArray;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import javax.annotation.Nullable;

public class TileEntityCookieChest extends TileEntity implements ITickableTileEntity, INamedContainerProvider {
    private Inventory inventory_1 = new Inventory(18);
    private Inventory inventory_2 = new Inventory(new ItemStack(Items.DIAMOND), new ItemStack(Items.IRON_PICKAXE));
    private CommonIntArray number = new CommonIntArray();

    public TileEntityCookieChest() {
        super(CCTileEntityTypeRegistry.COOKIE_CHEST.get());
    }

    @Override
    public ITextComponent getDisplayName() {
        return new StringTextComponent("Cookie_Chest");
    }

    @Nullable
    @Override
    public Container createMenu(int sycID, PlayerInventory inventory, PlayerEntity player) {
        return new ContainerCookieChest(sycID, inventory, this.pos, this.world, number);
    }

    public Inventory getInventory_1(){
        return inventory_1;
    }

    public Inventory getInventory_2(){
        return inventory_2;
    }

    @Override
    public void tick() {
        if (!world.isRemote) {
            this.number.set(0, this.inventory_1.getStackInSlot(0).getCount());
        }
    }

    @Override
    public void read(BlockState state, CompoundNBT compound) {
        ListNBT listNBT = (ListNBT) compound.get("inventory");
        if (listNBT != null) {
            int i = 0;
            for (INBT value : listNBT) {
                CompoundNBT tag = (CompoundNBT) value;
                ItemStack itemStack = ItemStack.read(tag.getCompound("item"));
                this.inventory_1.setInventorySlotContents(i, itemStack);
                i ++;
            }
        }
        super.read(state, compound);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        ListNBT listNBT = new ListNBT();
        for(int i = 0;i < inventory_1.getSizeInventory();i ++){
            ItemStack itemStack = inventory_1.getStackInSlot(i);
            CompoundNBT nbt = new CompoundNBT();
            nbt.put("item", itemStack.serializeNBT());
            listNBT.add(nbt);
        }
        compound.put("inventory", listNBT);
        return super.write(compound);
    }

}

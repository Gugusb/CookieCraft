package com.cookiecraft.container;

import com.cookiecraft.tileentity.IntArray.CommonIntArray;
import com.cookiecraft.tileentity.TileEntityCookieChest;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerCookieChest extends Container {
    private CommonIntArray number;
    public ContainerCookieChest(int id, PlayerInventory playerInventory, BlockPos pos, World world, CommonIntArray intArray) {
        super(CCContainerTypeRegistry.COOKIE_CHEST.get(), id);
        this.number = intArray;
        trackIntArray(this.number);
        TileEntityCookieChest tile_entity = (TileEntityCookieChest) world.getTileEntity(pos);
        layoutCommonIventory(tile_entity.getInventory_1(), 8, 18);
        layoutPlayerInventorySlots(playerInventory, 8, 84);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        return ItemStack.EMPTY;
    }

    public IIntArray getIntArray() {
        return this.number;
    }

    private void layoutCommonIventory(IInventory inventory, int leftCol, int topRow) {
        addSlotBox(inventory, 0, leftCol, topRow, 9, 18, 2, 18);
    }

    private void layoutPlayerInventorySlots(IInventory inventory, int leftCol, int topRow) {
        addSlotBox(inventory, 9, leftCol, topRow, 9, 18, 3, 18);
        topRow += 58;
        addSlotRange(inventory, 0, leftCol, topRow, 9, 18);
    }

    private int addSlotRange(IInventory inventory, int index, int x, int y, int amount, int dx) {
        for (int i = 0; i < amount; i++) {
            addSlot(new Slot(inventory, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private int addSlotBox(IInventory inventory, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0; j < verAmount; j++) {
            index = addSlotRange(inventory, index, x, y, horAmount, dx);
            y += dy;
        }
        return index;
    }
}

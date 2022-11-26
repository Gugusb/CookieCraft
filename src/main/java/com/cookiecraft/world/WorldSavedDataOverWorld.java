package com.cookiecraft.world;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.common.world.ForgeWorldType;

import java.util.ArrayList;
import java.util.List;

public class WorldSavedDataOverWorld extends WorldSavedData {
    private static final String NAME = "WorldSavedDataOverWorld";
    private static final int MAX_COUNT = 32;
    private List<ItemStack> items = new ArrayList<>();

    public WorldSavedDataOverWorld(String name) {
        super(name);
    }

    public WorldSavedDataOverWorld() {
        super(NAME);
    }

    public boolean putItem(ItemStack itemStack){
        if(items.size() < MAX_COUNT){
            items.add(itemStack);
            markDirty();
            return true;
        }else{
            return false;
        }
    }

    public int getItemCount(){
        return items.size();
    }

    public ItemStack getItem(int solt){
        if(items.size() < solt){
            return new ItemStack(Items.AIR);
        }else{
            return items.get(solt);
        }
    }

    public static WorldSavedDataOverWorld get(World worldIn){
        if(worldIn.isRemote){
            throw new RuntimeException("Attempted to get the data from a client world. This is wrong.");
        }
        ServerWorld world = worldIn.getServer().getWorld(World.OVERWORLD);
        DimensionSavedDataManager storage = world.getSavedData();
        return storage.getOrCreate(() -> {
            return new WorldSavedDataOverWorld();
        }, NAME);
    }

    @Override
    public void read(CompoundNBT nbt) {
        ListNBT listNBT = (ListNBT) nbt.get("items");
        if (listNBT != null) {
            for (INBT value : listNBT) {
                CompoundNBT tag = (CompoundNBT) value;
                ItemStack itemStack = ItemStack.read(tag.getCompound("item"));
                items.add(itemStack);
            }
        }
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        ListNBT listNBT = new ListNBT();
        items.stream().forEach((item) -> {
            CompoundNBT compoundNBT = new CompoundNBT();
            compoundNBT.put("item", item.serializeNBT());
            listNBT.add(compoundNBT);
        });
        compound.put("items", listNBT);
        return compound;
    }
}

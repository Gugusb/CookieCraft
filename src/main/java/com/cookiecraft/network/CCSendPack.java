package com.cookiecraft.network;

import com.cookiecraft.capability.CCCapabilities;
import com.cookiecraft.capability.common.IHappyCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class CCSendPack {
    private int value;
    private static final Logger LOGGER = LogManager.getLogger();

    public CCSendPack(PacketBuffer buffer) {
        this.value = buffer.readInt();
    }

    public CCSendPack(int value){
        this.value = value;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeInt(this.value);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            PlayerEntity playerIn = Minecraft.getInstance().player;
            LazyOptional<IHappyCapability> capability = playerIn.getCapability(CCCapabilities.HAPPY);
            capability.ifPresent((l) -> {
                        int level = l.setHappyLevel(null, null, value);
                    }
            );
        });
        ctx.get().setPacketHandled(true);
    }
}

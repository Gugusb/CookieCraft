package com.cookiecraft.network;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class CCSendPack {
    private String message;
    private static final Logger LOGGER = LogManager.getLogger();

    public CCSendPack(PacketBuffer buffer) {
        message = buffer.readString(Short.MAX_VALUE);
    }

    public CCSendPack(String message) {
        this.message = message;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeString(this.message);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            LOGGER.info(this.message);
        });
        ctx.get().setPacketHandled(true);
    }
}
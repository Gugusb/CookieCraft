package com.cookiecraft.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.world.World;

public class EntityGugu extends ZombieEntity {
    public EntityGugu(EntityType<? extends ZombieEntity> type, World worldIn) {
        super(type, worldIn);
    }
}

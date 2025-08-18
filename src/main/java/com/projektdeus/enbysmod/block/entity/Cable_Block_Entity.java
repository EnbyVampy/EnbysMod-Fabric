package com.projektdeus.enbysmod.block.entity;

import com.projektdeus.enbysmod.registry.ModBlockEntities;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;

public class Cable_Block_Entity extends BlockEntity {
    public Cable_Block_Entity(BlockEntityType<Cable_Block_Entity> cableBlockEntity, BlockPos pos, BlockState state) {
        super(ModBlockEntities.CABLE_BLOCK_ENTITY, pos, state);
    }
}

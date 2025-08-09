package com.projektdeus.enbysmod.block.custom.display_blocks;

import com.projektdeus.enbysmod.block.common.GenericDisplayBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import static net.minecraft.util.shape.VoxelShapes.union;

import net.minecraft.world.BlockView;
import net.minecraft.block.ShapeContext;

public class DisplayPlatform extends GenericDisplayBlock {
    private static final VoxelShape PLATFORM_SHAPE = createCuboidShape(2.0, 0.0, 2.0, 14.0, 1, 14.0);

    public DisplayPlatform(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return PLATFORM_SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return PLATFORM_SHAPE;
    }
}
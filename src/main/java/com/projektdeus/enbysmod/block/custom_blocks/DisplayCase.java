package com.projektdeus.enbysmod.block.custom_blocks;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import static net.minecraft.util.shape.VoxelShapes.union;

import net.minecraft.world.BlockView;
import net.minecraft.block.ShapeContext;

public class DisplayCase extends GenericDisplayBlock {
    private static final VoxelShape GLASS = createCuboidShape(2.75, 1.0, 2.75, 13.25, 13.0, 13.25);
    private static final VoxelShape BOTTOM = createCuboidShape(2.0, 0.0, 2.0, 14.0, 1.0, 14.0);
    public static final VoxelShape FULL_SHAPE = union(GLASS, BOTTOM);

    public DisplayCase(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return FULL_SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return FULL_SHAPE;
    }
}
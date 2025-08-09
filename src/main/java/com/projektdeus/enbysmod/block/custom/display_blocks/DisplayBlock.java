package com.projektdeus.enbysmod.block.custom.display_blocks;

import com.projektdeus.enbysmod.block.common.GenericDisplayBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import static net.minecraft.util.shape.VoxelShapes.union;

import net.minecraft.world.BlockView;
import net.minecraft.block.ShapeContext;

public class DisplayBlock extends GenericDisplayBlock {
    private static final VoxelShape TOP = createCuboidShape(0.0, 15.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape GLASS = createCuboidShape(1.0, 1.0, 1.0, 15.0, 15.0, 15.0);
    private static final VoxelShape BOTTOM = createCuboidShape(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
    public static final VoxelShape FULL_SHAPE = union(TOP, GLASS, BOTTOM);

    public DisplayBlock(Settings settings) {
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
package com.projektdeus.enbysmod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class PlushieBlock extends HorizontalFacingBlock {
    public static final VoxelShape SHAPE = Block.createCuboidShape(4, 0, 4, 12, 11, 12);

    public static final MapCodec<PlushieBlock> CODEC = createCodec(PlushieBlock::new);

    public PlushieBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction dir = ctx.getHorizontalPlayerFacing();  // no .getOpposite()
        return this.getDefaultState().with(FACING, dir);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }


}

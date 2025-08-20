package com.projektdeus.enbysmod.block.custom_blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class Plushie_Crafting_Bench extends HorizontalFacingBlock implements BlockEntityProvider {
    public static final MapCodec<Plushie_Crafting_Bench> CODEC = createCodec(Plushie_Crafting_Bench::new);


    private static final VoxelShape SHAPE;

    static {
        // Tabletop
        VoxelShape top = Block.createCuboidShape(0, 10, 0, 16, 12, 16);
        // Four legs
        VoxelShape leg1 = Block.createCuboidShape(14, 0, 0, 16, 10, 2);
        VoxelShape leg2 = Block.createCuboidShape(0, 0, 0, 2, 10, 2);
        VoxelShape leg3 = Block.createCuboidShape(0, 0, 14, 2, 10, 16);
        VoxelShape leg4 = Block.createCuboidShape(14, 0, 14, 16, 10, 16);

        SHAPE = VoxelShapes.union(top, leg1, leg2, leg3, leg4);
    }

    public Plushie_Crafting_Bench(Settings settings) {
        super(settings);
    }
    @Override
    public MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }


    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state){
        return null;
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
    @Override
    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return true; // Optional for better light handling
    }

}

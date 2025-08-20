package com.projektdeus.enbysmod.block.custom_blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class DaiPanda_Plushie extends GenericPlushieBlock {
    public static final MapCodec<DaiPanda_Plushie> CODEC = createCodec(DaiPanda_Plushie::new);

    private static final VoxelShape SHAPE;

    static {
        VoxelShape Collision = Block.createCuboidShape(5.0,0.0,5.0,11.0,10.0,11.0);
        SHAPE = VoxelShapes.union(Collision);
    }

    public DaiPanda_Plushie(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getBaseShape() {
        return SHAPE;
    }

    @Override
    public MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }
}

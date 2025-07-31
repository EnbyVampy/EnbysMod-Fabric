package com.projektdeus.enbysmod.block.custom;

import com.mojang.serialization.MapCodec;
import com.projektdeus.enbysmod.block.PlushieBlock;
import net.minecraft.block.Block;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class Plushie_Enbyvampy extends PlushieBlock {
    public static final MapCodec<Plushie_Enbyvampy> CODEC = createCodec(Plushie_Enbyvampy::new);

    private static final VoxelShape SHAPE;

    static {
        VoxelShape Body = Block.createCuboidShape(      5.77,1.3656,6.83658,10.245,7.4906,9.33658);
        VoxelShape LeftLeg = Block.createCuboidShape(   5.9,-0.1,3.9,8.1,2.1,10.1);
        VoxelShape RightLeg = Block.createCuboidShape(  7.9,-0.1,3.9,10.1,2.1,10.1);
        VoxelShape Head = Block.createCuboidShape(      5.75,6.95,5.75,10.25,11.45,10.25);
        VoxelShape LeftArm = Block.createCuboidShape(   4.4,1.2806,8.81342,6.1,7.4806,11.01342);
        VoxelShape RightArm = Block.createCuboidShape(  9.9,1.2806,8.81342,11.6,7.4806,11.01342);
        SHAPE = VoxelShapes.union(Body, LeftLeg, RightLeg, Head, LeftArm, RightArm);
    }

    public Plushie_Enbyvampy(Settings settings) {
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

package com.projektdeus.enbysmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class PlushieCraftingBench extends BlockWithEntity implements BlockEntityProvider {
    public static final MapCodec<PlushieCraftingBench> CODEC = createCodec(PlushieCraftingBench::new);


    @Override
    public MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    public PlushieCraftingBench(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state){
        return null;
    }


}

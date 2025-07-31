package com.projektdeus.enbysmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import static com.projektdeus.enbysmod.block.ModBlocks.ENBYVAMPY_PLUSHIE;
import static com.projektdeus.enbysmod.block.ModBlocks.PLUSHIE_CRAFTING_BENCH;

public class EnbysModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ENBYVAMPY_PLUSHIE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PLUSHIE_CRAFTING_BENCH, RenderLayer.getCutout());
    }
}

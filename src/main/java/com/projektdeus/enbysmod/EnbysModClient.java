package com.projektdeus.enbysmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import static com.projektdeus.enbysmod.block.ModBlocks.ENBYVAMPY_PLUSHIE;

public class EnbysModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ENBYVAMPY_PLUSHIE, RenderLayer.getCutout());
    }
}

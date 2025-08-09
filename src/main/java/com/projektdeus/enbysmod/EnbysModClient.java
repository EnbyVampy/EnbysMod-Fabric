package com.projektdeus.enbysmod;

import com.projektdeus.enbysmod.block.render.DisplayBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import com.projektdeus.enbysmod.registry.ModBlockEntities;


import static com.projektdeus.enbysmod.registry.ModBlocks.*;

public class EnbysModClient implements ClientModInitializer {
    @Override
    @SuppressWarnings("deprecation")
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(ModBlockEntities.DISPLAY_BLOCK_ENTITY, DisplayBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.DISPLAY_CASE_ENTITY, DisplayBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.DISPLAY_PLATFORM_ENTITY, DisplayBlockEntityRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ENBYVAMPY_PLUSHIE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PLUSHIE_CRAFTING_BENCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DISPLAY_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DISPLAY_PLATFORM, RenderLayer.getCutout());
    }
}

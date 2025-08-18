package com.projektdeus.enbysmod;

import com.projektdeus.enbysmod.block.entity.client.Cable_Block_Entity_Renderer;
import com.projektdeus.enbysmod.block.entity.client.model.Cable_Block_Model;
import com.projektdeus.enbysmod.block.render.DisplayBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.RenderLayer;
import com.projektdeus.enbysmod.registry.ModBlockEntities;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;


import static com.projektdeus.enbysmod.registry.ModBlocks.*;

public class EnbysModClient implements ClientModInitializer {
    public static final EntityModelLayer CABLE_BLOCK_LAYER =
            new EntityModelLayer(Identifier.of("enbysmod", "cable_block_layer"), "main");

    @Override
    public void onInitializeClient() {
        // --- Block Entity Renderers ---
        BlockEntityRendererFactories.register(ModBlockEntities.DISPLAY_BLOCK_ENTITY, DisplayBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.DISPLAY_CASE_ENTITY, DisplayBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.DISPLAY_PLATFORM_ENTITY, DisplayBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.CABLE_BLOCK_ENTITY, Cable_Block_Entity_Renderer::new);

        // --- Render Layers ---
        BlockRenderLayerMap.INSTANCE.putBlock(ENBYVAMPY_PLUSHIE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PLUSHIE_CRAFTING_BENCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DISPLAY_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DISPLAY_PLATFORM, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(CABLE_BLOCK, RenderLayer.getCutout());

        // --- 🔑 Register your Cable Block model layer ---
        EntityModelLayerRegistry.registerModelLayer(CABLE_BLOCK_LAYER, Cable_Block_Model::getTexturedModelData);

    }
}

package com.projektdeus.enbysmod;

import com.projektdeus.enbysmod.block.block_renderers.Cable_Block_Entity_Renderer;
import com.projektdeus.enbysmod.block.block_models.Cable_Block_Model;
import com.projektdeus.enbysmod.block.block_renderers.Display_Block_Entity_Renderer;
import com.projektdeus.enbysmod.race.models.OniHornModel;
//import com.projektdeus.enbysmod.races.models.renderer.OniHornRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
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
        BlockEntityRendererFactories.register(ModBlockEntities.DISPLAY_BLOCK_ENTITY, Display_Block_Entity_Renderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.DISPLAY_CASE_ENTITY, Display_Block_Entity_Renderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.DISPLAY_PLATFORM_ENTITY, Display_Block_Entity_Renderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.CABLE_BLOCK_ENTITY, Cable_Block_Entity_Renderer::new);

        // --- Model Layer Registration ---

        EntityModelLayerRegistry.registerModelLayer(CABLE_BLOCK_LAYER, Cable_Block_Model::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(OniHornModel.LAYER, OniHornModel::getTexturedModelData);

        // --- Render Layers ---
        BlockRenderLayerMap.INSTANCE.putBlock(ENBYVAMPY_PLUSHIE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PLUSHIE_CRAFTING_BENCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DISPLAY_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DISPLAY_PLATFORM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CABLE_BLOCK, RenderLayer.getCutout());



    }
}

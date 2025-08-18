package com.projektdeus.enbysmod.block.render;

import com.projektdeus.enbysmod.EnbysMod;
import com.projektdeus.enbysmod.block.entity.client.Cable_Block_Entity_Renderer;
import com.projektdeus.enbysmod.block.entity.client.model.Cable_Block_Model;
import com.projektdeus.enbysmod.registry.ModBlockEntities;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

@Environment(EnvType.CLIENT)
public class ModBlockEntityRenderers {
    public static void register() {
        EnbysMod.LOGGER.info("Registering renderers for Displays...");
        BlockEntityRendererFactories.register(ModBlockEntities.CABLE_BLOCK_ENTITY, Cable_Block_Entity_Renderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.DISPLAY_BLOCK_ENTITY, DisplayBlockEntityRenderer::new);
    }
}
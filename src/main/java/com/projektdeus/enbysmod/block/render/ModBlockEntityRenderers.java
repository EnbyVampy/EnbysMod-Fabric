package com.projektdeus.enbysmod.block.render;

import com.projektdeus.enbysmod.EnbysMod;
import com.projektdeus.enbysmod.registry.ModBlockEntities;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

@Environment(EnvType.CLIENT)
public class ModBlockEntityRenderers {
    public static void register() {
        EnbysMod.LOGGER.info("Registering renderers for Displays...");
        BlockEntityRendererFactories.register(ModBlockEntities.DISPLAY_BLOCK_ENTITY, DisplayBlockEntityRenderer::new);
    }
}
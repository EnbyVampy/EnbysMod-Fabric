package com.projektdeus.enbysmod.block.entity.client;

import com.projektdeus.enbysmod.EnbysModClient;
import com.projektdeus.enbysmod.block.Cable_Block;
import com.projektdeus.enbysmod.block.entity.Cable_Block_Entity;
import com.projektdeus.enbysmod.block.entity.client.model.Cable_Block_Model;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class Cable_Block_Entity_Renderer implements BlockEntityRenderer<Cable_Block_Entity> {
    private final Cable_Block_Model model;
//    private static final Identifier MODEL_LAYER_ID = Identifier.of("enbysmod", "cable_block_layer");

    public Cable_Block_Entity_Renderer(BlockEntityRendererFactory.Context ctx) {
        this.model = new Cable_Block_Model(ctx.getLayerModelPart(EnbysModClient.CABLE_BLOCK_LAYER));
    }

    Identifier TEXTURE = Identifier.of("enbysmod", "textures/block/cable_block.png");
    @Override
    public void render(Cable_Block_Entity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState state = entity.getCachedState();

        // Core always visible
        model.getCableCore().visible = true;

        // Toggle model parts visibility based on the block state
        model.getConnectorUp().visible = state.get(Cable_Block.CONNECTOR_UP);
        model.getCableUp().visible = state.get(Cable_Block.CABLE_UP);

        model.getConnectorDown().visible = state.get(Cable_Block.CONNECTOR_DOWN);
        model.getCableDown().visible = state.get(Cable_Block.CABLE_DOWN);

        model.getConnectorNorth().visible = state.get(Cable_Block.CONNECTOR_NORTH);
        model.getCableNorth().visible = state.get(Cable_Block.CABLE_NORTH);

        model.getConnectorSouth().visible = state.get(Cable_Block.CONNECTOR_SOUTH);
        model.getCableSouth().visible = state.get(Cable_Block.CABLE_SOUTH);

        model.getConnectorEast().visible = state.get(Cable_Block.CONNECTOR_EAST);
        model.getCableEast().visible = state.get(Cable_Block.CABLE_EAST);

        model.getConnectorWest().visible = state.get(Cable_Block.CONNECTOR_WEST);
        model.getCableWest().visible = state.get(Cable_Block.CABLE_WEST);

        // --- PUSH MATRIX ---
        matrices.push();
        // Move the model to the center of the block (0.5, 0.5, 0.5)
        matrices.translate(0.5, -0.5, 0.5);

        VertexConsumer buffer = vertexConsumers.getBuffer(RenderLayer.getEntityCutout(TEXTURE));
        model.render(matrices, buffer, light, overlay);

        // --- POP MATRIX ---
        matrices.pop();
    }
}
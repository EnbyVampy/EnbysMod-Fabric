package com.projektdeus.enbysmod.block.block_renderers;

import com.projektdeus.enbysmod.block.block_entities.GenericDisplayBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Colors;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;

@SuppressWarnings({"IntegerDivisionInFloatingPointContext", "DataFlowIssue"})
public class Display_Block_Entity_Renderer implements BlockEntityRenderer<GenericDisplayBlockEntity>{

    private final TextRenderer textRenderer;
    protected final BlockEntityRenderDispatcher dispatcher;

    public Display_Block_Entity_Renderer(BlockEntityRendererFactory.Context ctx) {
        this.textRenderer = ctx.getTextRenderer();
        this.dispatcher = ctx.getRenderDispatcher();
    }

    //TODO: LOOK INTO ADDING TRANSPARENT BLACK BACKGROUND FOR TEXT
    protected boolean isLookingAtItem(GenericDisplayBlockEntity entity) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return false;
        Vec3d eyePos = client.player.getCameraPosVec(1.0f); // Player's eye position.
        Vec3d lookVec = client.player.getRotationVec(1.0f); // Where the player is looking.
        BlockPos pos = entity.getPos();
        Box itemBox = new Box(pos).offset(0.0, 1.1, 0.0).expand(0.03, 0.1, 0.03);
        double maxDistance = 5.0;
        Vec3d endPos = eyePos.add(lookVec.x * maxDistance, lookVec.y * maxDistance, lookVec.z * maxDistance);
        try {
            return itemBox.raycast(eyePos, endPos).isPresent();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean shouldRenderName(ItemStack stack, GenericDisplayBlockEntity entity) {
        return (!stack.isEmpty() && isLookingAtItem(entity) && MinecraftClient.isHudEnabled());
    }
    public TextRenderer getTextRenderer(){
        return this.textRenderer;
    }
    protected int getItemRarityColor(ItemStack stack){
        switch (stack.getRarity()) {
            case COMMON -> {return Colors.WHITE;}
            case UNCOMMON -> {return  Colors.YELLOW;}
            case RARE -> {return 0x54FCFC;}
            case EPIC -> {return 0xEA55E8;}
            default -> {return Colors.WHITE;}
        }
    }
    @Override
    public void render(GenericDisplayBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemStack stack = entity.getStoredItem();

        if (!stack.isEmpty()) {
            matrices.push();
            matrices.translate(0.5, 0.25, 0.5); // X, Y, Z center of the block
            float rotation = (System.currentTimeMillis() / 20) % 360; // Smooth rotation
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
            matrices.scale(1.0f, 1.0f, 1.0f); // Reduce item size for better fit
            ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
            itemRenderer.renderItem(stack, ModelTransformationMode.GROUND, light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
            matrices.pop();
        } else {
            ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
            itemRenderer.renderItem(ItemStack.EMPTY, ModelTransformationMode.GROUND,
                    light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
        }
    }
}
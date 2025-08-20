//package com.projektdeus.enbysmod.races.models.renderer;
//
//import com.projektdeus.enbysmod.races.RaceComponent;
//import com.projektdeus.enbysmod.races.Races;
//import com.projektdeus.enbysmod.races.models.OniHornModel;
//import net.minecraft.client.render.OverlayTexture;
//import net.minecraft.client.render.RenderLayer;
//import net.minecraft.client.render.VertexConsumer;
//import net.minecraft.client.render.entity.PlayerEntityRenderer;
//import net.minecraft.client.render.entity.feature.FeatureRenderer;
//import net.minecraft.client.render.entity.model.PlayerEntityModel;
//import net.minecraft.client.render.VertexConsumerProvider;
//import net.minecraft.client.util.math.MatrixStack;
//import net.minecraft.client.network.ClientPlayerEntity;
//import net.minecraft.util.Identifier;
//
//public class OniHornRenderer extends FeatureRenderer<ClientPlayerEntity, PlayerEntityModel<ClientPlayerEntity>> {
//    private static final Identifier TEXTURE = Identifier.of("enbysmod", "textures/entity/oni_single_horn.png");
//    private final OniHornModel hornModel;
//
//    public OniHornRenderer(PlayerEntityRenderer context) {
//        super(context);
//        this.hornModel = new OniHornModel(context.getModel().getLayer(OniHornModel.LAYER.getId()));
//    }
//
//
//    @Override
//    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
//                       ClientPlayerEntity player, float limbAngle, float limbDistance,
//                       float tickDelta, float animationProgress, float headYaw, float headPitch) {
//
//        if (RaceComponent.get(player).getRace() != Races.ONI_SINGLE) return;
//
//        matrices.push();
//
//        // Align with head
//        this.getContextModel().getHead().rotate(matrices);
//
//        // Move horn slightly upward
//        matrices.translate(0.0, -0.25, 0.0);
//
//        VertexConsumer vc = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(TEXTURE));
//        this.hornModel.render(matrices, vc, light, OverlayTexture.DEFAULT_UV);
//
//        matrices.pop();
//    }
//}

package com.projektdeus.enbysmod.race.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class OniHornModel extends EntityModel<Entity> {
    public static final EntityModelLayer LAYER = new EntityModelLayer(
            Identifier.of("enbysmod", "oni_single_horn"), "main"
    );

    private final ModelPart oni_single_horn_m;

    public OniHornModel(ModelPart root) {
        this.oni_single_horn_m = root.getChild("oni_single_horn_m");
    }


    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        ModelPartData oni_single_horn_m = root.addChild(
                "oni_single_horn_m",
                ModelPartBuilder.create(),
                ModelTransform.of(0.0F, -5.0F, -4.0F, -0.5236F, 0.0F, 0.0F)
        );

        oni_single_horn_m.addChild(
                "cube_r1",
                ModelPartBuilder.create()
                        .uv(0, 0)
                        .cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)),
                ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F)
        );

        return TexturedModelData.of(modelData, 16, 16);
    }

    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        // Not animated
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer,
                       int light, int overlay, int color) {
        oni_single_horn_m.render(matrices, vertexConsumer, light, overlay, color);
    }
}

package com.projektdeus.enbysmod.block.block_models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

public class Cable_Block_Model {
    private final ModelPart cable_root;
    private final ModelPart cable_core;
    private final ModelPart cable_north;
    private final ModelPart cable_south;
    private final ModelPart cable_east;
    private final ModelPart cable_west;
    private final ModelPart cable_up;
    private final ModelPart cable_down;
    private final ModelPart connector_north;
    private final ModelPart connector_south;
    private final ModelPart connector_east;
    private final ModelPart connector_west;
    private final ModelPart connector_up;
    private final ModelPart connector_down;

    public Cable_Block_Model(ModelPart root) {
        this.cable_root = root.getChild("cable_root");
        this.cable_core = this.cable_root.getChild("cable_core");
        this.cable_north = this.cable_root.getChild("cable_north");
        this.cable_south = this.cable_root.getChild("cable_south");
        this.cable_east = this.cable_root.getChild("cable_east");
        this.cable_west = this.cable_root.getChild("cable_west");
        this.cable_up = this.cable_root.getChild("cable_up");
        this.cable_down = this.cable_root.getChild("cable_down");
        this.connector_north = this.cable_root.getChild("connector_north");
        this.connector_south = this.cable_root.getChild("connector_south");
        this.connector_east = this.cable_root.getChild("connector_east");
        this.connector_west = this.cable_root.getChild("connector_west");
        this.connector_up = this.cable_root.getChild("connector_up");
        this.connector_down = this.cable_root.getChild("connector_down");
    }

    public static TexturedModelData getTexturedModelData() {		ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData cable_root = modelPartData.addChild("cable_root", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 11.0F, 0.0F));

        ModelPartData cable_core = cable_root.addChild("cable_core",
                ModelPartBuilder.create().uv(0, 9).cuboid(-4.0F, 2.0F, -3.0F, 6.0F, 6.0F, 6.0F,
                        new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));


        ModelPartData cable_north = cable_root.addChild("cable_north",
                ModelPartBuilder.create().uv(18, 4).cuboid(4.0F, -4.0F, -8.0F, 4.0F, 4.0F, 5.0F,
                        new Dilation(0.0F)), ModelTransform.pivot(-7.0F, 7.0F, 0.0F));
        ModelPartData cable_south = cable_root.addChild("cable_south",
                ModelPartBuilder.create().uv(18, 4).cuboid(4.0F, -4.0F, -8.0F, 4.0F, 4.0F, 5.0F,
                        new Dilation(0.0F)), ModelTransform.pivot(-7.0F, 7.0F, 11.0F));
        ModelPartData cable_east = cable_root.addChild("cable_east",
                ModelPartBuilder.create().uv(24, 13).cuboid(3.0F, -4.0F, -8.0F, 5.0F, 4.0F, 4.0F,
                        new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 7.0F, 6.0F));
        ModelPartData cable_west = cable_root.addChild("cable_west",
                ModelPartBuilder.create().uv(24, 13).cuboid(3.0F, -4.0F, -8.0F, 5.0F, 4.0F, 4.0F,
                        new Dilation(0.0F)), ModelTransform.pivot(-12.0F, 7.0F, 6.0F));
        ModelPartData cable_up = cable_root.addChild("cable_up",
                ModelPartBuilder.create().uv(4, 0).cuboid(4.0F, -5.0F, -8.0F, 4.0F, 5.0F, 4.0F,
                        new Dilation(0.0F)), ModelTransform.pivot(-7.0F, 13.0F, 6.0F));
        ModelPartData cable_down = cable_root.addChild("cable_down",
                ModelPartBuilder.create().uv(4, 0).cuboid(4.0F, -5.0F, -8.0F, 4.0F, 5.0F, 4.0F,
                        new Dilation(0.0F)), ModelTransform.pivot(-7.0F, 2.0F, 6.0F));

        ModelPartData connector_north = cable_root.addChild("connector_north",
                ModelPartBuilder.create().uv(14, 31).cuboid(-2.0F, -10.0F, -8.0F, 10.0F, 10.0F, 2.0F,
                        new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 10.0F, 0.0F));

        ModelPartData connector_south = cable_root.addChild("connector_south",
                ModelPartBuilder.create().uv(14, 31).cuboid(-2.0F, -10.0F, -8.0F, 10.0F, 10.0F, 2.0F,
                        new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 10.0F, 14.0F));

        ModelPartData connector_east = cable_root.addChild("connector_east",
                ModelPartBuilder.create().uv(2, 33).cuboid(6.0F, -10.0F, -8.0F, 2.0F, 10.0F, 10.0F,
                        new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 10.0F, 3.0F));

        ModelPartData connector_west = cable_root.addChild("connector_west",
                ModelPartBuilder.create().uv(2, 33).cuboid(6.0F, -10.0F, -8.0F, 2.0F, 10.0F, 10.0F,
                        new Dilation(0.0F)), ModelTransform.pivot(-15.0F, 10.0F, 3.0F));

        ModelPartData connector_up = cable_root.addChild("connector_up",
                ModelPartBuilder.create().uv(6, 21).cuboid(-2.0F, -2.0F, -8.0F, 10.0F, 2.0F, 10.0F,
                        new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 13.0F, 3.0F));

        ModelPartData connector_down = cable_root.addChild("connector_down",
                ModelPartBuilder.create()
                        .uv(6, 21).cuboid(-2.0F, -2.0F, -8.0F, 10.0F, 2.0F, 10.0F,
                                new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -1.0F, 3.0F)
        );



        return TexturedModelData.of(modelData, 64, 64);
    }

    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay) {
        cable_root.render(matrices, vertexConsumer, light, overlay);
    }

    // you can keep your getters, they’re useful in the renderer
    public ModelPart getCableCore() { return cable_core; }
    public ModelPart getConnectorNorth() { return connector_north; }
    public ModelPart getConnectorSouth() { return connector_south; }
    public ModelPart getConnectorEast() { return connector_east; }
    public ModelPart getConnectorWest() { return connector_west; }
    public ModelPart getConnectorUp() { return connector_up; }
    public ModelPart getConnectorDown() { return connector_down; }
    public ModelPart getCableNorth() { return cable_north; }
    public ModelPart getCableSouth() { return cable_south; }
    public ModelPart getCableEast() { return cable_east; }
    public ModelPart getCableWest() { return cable_west; }
    public ModelPart getCableUp() { return cable_up; }
    public ModelPart getCableDown() { return cable_down; }
}

package com.projektdeus.enbysmod.registry;

import com.projektdeus.enbysmod.block.custom.plushies.Enbyvampy_Plushie;
import com.projektdeus.enbysmod.block.entity.Cable_Block_Entity;
import com.projektdeus.enbysmod.block.entity.GenericDisplayBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static BlockEntityType<GenericDisplayBlockEntity> DISPLAY_BLOCK_ENTITY;
    public static BlockEntityType<GenericDisplayBlockEntity> DISPLAY_CASE_ENTITY;
    public static BlockEntityType<GenericDisplayBlockEntity> DISPLAY_PLATFORM_ENTITY;
    public static BlockEntityType<Cable_Block_Entity> CABLE_BLOCK_ENTITY;

    public static void registerAllBlockEntities() {
        DISPLAY_BLOCK_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                Identifier.of("enbysmod", "display_block_entity"),
                BlockEntityType.Builder.create((pos, state) -> new GenericDisplayBlockEntity(DISPLAY_BLOCK_ENTITY, pos, state), ModBlocks.DISPLAY_BLOCK).build(null)
        );

        DISPLAY_CASE_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                Identifier.of("enbysmod", "display_case_entity"),
                BlockEntityType.Builder.create((pos, state) -> new GenericDisplayBlockEntity(DISPLAY_CASE_ENTITY, pos, state), ModBlocks.DISPLAY_CASE).build(null)
        );

        DISPLAY_PLATFORM_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                Identifier.of("enbysmod", "display_platform_entity"),
                BlockEntityType.Builder.create((pos, state) -> new GenericDisplayBlockEntity(DISPLAY_PLATFORM_ENTITY, pos, state), ModBlocks.DISPLAY_PLATFORM).build(null)
        );
        CABLE_BLOCK_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                Identifier.of("enbysmod","cable_block_entity"),
                BlockEntityType.Builder.create((pos,state) -> new Cable_Block_Entity(CABLE_BLOCK_ENTITY, pos, state), ModBlocks.CABLE_BLOCK).build(null)
        );


        

    }

}
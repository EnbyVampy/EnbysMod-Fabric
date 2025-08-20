package com.projektdeus.enbysmod.registry;

import com.projektdeus.enbysmod.EnbysMod;
import com.projektdeus.enbysmod.block.custom_blocks.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static com.projektdeus.enbysmod.EnbysMod.MOD_ID;

public class ModBlocks {

    //Plushies
    public static final Block ENBYVAMPY_PLUSHIE = registerBlock("enbyvampy_plushie",
            new Enbyvampy_Plushie(AbstractBlock.Settings.create()
            .strength(1.0f).sounds(BlockSoundGroup.WOOL).nonOpaque()));

    //Entity Blocks
    public static final Block PLUSHIE_CRAFTING_BENCH = registerBlock("plushie_crafting_bench",new Plushie_Crafting_Bench(AbstractBlock.Settings.create()
            .strength(1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque()));

    //Display Blocks
    public static final Block DISPLAY_BLOCK = registerBlock("display_block", new DisplayBlock(AbstractBlock.Settings.create()
            .strength(3.5f).requiresTool().sounds(BlockSoundGroup.STONE).nonOpaque()));
    public static final Block DISPLAY_CASE = registerBlock("display_case", new DisplayCase(AbstractBlock.Settings.create()
            .strength(3.5f).requiresTool().sounds(BlockSoundGroup.STONE).nonOpaque()));
    public static final Block DISPLAY_PLATFORM = registerBlock("display_platform", new DisplayPlatform(AbstractBlock.Settings.create()
            .strength(3.5f).requiresTool().sounds(BlockSoundGroup.STONE).nonOpaque()));
    public static final Block CABLE_BLOCK = registerBlock("cable_block", new Cable_Block(AbstractBlock.Settings.create()
            .strength(1.0f).sounds(BlockSoundGroup.WOOL).nonOpaque()));
    public static final Block DIRECTION_BLOCK = registerBlock("direction_block", new Direction_Block(AbstractBlock.Settings.create()
            .strength(3.5f)));

    public static final Block CUSTOM_BLOCK = registerBlock("custom_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE)
            .mapColor(MapColor.RED) // Sets the color for maps (e.g., Redstone color)
            .strength(4.0f, 6.0f) // Sets hardness (dig time) and resistance (explosion resistance)
            .sounds(BlockSoundGroup.STONE) // Sets the sounds the block makes (walk, break, place etc.)
            .requiresTool() // Requires the correct tool to break at normal speed
            .luminance(state -> 5) // Emits light level 5
            .burnable())); // Can be burned by fire



    //Helper Methods to register blocks and block items
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, Identifier.of(MOD_ID,name),block);
    }
    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID,name),new BlockItem(block,new Item.Settings()));
    }
    public static void registerModBlocks() {
        EnbysMod.LOGGER.info("Registering Blocks for EnbysMod");
    }

}

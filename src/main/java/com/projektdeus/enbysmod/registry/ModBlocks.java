package com.projektdeus.enbysmod.registry;

import com.projektdeus.enbysmod.EnbysMod;
import com.projektdeus.enbysmod.block.Cable_Block;
import com.projektdeus.enbysmod.block.custom.*;
import com.projektdeus.enbysmod.block.custom.display_blocks.DisplayBlock;
import com.projektdeus.enbysmod.block.custom.display_blocks.DisplayCase;
import com.projektdeus.enbysmod.block.custom.display_blocks.DisplayPlatform;
import com.projektdeus.enbysmod.block.custom.plushies.DaiPanda_Plushie;
import com.projektdeus.enbysmod.block.custom.plushies.Enbyvampy_Plushie;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    //Plushies
    public static final Block ENBYVAMPY_PLUSHIE = registerBlock("enbyvampy_plushie", new Enbyvampy_Plushie(AbstractBlock.Settings.create()
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



    //Helper Methods to register blocks and block items
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, Identifier.of(EnbysMod.MOD_ID,name),block);
    }
    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(EnbysMod.MOD_ID,name),new BlockItem(block,new Item.Settings()));
    }
    public static void registerModBlocks() {
        EnbysMod.LOGGER.info("Registering Blocks for EnbysMod");
    }

}

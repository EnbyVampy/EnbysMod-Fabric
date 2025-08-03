package com.projektdeus.enbysmod.registry;

import com.projektdeus.enbysmod.EnbysMod;
import com.projektdeus.enbysmod.block.custom.Display_Block;
import com.projektdeus.enbysmod.block.custom.Plushie_Crafting_Bench;
import com.projektdeus.enbysmod.block.custom.Enbyvampy_Plushie;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    //Icon Blocks
    public static final Block ENBY_MOD_BLOCK_ICON = registerBlock("enby_mod_block_icon",new Block(AbstractBlock.Settings.create()));

    //Plushies
    public static final Block ENBYVAMPY_PLUSHIE = registerBlock("enbyvampy_plushie", new Enbyvampy_Plushie(AbstractBlock.Settings.create()
                .strength(1.0f).sounds(BlockSoundGroup.WOOL).nonOpaque()));
    public static final Block DAIPANDA_PLUSHIE = registerBlock("daipanda_plushie", new Enbyvampy_Plushie(AbstractBlock.Settings.create()
            .strength(1.0f).sounds(BlockSoundGroup.WOOL).nonOpaque()));

    //Entity Blocks
    public static final Block PLUSHIE_CRAFTING_BENCH = registerBlock("plushie_crafting_bench",new Plushie_Crafting_Bench(AbstractBlock.Settings.create()
            .strength(1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque()));

    //Blocks
    public static final Block COPPER_COIN_BLOCK = registerBlock("copper_coin_block",new Block(AbstractBlock.Settings.create()
            .strength(5.0f).requiresTool().sounds(BlockSoundGroup.METAL)    ));
    public static final Block IRON_COIN_BLOCK = registerBlock("iron_coin_block",new Block(AbstractBlock.Settings.create()
            .strength(5.0f).requiresTool().sounds(BlockSoundGroup.METAL)    ));
    public static final Block GOLD_COIN_BLOCK = registerBlock("gold_coin_block",new Block(AbstractBlock.Settings.create()
            .strength(5.0f).requiresTool().sounds(BlockSoundGroup.METAL)    ));
    public static final Block DIAMOND_COIN_BLOCK = registerBlock("diamond_coin_block",new Block(AbstractBlock.Settings.create()
            .strength(5.0f).requiresTool().sounds(BlockSoundGroup.METAL)    ));
    public static final Block EMERALD_COIN_BLOCK = registerBlock("emerald_coin_block",new Block(AbstractBlock.Settings.create()
            .strength(5.0f).requiresTool().sounds(BlockSoundGroup.METAL)    ));
    public static final Block NETHERITE_COIN_BLOCK = registerBlock("netherite_coin_block",new Block(AbstractBlock.Settings.create()
            .strength(5.0f).requiresTool().sounds(BlockSoundGroup.METAL)    ));
    public static final Block MOONSTONE_ORE_BLOCK = registerBlock("moonstone_ore_block",new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.create()
            .strength(3.0f).requiresTool().sounds(BlockSoundGroup.STONE)    ));

    //Display Blocks
    public static final Block DISPLAY_BLOCK = registerBlock("display_block", new Display_Block(AbstractBlock.Settings.create()
            .strength(3.5f).requiresTool().sounds(BlockSoundGroup.STONE).nonOpaque()));
    public static final Block DISPLAY_CASE = registerBlock("display_case", new Display_Block(AbstractBlock.Settings.create()
            .strength(3.5f).requiresTool().sounds(BlockSoundGroup.STONE).nonOpaque()));
    public static final Block DISPLAY_PLATFORM = registerBlock("display_platform", new Display_Block(AbstractBlock.Settings.create()
            .strength(3.5f).requiresTool().sounds(BlockSoundGroup.STONE).nonOpaque()));

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

//          already registered these to custom creative tab keeping for future reference
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(ENBY_COIN_BLOCK));
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(COPPER_COIN_BLOCK));
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(IRON_COIN_BLOCK));
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(GOLD_COIN_BLOCK));
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(DIAMOND_COIN_BLOCK));
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(EMERALD_COIN_BLOCK));
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(NETHERITE_COIN_BLOCK));

    }

}

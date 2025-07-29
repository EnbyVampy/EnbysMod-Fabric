package com.projektdeus.enbysmod.block;

import com.projektdeus.enbysmod.EnbysMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block ENBY_MOD_BLOCK_ICON = registerBlock("enby_mod_block_icon",new Block(AbstractBlock.Settings.create()));

    public static final Block COPPER_COIN_BLOCK = registerBlock("copper_coin_block",new Block(AbstractBlock.Settings.create()
            .strength(5.0f).requiresTool().sounds(BlockSoundGroup.ANVIL)    ));
    public static final Block IRON_COIN_BLOCK = registerBlock("iron_coin_block",new Block(AbstractBlock.Settings.create()
            .strength(5.0f).requiresTool().sounds(BlockSoundGroup.ANVIL)    ));
    public static final Block GOLD_COIN_BLOCK = registerBlock("gold_coin_block",new Block(AbstractBlock.Settings.create()
            .strength(5.0f).requiresTool().sounds(BlockSoundGroup.ANVIL)    ));
    public static final Block DIAMOND_COIN_BLOCK = registerBlock("diamond_coin_block",new Block(AbstractBlock.Settings.create()
            .strength(5.0f).requiresTool().sounds(BlockSoundGroup.ANVIL)    ));
    public static final Block EMERALD_COIN_BLOCK = registerBlock("emerald_coin_block",new Block(AbstractBlock.Settings.create()
            .strength(5.0f).requiresTool().sounds(BlockSoundGroup.ANVIL)    ));
    public static final Block NETHERITE_COIN_BLOCK = registerBlock("netherite_coin_block",new Block(AbstractBlock.Settings.create()
            .strength(5.0f).requiresTool().sounds(BlockSoundGroup.ANVIL)    ));

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

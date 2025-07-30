package com.projektdeus.enbysmod.item;

import com.projektdeus.enbysmod.EnbysMod;
import com.projektdeus.enbysmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ENBYS_MOD_ITEMS_TAB = Registry.register(Registries.ITEM_GROUP, Identifier.of(EnbysMod.MOD_ID,"enbys_mod_items_tab"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.ENBYVAMPY_PLUSHIE))
                    .displayName(Text.translatable("itemGroup.enbysmod.tabs.items"))
                    .entries((displayContext, entries) -> entries.add(ModBlocks.ENBYVAMPY_PLUSHIE))
                    .build());
    public static final ItemGroup ENBYS_MOD_CURRENCY_TAB = Registry.register(Registries.ITEM_GROUP, Identifier.of(EnbysMod.MOD_ID,"enbys_mod_currency_tab"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ENBY_MOD_ICON))
                    .displayName(Text.translatable("itemGroup.enbysmod.tabs.currency"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.COPPER_COIN);
                        entries.add(ModItems.IRON_COIN);
                        entries.add(ModItems.GOLD_COIN);
                        entries.add(ModItems.DIAMOND_COIN);
                        entries.add(ModItems.EMERALD_COIN);
                        entries.add(ModItems.NETHERITE_COIN);
                    })
                    .build());
    public static final ItemGroup ENBYS_MOD_BLOCKS_TAB = Registry.register(Registries.ITEM_GROUP, Identifier.of(EnbysMod.MOD_ID,"enbys_mod_blocks_tab"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.ENBY_MOD_BLOCK_ICON))
                    .displayName(Text.translatable("itemGroup.enbysmod.tabs.blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.COPPER_COIN_BLOCK);
                        entries.add(ModBlocks.IRON_COIN_BLOCK);
                        entries.add(ModBlocks.GOLD_COIN_BLOCK);
                        entries.add(ModBlocks.DIAMOND_COIN_BLOCK);
                        entries.add(ModBlocks.EMERALD_COIN_BLOCK);
                        entries.add(ModBlocks.NETHERITE_COIN_BLOCK);
                    })
                    .build());
    public static final ItemGroup ENBYS_MOD_CUSTOM_RECIPES_TAB = Registry.register(Registries.ITEM_GROUP, Identifier.of(EnbysMod.MOD_ID,"enbys_mod_custom_recipes_tab"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ENBY_MOD_CUSTOM_RECIPES_ICON))
                    .displayName(Text.translatable("itemGroup.enbysmod.tabs.custom"))
                    .entries((displayContext, entries) -> {
                        entries.add(Items.SADDLE);
                        entries.add(Items.NAME_TAG);
                        entries.add(Items.IRON_HORSE_ARMOR);
                        entries.add(Items.GOLDEN_HORSE_ARMOR);
                        entries.add(Items.DIAMOND_HORSE_ARMOR);
                    })
                    .build());

    public static void registerItemGroups() {
//        EnbysMod.LOGGER.info("Registering ItemGroups for EnbysMod\nItemGroup for Enbys Mod Items:{}\nItemGroup for Enbys Mod Currency: {}\nItemGroup for Enbys Mod Blocks: {}\nItemGroup for Enbys Mod Custom Recipes: {}", ENBYS_MOD_ITEMS_TAB.toString(), ENBYS_MOD_CURRENCY_TAB.toString(), ENBYS_MOD_BLOCKS_TAB.toString(), ENBYS_MOD_CUSTOM_RECIPES_TAB.toString());
          }
}

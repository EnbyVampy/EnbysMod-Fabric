package com.projektdeus.enbysmod.registry;

import com.projektdeus.enbysmod.EnbysMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ENBYS_MOD_CURRENCY_TAB = Registry.register(Registries.ITEM_GROUP, Identifier.of(EnbysMod.MOD_ID,"enbys_mod_currency_tab"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.WALLET_ITEM))
                    .displayName(Text.translatable("itemGroup.enbysmod.tabs.currency"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ONE_CENT_COIN);
                        entries.add(ModItems.FIVE_CENT_COIN);
                        entries.add(ModItems.TEN_CENT_COIN);
                        entries.add(ModItems.TWENTYFIVE_CENT_COIN);
                        entries.add(ModItems.FIFTY_CENT_COIN);
                        entries.add(ModItems.HUNDRED_CENT_COIN);
                        entries.add(ModItems.ONE_DOLLAR_BILL);
                        entries.add(ModItems.TWO_DOLLAR_BILL);
                        entries.add(ModItems.FIVE_DOLLAR_BILL);
                        entries.add(ModItems.TEN_DOLLAR_BILL);
                        entries.add(ModItems.TWENTY_DOLLAR_BILL);
                        entries.add(ModItems.FIFTY_DOLLAR_BILL);
                        entries.add(ModItems.HUNDRED_DOLLAR_BILL);
                    })
                    .build());
    public static final ItemGroup ENBYS_MOD_BLOCKS_TAB = Registry.register(Registries.ITEM_GROUP, Identifier.of(EnbysMod.MOD_ID,"enbys_mod_blocks_tab"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.DISPLAY_CASE))
                    .displayName(Text.translatable("itemGroup.enbysmod.tabs.blocks"))
                    .entries((displayContext, entries) -> {
                    //entries.add(ModBlocks.DAIPANDA_PLUSHIE);
                    entries.add(ModBlocks.ENBYVAMPY_PLUSHIE);
                    entries.add(ModBlocks.PLUSHIE_CRAFTING_BENCH);
                    entries.add(ModBlocks.DISPLAY_BLOCK);
                    entries.add(ModBlocks.DISPLAY_CASE);
                    entries.add(ModBlocks.DISPLAY_PLATFORM);

                    })
                    .build());


    public static void registerItemGroups() {
        EnbysMod.LOGGER.info("Registering ItemGroups for EnbysMod");
          }
}

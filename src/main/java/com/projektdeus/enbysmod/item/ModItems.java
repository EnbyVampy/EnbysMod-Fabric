package com.projektdeus.enbysmod.item;

import com.projektdeus.enbysmod.EnbysMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ENBY_MOD_ICON = registerItem("enby_mod_icon",new Item(new Item.Settings()));
    public static final Item ENBY_MOD_CUSTOM_RECIPES_ICON = registerItem("enby_mod_custom_recipes_icon",new Item(new Item.Settings()));

    public static final Item COPPER_COIN = registerItem("copper_coin",new Item(new Item.Settings()));
    public static final Item IRON_COIN = registerItem("iron_coin",new Item(new Item.Settings()));
    public static final Item GOLD_COIN = registerItem("gold_coin",new Item(new Item.Settings()));
    public static final Item DIAMOND_COIN = registerItem("diamond_coin",new Item(new Item.Settings()));
    public static final Item EMERALD_COIN = registerItem("emerald_coin",new Item(new Item.Settings()));
    public static final Item NETHERITE_COIN = registerItem("netherite_coin",new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(EnbysMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EnbysMod.LOGGER.info("Registering Items for EnbysMod");
//          already registered these to custom creative tab keeping for future reference
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(ENBY_COIN));
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(COPPER_COIN));
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(IRON_COIN));
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(GOLD_COIN));
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(DIAMOND_COIN));
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(EMERALD_COIN));
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(NETHERITE_COIN));

    }
}

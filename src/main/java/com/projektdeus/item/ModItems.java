package com.projektdeus.item;

import com.projektdeus.EnbysMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
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
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(COPPER_COIN));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(IRON_COIN));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(GOLD_COIN));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(DIAMOND_COIN));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(EMERALD_COIN));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(NETHERITE_COIN));

    }
}

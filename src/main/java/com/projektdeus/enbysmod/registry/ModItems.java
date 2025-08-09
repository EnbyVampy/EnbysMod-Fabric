package com.projektdeus.enbysmod.registry;

import com.projektdeus.enbysmod.EnbysMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BLOCK_ICON              = registerItem("block_icon",                      new Item(new Item.Settings()));
    public static final Item WALLET_ITEM             = registerItem("currency/wallet_item",            new Item(new Item.Settings()));

    //COINS AND BILLS
    public static final Item ONE_CENT_COIN           = registerItem("currency/one_cent_coin",          new Item(new Item.Settings()));
    public static final Item FIVE_CENT_COIN          = registerItem("currency/five_cent_coin",         new Item(new Item.Settings()));
    public static final Item TEN_CENT_COIN           = registerItem("currency/ten_cent_coin",          new Item(new Item.Settings()));
    public static final Item TWENTYFIVE_CENT_COIN    = registerItem("currency/twentyfive_cent_coin",   new Item(new Item.Settings()));
    public static final Item FIFTY_CENT_COIN         = registerItem("currency/fifty_cent_coin",        new Item(new Item.Settings()));
    public static final Item HUNDRED_CENT_COIN       = registerItem("currency/hundred_cent_coin",      new Item(new Item.Settings()));
    public static final Item ONE_DOLLAR_BILL         = registerItem("currency/one_dollar_bill",        new Item(new Item.Settings()));
    public static final Item TWO_DOLLAR_BILL         = registerItem("currency/two_dollar_bill",        new Item(new Item.Settings()));
    public static final Item FIVE_DOLLAR_BILL        = registerItem("currency/five_dollar_bill",       new Item(new Item.Settings()));
    public static final Item TEN_DOLLAR_BILL         = registerItem("currency/ten_dollar_bill",        new Item(new Item.Settings()));
    public static final Item TWENTY_DOLLAR_BILL      = registerItem("currency/twenty_dollar_bill",     new Item(new Item.Settings()));
    public static final Item FIFTY_DOLLAR_BILL       = registerItem("currency/fifty_dollar_bill",      new Item(new Item.Settings()));
    public static final Item HUNDRED_DOLLAR_BILL     = registerItem("currency/hundred_dollar_bill",    new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(EnbysMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EnbysMod.LOGGER.info("Registering Items for EnbysMod");
    }
}

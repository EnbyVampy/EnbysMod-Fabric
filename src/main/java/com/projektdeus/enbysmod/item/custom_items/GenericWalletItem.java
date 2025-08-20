package com.projektdeus.enbysmod.item.custom_items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GenericWalletItem extends Item {
    public GenericWalletItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient) {
            player.sendMessage(Text.literal("Generic wallet used! (GUI opening not implemented yet)"), false);
            // TODO: Open GUI here later
        }

        return TypedActionResult.success(stack);
    }
}

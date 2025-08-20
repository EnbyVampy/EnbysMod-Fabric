package com.projektdeus.enbysmod.block.custom_blocks;

import com.mojang.serialization.MapCodec;
import com.projektdeus.enbysmod.EnbysMod;
import com.projektdeus.enbysmod.registry.ModBlocks;
import com.projektdeus.enbysmod.block.block_entities.GenericDisplayBlockEntity;
import com.projektdeus.enbysmod.registry.ModBlockEntities;
//import com.projektdeus.enbysmod.block.entity.TickableBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.Optional;

public class GenericDisplayBlock extends Block implements BlockEntityProvider{

    public GenericDisplayBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        if (this == ModBlocks.DISPLAY_BLOCK) {
            return new GenericDisplayBlockEntity(ModBlockEntities.DISPLAY_BLOCK_ENTITY, pos, state);
        } else if (this == ModBlocks.DISPLAY_CASE) {
            return new GenericDisplayBlockEntity(ModBlockEntities.DISPLAY_CASE_ENTITY, pos, state);
        } else if (this == ModBlocks.DISPLAY_PLATFORM){
            return new GenericDisplayBlockEntity(ModBlockEntities.DISPLAY_PLATFORM_ENTITY, pos, state);
        }
        return null;
    }

    public SoundEvent getAddItemSound() {
        return SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM;
    }
    public SoundEvent getRemoveItemSound() {
        return SoundEvents.ENTITY_ITEM_FRAME_REMOVE_ITEM;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        BlockPos aboveBlock = pos.up();

        if (!world.getBlockState(aboveBlock).isAir()) {
            return ActionResult.FAIL;
        }

        if (blockEntity instanceof GenericDisplayBlockEntity displayBlockEntity) {
            ItemStack playerHeldItem = player.getStackInHand(Hand.MAIN_HAND);
            ItemStack storedItem = displayBlockEntity.getStoredItem();

            // Handle placing an item in the display
            if (storedItem.isEmpty()) {
                if (!playerHeldItem.isEmpty()) {
                    // Double-check if the player's held item can be split
                    ItemStack insertedItem = playerHeldItem.split(1);
                    if (!insertedItem.isEmpty()) {
                        displayBlockEntity.setStoredItem(insertedItem);
                        world.playSound(null, pos, getAddItemSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);

                        // Ensure the player's inventory is properly updated
                        player.setStackInHand(Hand.MAIN_HAND, playerHeldItem);
                        return ActionResult.SUCCESS;
                    }
                }
                return ActionResult.PASS; // No item in hand
            } else {
                // Handle removing an item from the display
                if (!player.getInventory().insertStack(storedItem)) {
                    // If inventory is full, spawn the item as an entity
                    ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY() + 1, pos.getZ(), storedItem);
                    world.spawnEntity(itemEntity);
                } else {
                    // Successfully added the item to the player's inventory
                    world.playSound(null, pos, getRemoveItemSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                // Clear the display block's item
                displayBlockEntity.setStoredItem(ItemStack.EMPTY);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }


    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);

        if (blockEntity instanceof GenericDisplayBlockEntity displayBlockEntity) {
            ItemStack storedItem = displayBlockEntity.getStoredItem();

            if (!storedItem.isEmpty()) {
                // Manually drop the stored item
                ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY()+1, pos.getZ(), storedItem);
                world.spawnEntity(itemEntity);  // Spawn the item in the world
                displayBlockEntity.setStoredItem(ItemStack.EMPTY);  // Clear the stored item after dropping
            }
        }
        return super.onBreak(world, pos, state, player); // Call the superclass method for standard block breaking behavior
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type){
        return world.isClient ? null : (w, p, s, be) -> {
            if (be instanceof GenericDisplayBlockEntity displayBe) {
                displayBe.tick();
            }
        };
    }

    public static final Model DISPLAY_MODEL = block("parent_display", TextureKey.ALL);

    public static final Model DISPLAY_MODEL_MORE = block("parent_display_more", TextureKey.SIDE, TextureKey.TOP);

    private static Model block(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.of(EnbysMod.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    public static TextureMap displayMap(Block block) {
        return new TextureMap()
                .put(TextureKey.ALL, ModelIds.getBlockSubModelId(block, ""));

    }

    public static TextureMap displayMapWood(Block block) {
        return new TextureMap()
                .put(TextureKey.SIDE, ModelIds.getBlockSubModelId(block, ""))
                .put(TextureKey.TOP, ModelIds.getBlockSubModelId(block, "_top"));
    }

}
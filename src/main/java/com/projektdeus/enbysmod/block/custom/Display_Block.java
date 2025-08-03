package com.projektdeus.enbysmod.block.custom;

import com.mojang.serialization.MapCodec;
import com.projektdeus.enbysmod.EnbysMod;
import com.projektdeus.enbysmod.registry.ModBlocks;
import com.projektdeus.enbysmod.block.entity.DisplayBlockEntity;
import com.projektdeus.enbysmod.block.entity.ModBlockEntities;
import com.projektdeus.enbysmod.block.entity.TickableBlockEntity;
import com.projektdeus.enbysmod.criteria.ModCriteria;
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
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class Display_Block extends Block implements BlockEntityProvider{
    public Display_Block(Settings settings) {
        super(settings);
    }

    private static final VoxelShape FRAME = Block.createCuboidShape(1.0,1.0,1.0,15.0,15.0,15.0);
    private static final VoxelShape BOTTOM = Block.createCuboidShape(0.0,0.0,0.0,16.0,1.0,16.0);
    private static final VoxelShape TOP = Block.createCuboidShape(0.0,15.0,0.0,16.0,16.0,16.0);

    public static final VoxelShape FULL_SHAPE = VoxelShapes.union(FRAME, BOTTOM, TOP);

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return FULL_SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return FULL_SHAPE;
    }


    public SoundEvent getAddItemSound() {
        return SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM;
    }
    public SoundEvent getRemoveItemSound() {
        return SoundEvents.ENTITY_ITEM_FRAME_REMOVE_ITEM;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        if (this == ModBlocks.DISPLAY_BLOCK) {
            return new DisplayBlockEntity(ModBlockEntities.DISPLAY_BLOCK_ENTITY, pos, state);
        } else if (this == ModBlocks.DISPLAY_CASE) {
            return new DisplayBlockEntity(ModBlockEntities.DISPLAY_CASE_ENTITY, pos, state);
        } else if (this == ModBlocks.DISPLAY_PLATFORM){
            return new DisplayBlockEntity(ModBlockEntities.DISPLAY_PLATFORM_ENTITY, pos, state);
        }
        return null;
    }

    @Override
    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof DisplayBlockEntity displayBlockEntity){
            switch (displayBlockEntity.getStoredItem().getRarity()) {
                case COMMON -> {
                    return 0;
                }
                case UNCOMMON -> {
                    return 5;
                }
                case RARE -> {
                    return 10;
                }
                case EPIC -> {
                    return 15;
                }
            }
        }
        return 0;
    }

    @Override
    protected int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        BlockEntity blockEntity = world.getBlockEntity(pos);

        if (blockEntity instanceof DisplayBlockEntity displayBlockEntity
                && direction == Direction.UP && displayBlockEntity.getStoredItem().getRarity() == Rarity.EPIC){
            return 15;
        }

        return 0;

    }

    @Override
    protected int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return getStrongRedstonePower(state, world, pos, direction);
    }

    @Override
    protected boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        BlockPos aboveBlock = pos.up();

        if (!world.getBlockState(aboveBlock).isAir()){
            return ActionResult.FAIL;
        }

        if (blockEntity instanceof DisplayBlockEntity displayBlockEntity) {
            ItemStack playerHeldItem = player.getStackInHand(Hand.MAIN_HAND);
            ItemStack storedItem = displayBlockEntity.getStoredItem();
            ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY()+1, pos.getZ(), storedItem);

            if (storedItem.isEmpty() ) {

                displayBlockEntity.setStoredItem(playerHeldItem.split(1));

                world.playSound(null, pos, getAddItemSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);

                if (displayBlockEntity.getStoredItem().getRarity()== Rarity.EPIC
                        && player instanceof ServerPlayerEntity serverPlayer){

                    ModCriteria.PLACE_EPIC_ITEM_ON_DISPLAY.trigger(serverPlayer);

                }

//                if (displayBlockEntity.getStoredItem().isIn(ModItemTagProvider.DISPLAY_BLOCK_ITEMS)
//                        && player instanceof ServerPlayerEntity serverPlayer){
//
//                    ModCriteria.PLACE_DISPLAY_ON_DISPLAY.trigger(serverPlayer);
//
//                }

                return ActionResult.SUCCESS; // Return success as we stored the item
            } else
                // If display has an item, give it back to the player and clear the display's item
                world.spawnEntity(itemEntity);
            world.playSound(null, pos, getRemoveItemSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
            displayBlockEntity.setStoredItem(ItemStack.EMPTY); // Remove the item from the display
            return ActionResult.SUCCESS; // Return success as we gave the item back
        }
        return ActionResult.PASS;
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);

        if (blockEntity instanceof DisplayBlockEntity displayBlockEntity) {
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
        return TickableBlockEntity.getTicker(world);
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
package com.projektdeus.enbysmod.block.custom_blocks;

import com.projektdeus.enbysmod.block.block_entities.Cable_Block_Entity;
import com.projektdeus.enbysmod.registry.ModBlockEntities;
import com.projektdeus.enbysmod.registry.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class Cable_Block extends Block implements BlockEntityProvider {

    // Call the superclass method for standard block entity creation
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new Cable_Block_Entity(ModBlockEntities.CABLE_BLOCK_ENTITY, pos, state);

    }
    // Add all connectors and cables to the state manager
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CONNECTOR_UP, CONNECTOR_DOWN, CONNECTOR_NORTH, CONNECTOR_SOUTH, CONNECTOR_EAST, CONNECTOR_WEST,
                CABLE_UP, CABLE_DOWN, CABLE_NORTH, CABLE_SOUTH, CABLE_EAST, CABLE_WEST);
    }



    // Connectors and Cables
    public static final BooleanProperty CONNECTOR_UP = BooleanProperty.of("connector_up");
    public static final BooleanProperty CONNECTOR_DOWN = BooleanProperty.of("connector_down");
    public static final BooleanProperty CONNECTOR_NORTH = BooleanProperty.of("connector_north");
    public static final BooleanProperty CONNECTOR_SOUTH = BooleanProperty.of("connector_south");
    public static final BooleanProperty CONNECTOR_EAST = BooleanProperty.of("connector_east");
    public static final BooleanProperty CONNECTOR_WEST = BooleanProperty.of("connector_west");
    public static final BooleanProperty CABLE_UP = BooleanProperty.of("cable_up");
    public static final BooleanProperty CABLE_DOWN = BooleanProperty.of("cable_down");
    public static final BooleanProperty CABLE_NORTH = BooleanProperty.of("cable_north");
    public static final BooleanProperty CABLE_SOUTH = BooleanProperty.of("cable_south");
    public static final BooleanProperty CABLE_EAST = BooleanProperty.of("cable_east");
    public static final BooleanProperty CABLE_WEST = BooleanProperty.of("cable_west");


    public Cable_Block(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                //sets default state to all false, so that the block is not connected to anything
                .with(CONNECTOR_UP, false)
                .with(CONNECTOR_DOWN, false)
                .with(CONNECTOR_NORTH, false)
                .with(CONNECTOR_SOUTH, false)
                .with(CONNECTOR_EAST, false)
                .with(CONNECTOR_WEST, false)
                .with(CABLE_UP, false)
                .with(CABLE_DOWN, false)
                .with(CABLE_NORTH, false)
                .with(CABLE_SOUTH, false)
                .with(CABLE_EAST, false)
                .with(CABLE_WEST, false));
    }


    private BooleanProperty getConnectorProperty(Direction dir) {
        return switch (dir) {
            case UP -> CONNECTOR_UP;
            case DOWN -> CONNECTOR_DOWN;
            case NORTH -> CONNECTOR_NORTH;
            case SOUTH -> CONNECTOR_SOUTH;
            case EAST -> CONNECTOR_EAST;
            case WEST -> CONNECTOR_WEST;
        };
    }
    private BooleanProperty getCableProperty(Direction dir) {
        return switch (dir) {
            case UP -> CABLE_UP;
            case DOWN -> CABLE_DOWN;
            case NORTH -> CABLE_NORTH;
            case SOUTH -> CABLE_SOUTH;
            case EAST -> CABLE_EAST;
            case WEST -> CABLE_WEST;
        };
    }
    // Override to set initial state when the block is placed
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getConnectionState(ctx.getWorld(), ctx.getBlockPos(), getDefaultState());
    }

    // Called when a neighboring block changes (placed, removed, etc.)
    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
        if (!world.isClient) {
            BlockState newState = getConnectionState(world, pos, state);
            if (!newState.equals(state)) {
                world.setBlockState(pos, newState, Block.NOTIFY_ALL);
            }
        }
    }

    // Compute the connection state based on neighboring blocks
    private BlockState getConnectionState(World world, BlockPos pos, BlockState state) {
        for (Direction dir : Direction.values()) {
            BlockPos neighborPos = pos.offset(dir);
            BlockState neighborState = world.getBlockState(neighborPos);


            // Check if we should connect with a cable (to another Cable_Block)
            boolean connectCable = neighborState.isOf(this);

            // Check if we should connect with a connector (to a connectable block, but not another cable)
            boolean connectConnector = !connectCable && neighborState.isIn(ModTags.Blocks.CABLE_CONNECTABLE);

            // Set the cable property based on the direction from the neighbor (opposite direction)
            state = state.with(getCableProperty(dir), connectCable);
            state = state.with(getConnectorProperty(dir), connectConnector);
        }
        return state;
    }






}
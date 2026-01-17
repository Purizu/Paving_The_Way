package com.butteredapples.ptw.contents.blocks;

import com.butteredapples.ptw.contents.utils.RakeBlockEnum;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

@SuppressWarnings("deprecation")
public class RakeBlock extends Block {
    public final Block replacementBlock;
    public boolean isGravityBlock;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 15.0, 16.0);
    public static final EnumProperty<RakeBlockEnum> RAKE_PROPERTY = EnumProperty.of("rake_direction", RakeBlockEnum.class);

    public RakeBlock(Settings settings, Block replacementBlock, boolean isGravityBlock) {
        super(settings);
        this.replacementBlock = replacementBlock;
        this.isGravityBlock = isGravityBlock;
        setDefaultState(getDefaultState().with(RAKE_PROPERTY, RakeBlockEnum.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(RAKE_PROPERTY);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState state1, WorldAccess worldAccess, BlockPos pos, BlockPos pos1) {
        if (direction == Direction.UP && !state.canPlaceAt(worldAccess, pos)) {
            worldAccess.scheduleBlockTick(pos, this, 1);
        }
        if (this.isGravityBlock && FallingBlock.canFallThrough(worldAccess.getBlockState(pos.down()))) {
            worldAccess.scheduleBlockTick(pos, this, 1);
        }
        return super.getStateForNeighborUpdate(state, direction, state1, worldAccess, pos, pos1);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return !this.getDefaultState().canPlaceAt(ctx.getWorld(), ctx.getBlockPos()) ? Block.pushEntitiesUpBeforeBlockChange(this.getDefaultState(), replacementBlock.getDefaultState(), ctx.getWorld(), ctx.getBlockPos()) : super.getPlacementState(ctx);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        turnToBlock(null, state, world, pos);
    }

    public void turnToBlock(Entity entity, BlockState state, World world, BlockPos pPos) {
        BlockState blockstate = pushEntitiesUpBeforeBlockChange(state, replacementBlock.getDefaultState(), world, pPos);
        world.setBlockState(pPos, blockstate);
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Emitter.of(entity, blockstate));
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos.up());
        return !blockState.isSolid() || blockState.getBlock() instanceof FenceGateBlock;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}

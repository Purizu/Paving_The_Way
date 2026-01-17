package com.butteredapples.ptw.contents.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;

public class BetterDirtPathBlock extends DirtPathBlock {
    public final Block replacementBlock;
    public boolean isGravityBlock;

    public BetterDirtPathBlock(Settings settings, Block replacementBlock, boolean isGravityBlock) {
        super(settings);
        this.replacementBlock = replacementBlock;
        this.isGravityBlock = isGravityBlock;
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
}

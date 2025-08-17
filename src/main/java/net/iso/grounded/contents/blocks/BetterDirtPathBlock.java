package net.iso.grounded.contents.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirtPathBlock;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;

public class BetterDirtPathBlock extends DirtPathBlock {
    public final Block replacementBlock;
    public boolean isGravityBlock;

    public BetterDirtPathBlock(Properties p_153129_, Block replacementBlock, boolean isGravityBlock) {
        super(p_153129_);
        this.replacementBlock = replacementBlock;
        this.isGravityBlock = isGravityBlock;
    }

    private boolean IfFalling(LevelAccessor worldIn, BlockPos currentPos) {
        if (!isGravityBlock)
            return false;

        return isAir(worldIn.getBlockState(currentPos.below())) || FallingBlock.isFree(worldIn.getBlockState(currentPos.below())) && currentPos.getY() >= -64;
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_153131_) {
        return !this.defaultBlockState().canSurvive(p_153131_.getLevel(), p_153131_.getClickedPos()) ? Block.pushEntitiesUp(this.defaultBlockState(), replacementBlock.defaultBlockState(), p_153131_.getLevel(), p_153131_.getClickedPos()) : super.getStateForPlacement(p_153131_);
    }

    public BlockState updateShape(BlockState p_153152_, Direction p_153153_, BlockState p_153154_, LevelAccessor p_153155_, BlockPos p_153156_, BlockPos p_153157_) {
        if (p_153153_ == Direction.UP && !p_153152_.canSurvive(p_153155_, p_153156_)) {
            p_153155_.scheduleTick(p_153156_, this, 1);
        }
        if (IfFalling(p_153155_, p_153156_)) {
            p_153155_.scheduleTick(p_153156_, this, 1);
        }
        return super.updateShape(p_153152_, p_153153_, p_153154_, p_153155_, p_153156_, p_153157_);
    }

    @Override
    public void tick(BlockState p_221070_, ServerLevel p_221071_, BlockPos p_221072_, RandomSource p_221073_) {
        turnToBlock(null, p_221070_, p_221071_, p_221072_);
    }

    public void turnToBlock(@Nullable Entity entity, BlockState state, Level level, BlockPos pPos) {
        BlockState blockstate = pushEntitiesUp(state, replacementBlock.defaultBlockState(), level, pPos);
        level.setBlockAndUpdate(pPos, blockstate);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(entity, blockstate));
    }

}

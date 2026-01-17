package com.butteredapples.ptw.contents.events;

import com.butteredapples.ptw.contents.blocks.PtwBlocks;
import com.butteredapples.ptw.contents.blocks.RakeBlock;
import com.butteredapples.ptw.contents.utils.RakeBlockEnum;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.Blocks;

import java.util.HashMap;
import java.util.Map;

public class RakingEvents {

    public static final Map<Block, Block> RAKEABLE = new HashMap<>();

    static {
        RAKEABLE.put(Blocks.SAND, PtwBlocks.RAKED_SAND);
        RAKEABLE.put(Blocks.RED_SAND, PtwBlocks.RAKED_RED_SAND);
        RAKEABLE.put(Blocks.SOUL_SAND, PtwBlocks.RAKED_SOUL_SAND);
        RAKEABLE.put(Blocks.GRAVEL, PtwBlocks.RAKED_GRAVEL);
    }

    public static void registerEvents() {

        UseBlockCallback.EVENT.register((player, world, hand, hit) -> {

            BlockPos pos = hit.getBlockPos();
            BlockState state = world.getBlockState(pos);
            ItemStack stack = player.getStackInHand(hand);

            if (!stack.isIn(ItemTags.HOES) || player.isSpectator()) return ActionResult.PASS;

            Block rakedVariant = RAKEABLE.get(state.getBlock());
            if (rakedVariant == null) return ActionResult.PASS;

            ItemUsageContext ctx = new ItemUsageContext(player, hand, hit);
            ItemPlacementContext placeCtx = new ItemPlacementContext(player, hand, stack, hit);
            if (ctx.getSide() == Direction.DOWN) return ActionResult.PASS;
            if (!(world.isAir(pos.up()) || world.getBlockState(pos.up()).canReplace(placeCtx))) return ActionResult.PASS;
            if (world.isClient) return ActionResult.SUCCESS;

            boolean north = world.getBlockState(pos.north()).isOf(rakedVariant);
            boolean south = world.getBlockState(pos.south()).isOf(rakedVariant);
            boolean east  = world.getBlockState(pos.east()).isOf(rakedVariant);
            boolean west  = world.getBlockState(pos.west()).isOf(rakedVariant);

            BlockState newState = rakedVariant.getDefaultState();

            if (north && south && east && west) {
                newState = newState.with(RakeBlock.RAKE_PROPERTY, RakeBlockEnum.CENTRE);
            }

            //Yes I know that corners are funky just go with it. If it works it works, don't fix it. :P
            else if (north && east) {
                newState = newState.with(RakeBlock.RAKE_PROPERTY, RakeBlockEnum.SOUTHWEST);
            }
            else if (north && west) {
                newState = newState.with(RakeBlock.RAKE_PROPERTY, RakeBlockEnum.SOUTHEAST);
            }
            else if (south && east) {
                newState = newState.with(RakeBlock.RAKE_PROPERTY, RakeBlockEnum.NORTHWEST);
            }
            else if (south && west) {
                newState = newState.with(RakeBlock.RAKE_PROPERTY, RakeBlockEnum.NORTHEAST);
            }

            else if (north) {
                newState = newState.with(RakeBlock.RAKE_PROPERTY, RakeBlockEnum.SOUTH);
            }
            else if (south) {
                newState = newState.with(RakeBlock.RAKE_PROPERTY, RakeBlockEnum.NORTH);
            }
            else if (east) {
                newState = newState.with(RakeBlock.RAKE_PROPERTY, RakeBlockEnum.WEST);
            }
            else if (west) {
                newState = newState.with(RakeBlock.RAKE_PROPERTY, RakeBlockEnum.EAST);
            }
            else {
                Direction f = player.getHorizontalFacing();
                newState = newState.with(RakeBlock.RAKE_PROPERTY, RakeBlockEnum.fromDirection(f));
            }
            world.setBlockState(pos, newState);
            world.playSound(null, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1f, 1f);
            stack.damage(1, player, p -> p.sendToolBreakStatus(hand));

            return ActionResult.SUCCESS;
        });
    }
}

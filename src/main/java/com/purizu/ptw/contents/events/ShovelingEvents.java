package com.purizu.ptw.contents.events;

import com.purizu.ptw.contents.blocks.PtwBlocks;
import com.purizu.ptw.contents.utils.PtwTags;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.HashMap;

import static com.purizu.ptw.contents.blocks.PtwBlocks.*;
import static net.minecraft.block.Blocks.*;

public class ShovelingEvents {

    public static final HashMap<Block, SoundEvent> FLATTENING_SOUNDS = new HashMap<>();
    public static final HashMap<Block, Block> EXTRA_SHOVELING = new HashMap<>();
    public static final HashMap<Block, Block> EXTRA_SHOVELING_PICKAXE = new HashMap<>();

    static {
        FLATTENING_SOUNDS.put(SAND, SoundEvents.BLOCK_SAND_FALL);
        FLATTENING_SOUNDS.put(RED_SAND, SoundEvents.BLOCK_SAND_FALL);
        FLATTENING_SOUNDS.put(GRAVEL, SoundEvents.BLOCK_GRAVEL_FALL);
        FLATTENING_SOUNDS.put(MUD, SoundEvents.BLOCK_MUD_FALL);
        FLATTENING_SOUNDS.put(CRIMSON_NYLIUM, SoundEvents.BLOCK_NYLIUM_FALL);
        FLATTENING_SOUNDS.put(WARPED_NYLIUM, SoundEvents.BLOCK_NYLIUM_FALL);
        FLATTENING_SOUNDS.put(SOUL_SAND, SoundEvents.BLOCK_SOUL_SAND_FALL);
        FLATTENING_SOUNDS.put(SOUL_SOIL, SoundEvents.BLOCK_SOUL_SOIL_FALL);
        FLATTENING_SOUNDS.put(NETHERRACK, SoundEvents.BLOCK_NETHERRACK_FALL);

        EXTRA_SHOVELING.put(DIRT, SHAVED_DIRT_PATH);
        EXTRA_SHOVELING.put(COARSE_DIRT, COARSE_DIRT_PATH);
        EXTRA_SHOVELING.put(MYCELIUM, MYCELIUM_PATH);
        EXTRA_SHOVELING.put(PODZOL, PODZOL_PATH);
        EXTRA_SHOVELING.put(MUD, MUD_PATH);
        EXTRA_SHOVELING.put(SAND, SAND_PATH);
        EXTRA_SHOVELING.put(RED_SAND, RED_SAND_PATH);
        EXTRA_SHOVELING.put(GRAVEL, GRAVEL_PATH);
        EXTRA_SHOVELING.put(CRIMSON_NYLIUM, CRIMSON_NYLIUM_PATH);
        EXTRA_SHOVELING.put(WARPED_NYLIUM, WARPED_NYLIUM_PATH);
        EXTRA_SHOVELING.put(SOUL_SAND, SOUL_SAND_PATH);
        EXTRA_SHOVELING.put(SOUL_SOIL, SOUL_SOIL_PATH);

        EXTRA_SHOVELING_PICKAXE.put(NETHERRACK, NETHERRACK_PATH);
    }

    public static void registerEvents() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {

            BlockPos targetPos = hitResult.getBlockPos();
            BlockState targetBlock = world.getBlockState(targetPos);
            ItemStack stack = player.getStackInHand(hand);
            ItemUsageContext context = new ItemUsageContext(player, hand, hitResult);
            ItemPlacementContext context1 = new ItemPlacementContext(player, hand, stack, hitResult);

            if (stack.isIn(ItemTags.SHOVELS) && !player.isSpectator() && context.getSide() != Direction.DOWN && (world.isAir(targetPos.up()) || world.getBlockState(targetPos.up()).canReplace(context1)) && targetBlock.isIn(PtwTags.Blocks.PATHABLE_BLOCKS)) {
                SoundEvent sound = FLATTENING_SOUNDS.getOrDefault(targetBlock.getBlock(), SoundEvents.ITEM_SHOVEL_FLATTEN);
                world.playSound(player, targetPos, sound, SoundCategory.BLOCKS, 1, 1);
                if (player instanceof ServerPlayerEntity){
                    if (!player.isCreative()) stack.damage(1, player, p -> p.sendToolBreakStatus(context.getHand()));
                    world.setBlockState(targetPos, EXTRA_SHOVELING.get(targetBlock.getBlock()).getStateWithProperties(targetBlock));
                }
                return ActionResult.SUCCESS;
            }
            if (stack.isIn(ItemTags.PICKAXES) && !player.isSpectator() && context.getSide() != Direction.DOWN && (world.isAir(targetPos.up()) || world.getBlockState(targetPos.up()).canReplace(context1)) && targetBlock.isIn(PtwTags.Blocks.PATHABLE_BLOCKS_PICKAXE)) {
                SoundEvent sound = FLATTENING_SOUNDS.getOrDefault(targetBlock.getBlock(), SoundEvents.ITEM_SHOVEL_FLATTEN);
                world.playSound(player, targetPos, sound, SoundCategory.BLOCKS, 1, 1);
                if (player instanceof ServerPlayerEntity){
                    if (!player.isCreative()) stack.damage(1, player, p -> p.sendToolBreakStatus(context.getHand()));
                    world.setBlockState(targetPos, EXTRA_SHOVELING_PICKAXE.get(targetBlock.getBlock()).getStateWithProperties(targetBlock));
                }
                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;
        });
    }
}

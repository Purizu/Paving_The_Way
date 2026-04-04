package com.butteredapples.ptw.contents.events;

import com.google.common.collect.ImmutableMap;
import com.butteredapples.ptw.PavingTheWay;
import com.butteredapples.ptw.contents.blocks.PtwBlocks;
import com.butteredapples.ptw.contents.utils.PtwTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = PavingTheWay.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ShovelingEvents {

    public static final HashMap<Block, SoundEvent> FLATTENING_SOUNDS = new HashMap<>();

    static {
        FLATTENING_SOUNDS.put(Blocks.SAND, SoundEvents.SAND_FALL);
        FLATTENING_SOUNDS.put(Blocks.RED_SAND, SoundEvents.SAND_FALL);
        FLATTENING_SOUNDS.put(Blocks.GRAVEL, SoundEvents.GRAVEL_FALL);
        FLATTENING_SOUNDS.put(Blocks.MUD, SoundEvents.MUD_FALL);
        FLATTENING_SOUNDS.put(Blocks.CRIMSON_NYLIUM, SoundEvents.NYLIUM_FALL);
        FLATTENING_SOUNDS.put(Blocks.WARPED_NYLIUM, SoundEvents.NYLIUM_FALL);
        FLATTENING_SOUNDS.put(Blocks.SOUL_SAND, SoundEvents.SOUL_SAND_FALL);
        FLATTENING_SOUNDS.put(Blocks.SOUL_SOIL, SoundEvents.SOUL_SOIL_FALL);
        FLATTENING_SOUNDS.put(Blocks.NETHERRACK, SoundEvents.NETHERRACK_FALL);
        FLATTENING_SOUNDS.put(Blocks.ROOTED_DIRT, SoundEvents.ROOTED_DIRT_FALL);
        FLATTENING_SOUNDS.put(Blocks.SNOW_BLOCK, SoundEvents.SNOW_FALL);
        FLATTENING_SOUNDS.put(Blocks.PACKED_MUD, SoundEvents.PACKED_MUD_FALL);
    }

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        Player player = event.getEntity();
        ItemStack stack = event.getItemStack();

        //Snowy dirt paths
        if (stack.is(ItemTags.SHOVELS) && !player.isSpectator() && event.getFace() != Direction.DOWN && (level.isEmptyBlock(pos.above())
                || level.getBlockState(pos.above()).canBeReplaced()) && state.is(Blocks.SNOW) && level.getBlockState(pos.below()).is(PtwTags.Blocks.SNOW_DIRT_PATH_VALID)) {
            level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1, 1);
            level.playSound(player, pos, SoundEvents.SNOW_FALL, SoundSource.BLOCKS, 1, 1);
            if (!level.isClientSide) {
                stack.hurtAndBreak(1, player, player1 -> player1.broadcastBreakEvent(event.getHand()));
                level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                level.setBlockAndUpdate(pos.below(), PtwBlocks.SNOWY_DIRT_PATH.get().defaultBlockState());
            }
            event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
            event.setCanceled(true);
        }

        //Everything else
        if (stack.is(ItemTags.SHOVELS) && !player.isSpectator() && event.getFace() != Direction.DOWN && (level.isEmptyBlock(pos.above()) || level.getBlockState(pos.above()).canBeReplaced()) && state.is(PtwTags.Blocks.PATHABLE_BLOCKS)) {
            SoundEvent sound = FLATTENING_SOUNDS.getOrDefault(state.getBlock(), SoundEvents.SHOVEL_FLATTEN);
            level.playSound(player, pos, sound, SoundSource.BLOCKS, 1, 1);
            if (!level.isClientSide) {
                stack.hurtAndBreak(1, player, player1 -> player1.broadcastBreakEvent(event.getHand()));
                BlockState pathState = ImmutableMap.ofEntries(Map.entry(
                        Blocks.GRASS_BLOCK, Blocks.DIRT_PATH.defaultBlockState().getBlockHolder()),
                        Map.entry(Blocks.DIRT, PtwBlocks.SHAVED_DIRT_PATH),
                        Map.entry(Blocks.COARSE_DIRT, PtwBlocks.COARSE_DIRT_PATH),
                        Map.entry(Blocks.MYCELIUM, PtwBlocks.MYCELIUM_PATH),
                        Map.entry(Blocks.PODZOL, PtwBlocks.PODZOL_PATH),
                        Map.entry(Blocks.MUD, PtwBlocks.MUD_PATH),
                        Map.entry(Blocks.SAND, PtwBlocks.SAND_PATH),
                        Map.entry(Blocks.RED_SAND, PtwBlocks.RED_SAND_PATH),
                        Map.entry(Blocks.GRAVEL, PtwBlocks.GRAVEL_PATH),
                        Map.entry(Blocks.CRIMSON_NYLIUM, PtwBlocks.CRIMSON_NYLIUM_PATH),
                        Map.entry(Blocks.WARPED_NYLIUM, PtwBlocks.WARPED_NYLIUM_PATH),
                        Map.entry(Blocks.SOUL_SAND, PtwBlocks.SOUL_SAND_PATH),
                        Map.entry(Blocks.SOUL_SOIL, PtwBlocks.SOUL_SOIL_PATH),
                        Map.entry(Blocks.ROOTED_DIRT, PtwBlocks.ROOTED_DIRT_PATH),
                        Map.entry(Blocks.SNOW_BLOCK, PtwBlocks.SNOW_PATH),
                        Map.entry(Blocks.PACKED_MUD, PtwBlocks.PACKED_MUD_PATH))
                        .get(state.getBlock()).get().defaultBlockState(); level.setBlockAndUpdate(pos, pathState);
            }
            event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
            event.setCanceled(true);
        }
        if (stack.is(ItemTags.PICKAXES) && !player.isSpectator() && event.getFace() != Direction.DOWN && (level.isEmptyBlock(pos.above()) || level.getBlockState(pos.above()).canBeReplaced()) && state.is(PtwTags.Blocks.PATHABLE_BLOCKS_PICKAXE)) {
            SoundEvent sound = FLATTENING_SOUNDS.getOrDefault(state.getBlock(), SoundEvents.SHOVEL_FLATTEN);
            level.playSound(player, pos, sound, SoundSource.BLOCKS, 1, 1);
            if (!level.isClientSide) {
                stack.hurtAndBreak(1, player, player1 -> player1.broadcastBreakEvent(event.getHand()));
                BlockState pathState = ImmutableMap.ofEntries(Map.entry(Blocks.NETHERRACK, PtwBlocks.NETHERRACK_PATH)).get(state.getBlock()).get().defaultBlockState(); level.setBlockAndUpdate(pos, pathState);
            }
            event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
            event.setCanceled(true);
        }
    }
}

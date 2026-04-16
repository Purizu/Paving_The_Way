package com.butteredapples.ptw.contents.events;

import com.butteredapples.ptw.contents.utils.PtwTags;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableMap;
import com.butteredapples.ptw.PavingTheWay;
import com.butteredapples.ptw.contents.blocks.PtwBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;

import static net.minecraft.world.level.block.Blocks.*;

@Mod.EventBusSubscriber(modid = PavingTheWay.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ShovelingEvents {

    public static final HashMap<Block, SoundEvent> FLATTENING_SOUNDS = new HashMap<>();
    public static final Supplier<ImmutableMap<Block, Block>> EXTRA_SHOVELING = Suppliers.memoize(() ->{
        ImmutableMap.Builder<Block, Block> builder = ImmutableMap.builder();
        builder.put(DIRT, PtwBlocks.SHAVED_DIRT_PATH.get());
        builder.put(COARSE_DIRT, PtwBlocks.COARSE_DIRT_PATH.get());
        builder.put(MYCELIUM, PtwBlocks.MYCELIUM_PATH.get());
        builder.put(PODZOL, PtwBlocks.PODZOL_PATH.get());
        builder.put(MUD, PtwBlocks.MUD_PATH.get());
        builder.put(SAND, PtwBlocks.SAND_PATH.get());
        builder.put(RED_SAND, PtwBlocks.RED_SAND_PATH.get());
        builder.put(GRAVEL, PtwBlocks.GRAVEL_PATH.get());
        builder.put(CRIMSON_NYLIUM, PtwBlocks.CRIMSON_NYLIUM_PATH.get());
        builder.put(WARPED_NYLIUM, PtwBlocks.WARPED_NYLIUM_PATH.get());
        builder.put(SOUL_SAND, PtwBlocks.SOUL_SAND_PATH.get());
        builder.put(SOUL_SOIL, PtwBlocks.SOUL_SOIL_PATH.get());
        builder.put(ROOTED_DIRT, PtwBlocks.ROOTED_DIRT_PATH.get());
        builder.put(SNOW_BLOCK, PtwBlocks.SNOW_PATH.get());
        return builder.build();
    });
    public static final Supplier<ImmutableMap<Block, Block>> EXTRA_SHOVELING_PICKAXE = Suppliers.memoize(() ->{
        ImmutableMap.Builder<Block, Block> builder = ImmutableMap.builder();
        builder.put(NETHERRACK, PtwBlocks.NETHERRACK_PATH.get());
        return builder.build();
    });

    static {
        FLATTENING_SOUNDS.put(SAND, SoundEvents.SAND_FALL);
        FLATTENING_SOUNDS.put(RED_SAND, SoundEvents.SAND_FALL);
        FLATTENING_SOUNDS.put(GRAVEL, SoundEvents.GRAVEL_FALL);
        FLATTENING_SOUNDS.put(MUD, SoundEvents.MUD_FALL);
        FLATTENING_SOUNDS.put(CRIMSON_NYLIUM, SoundEvents.NYLIUM_FALL);
        FLATTENING_SOUNDS.put(WARPED_NYLIUM, SoundEvents.NYLIUM_FALL);
        FLATTENING_SOUNDS.put(SOUL_SAND, SoundEvents.SOUL_SAND_FALL);
        FLATTENING_SOUNDS.put(SOUL_SOIL, SoundEvents.SOUL_SOIL_FALL);
        FLATTENING_SOUNDS.put(NETHERRACK, SoundEvents.NETHERRACK_FALL);
        FLATTENING_SOUNDS.put(ROOTED_DIRT, SoundEvents.ROOTED_DIRT_FALL);
        FLATTENING_SOUNDS.put(SNOW_BLOCK, SoundEvents.SNOW_FALL);
        FLATTENING_SOUNDS.put(PACKED_MUD, SoundEvents.PACKED_MUD_PLACE);
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
                || level.getBlockState(pos.above()).canBeReplaced()) && state.is(SNOW) && level.getBlockState(pos.below()).is(PtwTags.Blocks.SNOW_DIRT_PATH_VALID)) {
            level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1, 1);
            level.playSound(player, pos, SoundEvents.SNOW_FALL, SoundSource.BLOCKS, 1, 1);
            if (!level.isClientSide) {
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(event.getHand()));
                level.setBlockAndUpdate(pos, AIR.defaultBlockState());
                level.setBlockAndUpdate(pos.below(), PtwBlocks.SNOWY_DIRT_PATH.get().defaultBlockState());
            }
            event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
            event.setCanceled(true);
        }

        //Everything else
        if (stack.is(ItemTags.SHOVELS) && state.is(PtwTags.Blocks.PATHABLE_BLOCKS) && !player.isSpectator() && event.getFace() != Direction.DOWN && (level.isEmptyBlock(pos.above()) || level.getBlockState(pos.above()).canBeReplaced())) {
            SoundEvent sound = FLATTENING_SOUNDS.getOrDefault(state.getBlock(), SoundEvents.SHOVEL_FLATTEN);
            level.playSound(player, pos, sound, SoundSource.BLOCKS, 1, 1);
            if (!level.isClientSide) {
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(event.getHand()));
                level.setBlockAndUpdate(pos, EXTRA_SHOVELING.get().get(state.getBlock()).withPropertiesOf(state));
            }
            event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
            event.setCanceled(true);
        }
        if (stack.is(ItemTags.PICKAXES) && !player.isSpectator() && event.getFace() != Direction.DOWN && (level.isEmptyBlock(pos.above()) || level.getBlockState(pos.above()).canBeReplaced()) && state.is(PtwTags.Blocks.PATHABLE_BLOCKS_PICKAXE)) {
            SoundEvent sound = FLATTENING_SOUNDS.getOrDefault(state.getBlock(), SoundEvents.SHOVEL_FLATTEN);
            level.playSound(player, pos, sound, SoundSource.BLOCKS, 1, 1);
            if (!level.isClientSide) {
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(event.getHand()));
                level.setBlockAndUpdate(pos, EXTRA_SHOVELING_PICKAXE.get().get(state.getBlock()).withPropertiesOf(state));
            }
            event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
            event.setCanceled(true);
        }
    }
}

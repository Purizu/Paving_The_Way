package com.applenbutter.ptw.contents;

import com.applenbutter.ptw.PavingTheWay;
import com.applenbutter.ptw.contents.blocks.PtwBlocks;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.function.Supplier;

@EventBusSubscriber(modid = PavingTheWay.MOD_ID)
public class Events {

    @SubscribeEvent
    private static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.insertAfter(new ItemStack(Blocks.DIRT), new ItemStack(PtwBlocks.SHAVED_DIRT_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(Blocks.COARSE_DIRT), new ItemStack(PtwBlocks.COARSE_DIRT_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(Blocks.MYCELIUM), new ItemStack(PtwBlocks.MYCELIUM_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(Blocks.PODZOL), new ItemStack(PtwBlocks.PODZOL_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(Blocks.MUD), new ItemStack(PtwBlocks.MUD_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(Blocks.SAND), new ItemStack(PtwBlocks.SAND_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(Blocks.RED_SAND), new ItemStack(PtwBlocks.RED_SAND_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(Blocks.GRAVEL), new ItemStack(PtwBlocks.GRAVEL_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(Blocks.CRIMSON_NYLIUM), new ItemStack(PtwBlocks.CRIMSON_NYLIUM_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(Blocks.WARPED_NYLIUM), new ItemStack(PtwBlocks.WARPED_NYLIUM_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(Blocks.SOUL_SAND), new ItemStack(PtwBlocks.SOUL_SAND_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(Blocks.SOUL_SOIL), new ItemStack(PtwBlocks.SOUL_SOIL_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(Blocks.NETHERRACK), new ItemStack(PtwBlocks.NETHERRACK_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(Blocks.ROOTED_DIRT), new ItemStack(PtwBlocks.ROOTED_DIRT_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(Blocks.SNOW_BLOCK), new ItemStack(PtwBlocks.SNOW_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(Blocks.DIRT_PATH), new ItemStack(PtwBlocks.SNOWY_DIRT_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.insertAfter(new ItemStack(Blocks.PACKED_MUD), new ItemStack(PtwBlocks.PACKED_MUD_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    public static final Supplier<ImmutableMap<Block, SoundEvent>> FLATTENING_SOUNDS = Suppliers.memoize(() ->{
        ImmutableMap.Builder<Block, SoundEvent> builder = ImmutableMap.builder();
         builder.put(Blocks.SAND, SoundEvents.SAND_FALL);
         builder.put(Blocks.RED_SAND, SoundEvents.SAND_FALL);
         builder.put(Blocks.GRAVEL, SoundEvents.GRAVEL_FALL);
         builder.put(Blocks.MUD, SoundEvents.MUD_FALL);
         builder.put(Blocks.CRIMSON_NYLIUM, SoundEvents.NYLIUM_FALL);
         builder.put(Blocks.WARPED_NYLIUM, SoundEvents.NYLIUM_FALL);
         builder.put(Blocks.SOUL_SAND, SoundEvents.SOUL_SAND_FALL);
         builder.put(Blocks.SOUL_SOIL, SoundEvents.SOUL_SOIL_FALL);
         builder.put(Blocks.NETHERRACK, SoundEvents.NETHERRACK_FALL);
         builder.put(Blocks.ROOTED_DIRT, SoundEvents.ROOTED_DIRT_FALL);
         builder.put(Blocks.SNOW_BLOCK, SoundEvents.SNOW_FALL);
         builder.put(Blocks.PACKED_MUD, SoundEvents.PACKED_MUD_PLACE);
        return builder.build();
    });
    public static final Supplier<ImmutableMap<Block, Block>> EXTRA_SHOVELING = Suppliers.memoize(() ->{
        ImmutableMap.Builder<Block, Block> builder = ImmutableMap.builder();

        builder.put(Blocks.DIRT, PtwBlocks.SHAVED_DIRT_PATH.get());
        builder.put(Blocks.COARSE_DIRT, PtwBlocks.COARSE_DIRT_PATH.get());
        builder.put(Blocks.MYCELIUM, PtwBlocks.MYCELIUM_PATH.get());
        builder.put(Blocks.PODZOL, PtwBlocks.PODZOL_PATH.get());
        builder.put(Blocks.MUD, PtwBlocks.MUD_PATH.get());
        builder.put(Blocks.SAND, PtwBlocks.SAND_PATH.get());
        builder.put(Blocks.RED_SAND, PtwBlocks.RED_SAND_PATH.get());
        builder.put(Blocks.GRAVEL, PtwBlocks.GRAVEL_PATH.get());
        builder.put(Blocks.CRIMSON_NYLIUM, PtwBlocks.CRIMSON_NYLIUM_PATH.get());
        builder.put(Blocks.WARPED_NYLIUM, PtwBlocks.WARPED_NYLIUM_PATH.get());
        builder.put(Blocks.SOUL_SAND, PtwBlocks.SOUL_SAND_PATH.get());
        builder.put(Blocks.SOUL_SOIL, PtwBlocks.SOUL_SOIL_PATH.get());
        builder.put(Blocks.ROOTED_DIRT, PtwBlocks.ROOTED_DIRT_PATH.get());
        builder.put(Blocks.SNOW_BLOCK, PtwBlocks.SNOW_PATH.get());
        return builder.build();
    });
    public static final Supplier<ImmutableMap<Block, Block>> EXTRA_SHOVELING_PICKAXE = Suppliers.memoize(() ->{
        ImmutableMap.Builder<Block, Block> builder = ImmutableMap.builder();

        builder.put(Blocks.NETHERRACK, PtwBlocks.NETHERRACK_PATH.get());
        return builder.build();
    });

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
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(event.getHand()));
                level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                level.setBlockAndUpdate(pos.below(), PtwBlocks.SNOWY_DIRT_PATH.get().defaultBlockState());
            }
            event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
            event.setCanceled(true);
        }

        //Everything else
        if (stack.is(ItemTags.SHOVELS) && state.is(PtwTags.Blocks.PATHABLE_BLOCKS) && !player.isSpectator() && event.getFace() != Direction.DOWN && (level.isEmptyBlock(pos.above()) || level.getBlockState(pos.above()).canBeReplaced())) {
            SoundEvent sound = FLATTENING_SOUNDS.get().getOrDefault(state.getBlock(), SoundEvents.SHOVEL_FLATTEN);
            level.playSound(player, pos, sound, SoundSource.BLOCKS, 1, 1);
            if (!level.isClientSide) {
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(event.getHand()));
                level.setBlockAndUpdate(pos, EXTRA_SHOVELING.get().get(state.getBlock()).withPropertiesOf(state));
            }
            event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
            event.setCanceled(true);
        }
        if (stack.is(ItemTags.PICKAXES) && !player.isSpectator() && event.getFace() != Direction.DOWN && (level.isEmptyBlock(pos.above()) || level.getBlockState(pos.above()).canBeReplaced()) && state.is(PtwTags.Blocks.PATHABLE_BLOCKS_PICKAXE)) {
            SoundEvent sound = FLATTENING_SOUNDS.get().getOrDefault(state.getBlock(), SoundEvents.SHOVEL_FLATTEN);
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

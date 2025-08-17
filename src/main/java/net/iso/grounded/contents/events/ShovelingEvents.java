package net.iso.grounded.contents.events;

import com.google.common.collect.ImmutableMap;
import net.iso.grounded.Grounded;
import net.iso.grounded.contents.blocks.GroundedBlocks;
import net.iso.grounded.contents.utils.GroundedTags;
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

@Mod.EventBusSubscriber(modid = Grounded.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
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
    }

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        Player player = event.getEntity();
        ItemStack stack = event.getItemStack();

        if (stack.is(ItemTags.SHOVELS) && !player.isSpectator() && event.getFace() != Direction.DOWN && (level.isEmptyBlock(pos.above()) || level.getBlockState(pos.above()).canBeReplaced()) && state.is(GroundedTags.Blocks.PATHABLE_BLOCKS)) {
            SoundEvent sound = FLATTENING_SOUNDS.getOrDefault(state.getBlock(), SoundEvents.SHOVEL_FLATTEN);
            level.playSound(player, pos, sound, SoundSource.BLOCKS, 1, 1);

            if (!level.isClientSide) {
                stack.hurtAndBreak(1, player, player1 -> player1.broadcastBreakEvent(event.getHand()));
                BlockState pathState = ImmutableMap.ofEntries(Map.entry(
                        Blocks.GRASS_BLOCK, Blocks.DIRT_PATH.defaultBlockState().getBlockHolder()),
                        Map.entry(Blocks.DIRT, GroundedBlocks.SHAVED_DIRT_PATH),
                        Map.entry(Blocks.COARSE_DIRT, GroundedBlocks.COARSE_DIRT_PATH),
                        Map.entry(Blocks.MYCELIUM, GroundedBlocks.MYCELIUM_PATH),
                        Map.entry(Blocks.PODZOL, GroundedBlocks.PODZOL_PATH),
                        Map.entry(Blocks.MUD, GroundedBlocks.MUD_PATH),
                        Map.entry(Blocks.SAND, GroundedBlocks.SAND_PATH),
                        Map.entry(Blocks.RED_SAND, GroundedBlocks.RED_SAND_PATH),
                        Map.entry(Blocks.GRAVEL, GroundedBlocks.GRAVEL_PATH),
                        Map.entry(Blocks.CRIMSON_NYLIUM, GroundedBlocks.CRIMSON_NYLIUM_PATH),
                        Map.entry(Blocks.WARPED_NYLIUM, GroundedBlocks.WARPED_NYLIUM_PATH),
                        Map.entry(Blocks.SOUL_SAND, GroundedBlocks.SOUL_SAND_PATH),
                        Map.entry(Blocks.SOUL_SOIL, GroundedBlocks.SOUL_SOIL_PATH))
                        .get(state.getBlock()).get().defaultBlockState(); level.setBlockAndUpdate(pos, pathState);
            }
            event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
            event.setCanceled(true);
        }
    }
}

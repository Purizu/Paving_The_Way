package com.purizu.ptw.datagen;

import com.purizu.ptw.contents.utils.PtwTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

import static com.purizu.ptw.contents.blocks.PtwBlocks.*;

public class BlockTagDatagen extends FabricTagProvider.BlockTagProvider{
    public BlockTagDatagen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(NETHERRACK_PATH)
                .add(CRIMSON_NYLIUM_PATH)
                .add(WARPED_NYLIUM_PATH);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(SHAVED_DIRT_PATH)
                .add(COARSE_DIRT_PATH)
                .add(MYCELIUM_PATH)
                .add(PODZOL_PATH)
                .add(MUD_PATH)
                .add(SAND_PATH)
                .add(RED_SAND_PATH)
                .add(GRAVEL_PATH)
                .add(SOUL_SAND_PATH)
                .add(SOUL_SOIL_PATH)
                .add(ROOTED_DIRT_PATH);

        getOrCreateTagBuilder(BlockTags.SOUL_SPEED_BLOCKS)
                .add(SOUL_SAND_PATH)
                .add(SOUL_SOIL_PATH);

        getOrCreateTagBuilder(PtwTags.Blocks.PATHABLE_BLOCKS_PICKAXE).add(Blocks.NETHERRACK);

        getOrCreateTagBuilder(PtwTags.Blocks.PATHABLE_BLOCKS)
                .add(Blocks.DIRT)
                .add(Blocks.COARSE_DIRT)
                .add(Blocks.MYCELIUM)
                .add(Blocks.PODZOL)
                .add(Blocks.MUD)
                .add(Blocks.SAND)
                .add(Blocks.RED_SAND)
                .add(Blocks.GRAVEL)
                .add(Blocks.CRIMSON_NYLIUM)
                .add(Blocks.WARPED_NYLIUM)
                .add(Blocks.SOUL_SAND)
                .add(Blocks.SOUL_SOIL)
                .add(Blocks.ROOTED_DIRT);
    }
}

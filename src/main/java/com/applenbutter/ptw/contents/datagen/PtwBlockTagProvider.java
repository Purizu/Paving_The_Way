package com.applenbutter.ptw.contents.datagen;

import com.applenbutter.ptw.contents.PtwTags;
import com.applenbutter.ptw.contents.blocks.PtwBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class PtwBlockTagProvider extends BlockTagsProvider {
    public PtwBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(PtwBlocks.NETHERRACK_PATH.get())
                .add(PtwBlocks.CRIMSON_NYLIUM_PATH.get())
                .add(PtwBlocks.WARPED_NYLIUM_PATH.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(PtwBlocks.SHAVED_DIRT_PATH.get())
                .add(PtwBlocks.COARSE_DIRT_PATH.get())
                .add(PtwBlocks.MYCELIUM_PATH.get())
                .add(PtwBlocks.PODZOL_PATH.get())
                .add(PtwBlocks.MUD_PATH.get())
                .add(PtwBlocks.PACKED_MUD_PATH.get())
                .add(PtwBlocks.SAND_PATH.get())
                .add(PtwBlocks.RED_SAND_PATH.get())
                .add(PtwBlocks.GRAVEL_PATH.get())
                .add(PtwBlocks.SOUL_SAND_PATH.get())
                .add(PtwBlocks.SOUL_SOIL_PATH.get())
                .add(PtwBlocks.ROOTED_DIRT_PATH.get())
                .add(PtwBlocks.SNOW_PATH.get())
                .add(PtwBlocks.SNOWY_DIRT_PATH.get());

        tag(BlockTags.SOUL_SPEED_BLOCKS)
                .add(PtwBlocks.SOUL_SAND_PATH.get())
                .add(PtwBlocks.SOUL_SOIL_PATH.get());

        tag(PtwTags.Blocks.PATHABLE_BLOCKS)
                .add(Blocks.DIRT)
                .add(Blocks.COARSE_DIRT)
                .add(Blocks.MYCELIUM)
                .add(Blocks.PODZOL)
                .add(Blocks.MUD)
                .add(Blocks.PACKED_MUD)
                .add(Blocks.SAND)
                .add(Blocks.RED_SAND)
                .add(Blocks.GRAVEL)
                .add(Blocks.CRIMSON_NYLIUM)
                .add(Blocks.WARPED_NYLIUM)
                .add(Blocks.SOUL_SAND)
                .add(Blocks.SOUL_SOIL)
                .add(Blocks.ROOTED_DIRT)
                .add(Blocks.SNOW_BLOCK);

        tag(PtwTags.Blocks.PATHABLE_BLOCKS_PICKAXE).add(Blocks.NETHERRACK);

        tag(PtwTags.Blocks.SNOW_DIRT_PATH_VALID)
                .add(Blocks.GRASS_BLOCK)
                .add(Blocks.PODZOL)
                .add(Blocks.MYCELIUM);
    }
}

package com.applenbutter.ptw.contents.datagen;

import com.applenbutter.ptw.contents.blocks.PtwBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class PtwBlockLoottableProvider extends BlockLootSubProvider {


    protected PtwBlockLoottableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropOther(PtwBlocks.SHAVED_DIRT_PATH.get(), Blocks.DIRT);
        dropOther(PtwBlocks.COARSE_DIRT_PATH.get(), Blocks.COARSE_DIRT);
        dropOther(PtwBlocks.MYCELIUM_PATH.get(), Blocks.DIRT);
        dropOther(PtwBlocks.PODZOL_PATH.get(), Blocks.DIRT);
        dropOther(PtwBlocks.MUD_PATH.get(), Blocks.MUD);
        dropOther(PtwBlocks.SAND_PATH.get(), Blocks.SAND);
        dropOther(PtwBlocks.RED_SAND_PATH.get(), Blocks.RED_SAND);
        dropOther(PtwBlocks.GRAVEL_PATH.get(), Blocks.GRAVEL);
        dropOther(PtwBlocks.CRIMSON_NYLIUM_PATH.get(), Blocks.NETHERRACK);
        dropOther(PtwBlocks.WARPED_NYLIUM_PATH.get(), Blocks.NETHERRACK);
        dropOther(PtwBlocks.SOUL_SAND_PATH.get(), Blocks.SOUL_SAND);
        dropOther(PtwBlocks.SOUL_SOIL_PATH.get(), Blocks.SOUL_SOIL);
        dropOther(PtwBlocks.NETHERRACK_PATH.get(), Blocks.NETHERRACK);
        dropOther(PtwBlocks.ROOTED_DIRT_PATH.get(), Blocks.ROOTED_DIRT);
        add(PtwBlocks.SNOW_PATH.get(), createSilkTouchOnlyTable(Blocks.SNOW_BLOCK));
        dropOther(PtwBlocks.SNOWY_DIRT_PATH.get(), Blocks.DIRT);
        dropOther(PtwBlocks.PACKED_MUD_PATH.get(), Blocks.PACKED_MUD);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return PtwBlocks.BLOCKS.getEntries()
                .stream()
                .map(holder -> (Block) holder.get())
                ::iterator;
    }
}

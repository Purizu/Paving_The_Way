package com.purizu.ptw.datagen;

import com.purizu.ptw.contents.blocks.PtwBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;

public class LootTableDatagen extends FabricBlockLootTableProvider {

    public LootTableDatagen(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(PtwBlocks.SHAVED_DIRT_PATH, Blocks.DIRT);
        addDrop(PtwBlocks.COARSE_DIRT_PATH, Blocks.COARSE_DIRT);
        addDrop(PtwBlocks.MYCELIUM_PATH, Blocks.DIRT);
        addDrop(PtwBlocks.PODZOL_PATH, Blocks.DIRT);
        addDrop(PtwBlocks.MUD_PATH, Blocks.MUD);
        addDrop(PtwBlocks.SAND_PATH, Blocks.SAND);
        addDrop(PtwBlocks.RED_SAND_PATH, Blocks.RED_SAND);
        addDrop(PtwBlocks.GRAVEL_PATH, Blocks.GRAVEL);
        addDrop(PtwBlocks.CRIMSON_NYLIUM_PATH, Blocks.NETHERRACK);
        addDrop(PtwBlocks.WARPED_NYLIUM_PATH, Blocks.NETHERRACK);
        addDrop(PtwBlocks.SOUL_SAND_PATH, Blocks.SOUL_SAND);
        addDrop(PtwBlocks.SOUL_SOIL_PATH, Blocks.SOUL_SOIL);
        addDrop(PtwBlocks.NETHERRACK_PATH, Blocks.NETHERRACK);
        addDrop(PtwBlocks.ROOTED_DIRT_PATH, Blocks.ROOTED_DIRT);
    }
}

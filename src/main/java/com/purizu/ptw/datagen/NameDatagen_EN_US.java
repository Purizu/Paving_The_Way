package com.purizu.ptw.datagen;

import com.purizu.ptw.contents.blocks.PtwBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Blocks;

public class NameDatagen_EN_US extends FabricLanguageProvider {
    protected NameDatagen_EN_US(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(Blocks.DIRT_PATH, "Grass Path");
        translationBuilder.add(PtwBlocks.SHAVED_DIRT_PATH, "Dirt Path");
        translationBuilder.add(PtwBlocks.COARSE_DIRT_PATH, "Coarse Dirt Path");
        translationBuilder.add(PtwBlocks.MYCELIUM_PATH, "Mycelium Path");
        translationBuilder.add(PtwBlocks.PODZOL_PATH, "Podzol Path");
        translationBuilder.add(PtwBlocks.MUD_PATH, "Mud Path");
        translationBuilder.add(PtwBlocks.SAND_PATH, "Sand Path");
        translationBuilder.add(PtwBlocks.RED_SAND_PATH, "Red Sand Path");
        translationBuilder.add(PtwBlocks.GRAVEL_PATH, "Gravel Path");
        translationBuilder.add(PtwBlocks.CRIMSON_NYLIUM_PATH, "Crimson Nylium Path");
        translationBuilder.add(PtwBlocks.WARPED_NYLIUM_PATH, "Warped Nylium Path");
        translationBuilder.add(PtwBlocks.SOUL_SAND_PATH, "Soul Sand Path");
        translationBuilder.add(PtwBlocks.SOUL_SOIL_PATH, "Soul Soil Path");
        translationBuilder.add(PtwBlocks.NETHERRACK_PATH, "Netherrack Path");
    }
}

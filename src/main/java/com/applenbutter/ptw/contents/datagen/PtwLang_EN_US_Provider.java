package com.applenbutter.ptw.contents.datagen;

import com.applenbutter.ptw.contents.blocks.PtwBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class PtwLang_EN_US_Provider extends LanguageProvider {

    public PtwLang_EN_US_Provider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        add(PtwBlocks.SHAVED_DIRT_PATH.get(), "Dirt Path");
        add(PtwBlocks.COARSE_DIRT_PATH.get(), "Coarse Dirt Path");
        add(PtwBlocks.MYCELIUM_PATH.get(), "Mycelium Path");
        add(PtwBlocks.PODZOL_PATH.get(), "Podzol Path");
        add(PtwBlocks.MUD_PATH.get(), "Mud Path");
        add(PtwBlocks.PACKED_MUD_PATH.get(), "Packed Mud Path");
        add(PtwBlocks.SAND_PATH.get(), "Sand Path");
        add(PtwBlocks.RED_SAND_PATH.get(), "Red Sand Path");
        add(PtwBlocks.GRAVEL_PATH.get(), "Gravel Path");
        add(PtwBlocks.CRIMSON_NYLIUM_PATH.get(), "Crimson Nylium Path");
        add(PtwBlocks.WARPED_NYLIUM_PATH.get(), "Warped Nylium Path");
        add(PtwBlocks.SOUL_SAND_PATH.get(), "Soul Sand Path");
        add(PtwBlocks.SOUL_SOIL_PATH.get(), "Soul Soil Path");
        add(PtwBlocks.NETHERRACK_PATH.get(), "Netherrack Path");
        add(PtwBlocks.ROOTED_DIRT_PATH.get(), "Rooted Dirt Path");
        add(PtwBlocks.SNOW_PATH.get(), "Snow Block Path");
        add(PtwBlocks.SNOWY_DIRT_PATH.get(), "Snowy Dirt Path");
    }
}

package com.applenbutter.ptw.contents.datagen;

import com.applenbutter.ptw.contents.blocks.PtwBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class VanillaLang_EN_US_Provider extends LanguageProvider {

    public VanillaLang_EN_US_Provider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        add(Blocks.DIRT_PATH, "Grass Path");
    }
}

package com.butteredapples.ptw.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class PavingTheWayDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.createPack().addProvider(BlockTagDatagen::new);
        fabricDataGenerator.createPack().addProvider(LootTableDatagen::new);
        fabricDataGenerator.createPack().addProvider(NameDatagen_EN_US::new);
	}
}

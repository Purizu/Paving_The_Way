package com.butteredapples.ptw;

import com.butteredapples.ptw.contents.blocks.PtwBlocks;
import com.butteredapples.ptw.contents.events.CreativeModeEvents;
import com.butteredapples.ptw.contents.events.ShovelingEvents;
import net.fabricmc.api.ModInitializer;

public class PavingTheWay implements ModInitializer {
	public static final String MOD_ID = "ptw";

	@Override
	public void onInitialize() {
        PtwBlocks.registerModBlocks();
        ShovelingEvents.registerEvents();
        CreativeModeEvents.registerEvents();
	}
}
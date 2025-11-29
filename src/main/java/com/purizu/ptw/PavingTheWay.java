package com.purizu.ptw;

import com.purizu.ptw.contents.blocks.PtwBlocks;
import com.purizu.ptw.contents.events.CreativeModeEvents;
import com.purizu.ptw.contents.events.ShovelingEvents;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PavingTheWay implements ModInitializer {
	public static final String MOD_ID = "ptw";

	@Override
	public void onInitialize() {
        PtwBlocks.registerModBlocks();
        ShovelingEvents.registerEvents();
        CreativeModeEvents.registerEvents();
	}
}
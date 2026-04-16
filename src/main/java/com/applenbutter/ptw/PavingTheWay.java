package com.applenbutter.ptw;

import com.applenbutter.ptw.contents.blocks.PtwBlocks;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;

@Mod(PavingTheWay.MOD_ID)
public class PavingTheWay {

    public static final String MOD_ID = "ptw";
    public static final Logger LOGGER = LogUtils.getLogger();


    public PavingTheWay(IEventBus modEventBus, ModContainer modContainer) {
        //NeoForge.EVENT_BUS.register(this);
        PtwBlocks.ITEMS.register(modEventBus);
        PtwBlocks.BLOCKS.register(modEventBus);
    }
}

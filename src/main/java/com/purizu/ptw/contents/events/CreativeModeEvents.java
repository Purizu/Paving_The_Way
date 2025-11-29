package com.purizu.ptw.contents.events;

import com.purizu.ptw.contents.blocks.PtwBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class CreativeModeEvents {

    public static void registerEvents(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(c -> {
                    c.addAfter(new ItemStack(Items.DIRT), new ItemStack(PtwBlocks.SHAVED_DIRT_PATH));
                    c.addAfter(new ItemStack(Items.COARSE_DIRT), new ItemStack(PtwBlocks.COARSE_DIRT_PATH));
                    c.addAfter(new ItemStack(Items.MYCELIUM), new ItemStack(PtwBlocks.MYCELIUM_PATH));
                    c.addAfter(new ItemStack(Items.PODZOL), new ItemStack(PtwBlocks.PODZOL_PATH));
                    c.addAfter(new ItemStack(Items.MUD), new ItemStack(PtwBlocks.MUD_PATH));
                    c.addAfter(new ItemStack(Items.SAND), new ItemStack(PtwBlocks.SAND_PATH));
                    c.addAfter(new ItemStack(Items.RED_SAND), new ItemStack(PtwBlocks.RED_SAND_PATH));
                    c.addAfter(new ItemStack(Items.GRAVEL), new ItemStack(PtwBlocks.GRAVEL_PATH));
                    c.addAfter(new ItemStack(Items.CRIMSON_NYLIUM), new ItemStack(PtwBlocks.CRIMSON_NYLIUM_PATH));
                    c.addAfter(new ItemStack(Items.WARPED_NYLIUM), new ItemStack(PtwBlocks.WARPED_NYLIUM_PATH));
                    c.addAfter(new ItemStack(Items.SOUL_SAND), new ItemStack(PtwBlocks.SOUL_SAND_PATH));
                    c.addAfter(new ItemStack(Items.SOUL_SOIL), new ItemStack(PtwBlocks.SOUL_SOIL_PATH));
                    c.addAfter(new ItemStack(Items.NETHERRACK), new ItemStack(PtwBlocks.NETHERRACK_PATH));
        });
    }
}

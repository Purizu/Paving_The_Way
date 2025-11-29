package com.purizu.ptw.contents.utils;

import com.purizu.ptw.PavingTheWay;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class PtwTags {
    public static class Blocks {
        public static final TagKey<Block> PATHABLE_BLOCKS = tag("pathable_blocks");
        public static final TagKey<Block> PATHABLE_BLOCKS_PICKAXE = tag("pathable_blocks_pickaxe");

        private static TagKey<Block> tag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(PavingTheWay.MOD_ID, name));
        }
    }
}

package net.purizu.ptw.contents.utils;

import net.purizu.ptw.PavingTheWay;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class PtwTags {
    @SuppressWarnings("removal")
    public static class Blocks {
        public static final TagKey<Block> PATHABLE_BLOCKS = tag("pathable_blocks");
        public static final TagKey<Block> PATHABLE_BLOCKS_PICKAXE = tag("pathable_blocks_pickaxe");

        public static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(PavingTheWay.MOD_ID, name));
        }
    }
}

package net.iso.grounded.contents.utils;

import net.iso.grounded.Grounded;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class GroundedTags {
    @SuppressWarnings("removal")
    public static class Blocks {
        public static final TagKey<Block> PATHABLE_BLOCKS = tag("pathable_blocks");

        public static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Grounded.MOD_ID, name));
        }
    }
}

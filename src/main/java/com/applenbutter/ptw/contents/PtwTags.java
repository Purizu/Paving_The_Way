package com.applenbutter.ptw.contents;

import com.applenbutter.ptw.PavingTheWay;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class PtwTags {
    public static class Blocks {
        public static final TagKey<Block> PATHABLE_BLOCKS = tag("pathable_blocks");
        public static final TagKey<Block> PATHABLE_BLOCKS_PICKAXE = tag("pathable_blocks_pickaxe");
        public static final TagKey<Block> SNOW_DIRT_PATH_VALID = tag("snow_dirt_path_valid");

        public static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.tryBuild(PavingTheWay.MOD_ID, name));
        }
    }
}

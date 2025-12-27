package com.purizu.ptw.contents.blocks;

import com.purizu.ptw.PavingTheWay;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DirtPathBlock;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PtwBlocks {

    public static final Block SHAVED_DIRT_PATH = registerBlock("shaved_dirt_path", new DirtPathBlock(FabricBlockSettings.copy(Blocks.DIRT)));
    public static final Block COARSE_DIRT_PATH = registerBlock("coarse_dirt_path", new BetterDirtPathBlock(FabricBlockSettings.copy(Blocks.COARSE_DIRT), Blocks.COARSE_DIRT, false));
    public static final Block MYCELIUM_PATH = registerBlock("mycelium_path", new BetterDirtPathBlock(FabricBlockSettings.copy(Blocks.DIRT).mapColor(MapColor.TERRACOTTA_PURPLE), Blocks.DIRT, false));
    public static final Block PODZOL_PATH = registerBlock("podzol_path", new DirtPathBlock(FabricBlockSettings.copy(Blocks.PODZOL)));
    public static final Block MUD_PATH = registerBlock("mud_path", new BetterDirtPathBlock(FabricBlockSettings.copy(Blocks.MUD), Blocks.MUD, false));
    public static final Block SAND_PATH = registerBlock("sand_path", new BetterDirtPathBlock(FabricBlockSettings.copy(Blocks.SAND), Blocks.SAND, true));
    public static final Block RED_SAND_PATH = registerBlock("red_sand_path", new BetterDirtPathBlock(FabricBlockSettings.copy(Blocks.SAND), Blocks.RED_SAND, true));
    public static final Block GRAVEL_PATH = registerBlock("gravel_path", new BetterDirtPathBlock(FabricBlockSettings.copy(Blocks.GRAVEL), Blocks.GRAVEL, true));
    public static final Block CRIMSON_NYLIUM_PATH = registerBlock("crimson_nylium_path", new BetterDirtPathBlock(FabricBlockSettings.copy(Blocks.NETHERRACK).mapColor(MapColor.DARK_CRIMSON), Blocks.NETHERRACK, false));
    public static final Block WARPED_NYLIUM_PATH = registerBlock("warped_nylium_path", new BetterDirtPathBlock(FabricBlockSettings.copy(Blocks.NETHERRACK).mapColor(MapColor.TEAL), Blocks.NETHERRACK, false));
    public static final Block SOUL_SAND_PATH = registerBlock("soul_sand_path", new BetterDirtPathBlock(FabricBlockSettings.copy(Blocks.SOUL_SAND), Blocks.SOUL_SAND, false));
    public static final Block SOUL_SOIL_PATH = registerBlock("soul_soil_path", new BetterDirtPathBlock(FabricBlockSettings.copy(Blocks.SOUL_SOIL), Blocks.SOUL_SOIL, false));
    public static final Block NETHERRACK_PATH = registerBlock("netherrack_path", new BetterDirtPathBlock(FabricBlockSettings.copy(Blocks.NETHERRACK), Blocks.NETHERRACK, false));
    public static final Block ROOTED_DIRT_PATH = registerBlock("rooteed_dirt_path", new BetterDirtPathBlock(FabricBlockSettings.copy(Blocks.ROOTED_DIRT), Blocks.ROOTED_DIRT, false));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(PavingTheWay.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(PavingTheWay.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {

    }
}

package com.applenbutter.ptw.contents.blocks;

import com.applenbutter.ptw.PavingTheWay;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DirtPathBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class PtwBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PavingTheWay.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PavingTheWay.MOD_ID);

    public static final DeferredBlock<Block> SHAVED_DIRT_PATH = registerBlock("shaved_dirt_path", (properties)-> new DirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> COARSE_DIRT_PATH = registerBlock("coarse_dirt_path", (properties)-> new BetterDirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT), Blocks.COARSE_DIRT, false));
    public static final DeferredBlock<Block> MYCELIUM_PATH = registerBlock("mycelium_path", (properties)-> new BetterDirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).mapColor(MapColor.TERRACOTTA_PURPLE), Blocks.DIRT, false));
    public static final DeferredBlock<Block> PODZOL_PATH = registerBlock("podzol_path", (properties)-> new DirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PODZOL)));
    public static final DeferredBlock<Block> MUD_PATH = registerBlock("mud_path", (properties)-> new BetterDirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD), Blocks.MUD, false));
    public static final DeferredBlock<Block> SAND_PATH = registerBlock("sand_path", (properties)-> new BetterDirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND), Blocks.SAND, true));
    public static final DeferredBlock<Block> RED_SAND_PATH = registerBlock("red_sand_path", (properties)-> new BetterDirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND), Blocks.RED_SAND, true));
    public static final DeferredBlock<Block> GRAVEL_PATH = registerBlock("gravel_path", (properties)-> new BetterDirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAVEL), Blocks.GRAVEL, true));
    public static final DeferredBlock<Block> CRIMSON_NYLIUM_PATH = registerBlock("crimson_nylium_path", (properties)-> new BetterDirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).mapColor(MapColor.CRIMSON_NYLIUM), Blocks.NETHERRACK, false));
    public static final DeferredBlock<Block> WARPED_NYLIUM_PATH = registerBlock("warped_nylium_path", (properties)-> new BetterDirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).mapColor(MapColor.WARPED_NYLIUM), Blocks.NETHERRACK, false));
    public static final DeferredBlock<Block> SOUL_SAND_PATH = registerBlock("soul_sand_path", (properties)-> new BetterDirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_SAND), Blocks.SOUL_SAND, false));
    public static final DeferredBlock<Block> SOUL_SOIL_PATH = registerBlock("soul_soil_path", (properties)-> new BetterDirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_SOIL), Blocks.SOUL_SOIL, false));
    public static final DeferredBlock<Block> NETHERRACK_PATH = registerBlock("netherrack_path", (properties)-> new BetterDirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK), Blocks.NETHERRACK, false));
    public static final DeferredBlock<Block> ROOTED_DIRT_PATH = registerBlock("rooted_dirt_path", (properties)-> new BetterDirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ROOTED_DIRT), Blocks.ROOTED_DIRT, false));
    public static final DeferredBlock<Block> SNOW_PATH = registerBlock("snow_path", (properties)-> new BetterDirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK), Blocks.SNOW, false));
    public static final DeferredBlock<Block> SNOWY_DIRT_PATH = registerBlock("snowy_dirt_path", (properties)-> new BetterDirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT), Blocks.DIRT, false));
    public static final DeferredBlock<Block> PACKED_MUD_PATH = registerBlock("packed_mud_path", (properties)-> new BetterDirtPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD), Blocks.PACKED_MUD, false));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ITEMS.registerItem(name, (properties) -> new BlockItem(block.get(), properties));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

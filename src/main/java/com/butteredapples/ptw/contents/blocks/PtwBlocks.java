package com.butteredapples.ptw.contents.blocks;

import com.butteredapples.ptw.PavingTheWay;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DirtPathBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class PtwBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PavingTheWay.MOD_ID);
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, PavingTheWay.MOD_ID);

    public static final RegistryObject<Block> SHAVED_DIRT_PATH = registerBlock("shaved_dirt_path", ()-> new DirtPathBlock(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> COARSE_DIRT_PATH = registerBlock("coarse_dirt_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT), Blocks.COARSE_DIRT, false));
    public static final RegistryObject<Block> MYCELIUM_PATH = registerBlock("mycelium_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).mapColor(MapColor.TERRACOTTA_PURPLE), Blocks.DIRT, false));
    public static final RegistryObject<Block> PODZOL_PATH = registerBlock("podzol_path", ()-> new DirtPathBlock(BlockBehaviour.Properties.copy(Blocks.PODZOL)));
    public static final RegistryObject<Block> MUD_PATH = registerBlock("mud_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.MUD), Blocks.MUD, false));
    public static final RegistryObject<Block> SAND_PATH = registerBlock("sand_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.SAND), Blocks.SAND, true));
    public static final RegistryObject<Block> RED_SAND_PATH = registerBlock("red_sand_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.SAND), Blocks.RED_SAND, true));
    public static final RegistryObject<Block> GRAVEL_PATH = registerBlock("gravel_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL), Blocks.GRAVEL, true));
    public static final RegistryObject<Block> CRIMSON_NYLIUM_PATH = registerBlock("crimson_nylium_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).mapColor(MapColor.CRIMSON_NYLIUM), Blocks.NETHERRACK, false));
    public static final RegistryObject<Block> WARPED_NYLIUM_PATH = registerBlock("warped_nylium_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).mapColor(MapColor.WARPED_NYLIUM), Blocks.NETHERRACK, false));
    public static final RegistryObject<Block> SOUL_SAND_PATH = registerBlock("soul_sand_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_SAND), Blocks.SOUL_SAND, false));
    public static final RegistryObject<Block> SOUL_SOIL_PATH = registerBlock("soul_soil_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_SOIL), Blocks.SOUL_SOIL, false));
    public static final RegistryObject<Block> NETHERRACK_PATH = registerBlock("netherrack_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK), Blocks.NETHERRACK, false));
    public static final RegistryObject<Block> ROOTED_DIRT_PATH = registerBlock("rooted_dirt_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.ROOTED_DIRT), Blocks.ROOTED_DIRT, false));
    public static final RegistryObject<Block> SNOW_PATH = registerBlock("snow_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.SNOW), Blocks.SNOW, false));
    public static final RegistryObject<Block> SNOWY_DIRT_PATH = registerBlock("snowy_dirt_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.DIRT), Blocks.DIRT, false));
    public static final RegistryObject<Block> PACKED_MUD_PATH = registerBlock("packed_mud_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_MUD), Blocks.PACKED_MUD, false));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ITEM.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

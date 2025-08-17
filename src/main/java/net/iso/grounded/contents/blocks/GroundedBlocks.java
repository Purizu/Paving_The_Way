package net.iso.grounded.contents.blocks;

import net.iso.grounded.Grounded;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DirtPathBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class GroundedBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Grounded.MOD_ID);
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, Grounded.MOD_ID);

    public static final RegistryObject<Block> SHAVED_DIRT_PATH = registerBlock("shaved_dirt_path", ()-> new DirtPathBlock(BlockBehaviour.Properties.copy(Blocks.DIRT)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> COARSE_DIRT_PATH = registerBlock("coarse_dirt_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT), Blocks.COARSE_DIRT, false), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> MYCELIUM_PATH = registerBlock("mycelium_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).color(MaterialColor.TERRACOTTA_PURPLE), Blocks.DIRT, false), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> PODZOL_PATH = registerBlock("podzol_path", ()-> new DirtPathBlock(BlockBehaviour.Properties.copy(Blocks.PODZOL)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> MUD_PATH = registerBlock("mud_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.MUD), Blocks.MUD, false), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> SAND_PATH = registerBlock("sand_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.SAND), Blocks.SAND, true), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> RED_SAND_PATH = registerBlock("red_sand_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.SAND), Blocks.RED_SAND, true), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> GRAVEL_PATH = registerBlock("gravel_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL), Blocks.GRAVEL, true), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> CRIMSON_NYLIUM_PATH = registerBlock("crimson_nylium_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).color(MaterialColor.CRIMSON_NYLIUM), Blocks.NETHERRACK, false), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> WARPED_NYLIUM_PATH = registerBlock("warped_nylium_path", ()-> new BetterDirtPathBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).color(MaterialColor.WARPED_NYLIUM), Blocks.NETHERRACK, false), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> SOUL_SAND_PATH = registerBlock("soul_sand_path", ()-> new DirtPathBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_SAND)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> SOUL_SOIL_PATH = registerBlock("soul_soil_path", ()-> new DirtPathBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_SOIL)), CreativeModeTab.TAB_DECORATIONS);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ITEM.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

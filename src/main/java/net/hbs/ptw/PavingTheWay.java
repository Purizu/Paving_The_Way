package net.hbs.ptw;

import net.hbs.ptw.contents.blocks.PtwBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PavingTheWay.MOD_ID)
public class PavingTheWay
{
    public static final String MOD_ID = "ptw";

    public PavingTheWay(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        PtwBlocks.ITEM.register(modEventBus);
        PtwBlocks.BLOCKS.register(modEventBus);
        modEventBus.addListener(this::addCreative);

    }

    public void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            //Code by kapitencraft on the Kaupenhub discord server
            MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries = event.getEntries();
            entries.putAfter(new ItemStack(Blocks.DIRT), new ItemStack(PtwBlocks.SHAVED_DIRT_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.COARSE_DIRT), new ItemStack(PtwBlocks.COARSE_DIRT_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.MYCELIUM), new ItemStack(PtwBlocks.MYCELIUM_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.PODZOL), new ItemStack(PtwBlocks.PODZOL_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.MUD), new ItemStack(PtwBlocks.MUD_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.SAND), new ItemStack(PtwBlocks.SAND_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.RED_SAND), new ItemStack(PtwBlocks.RED_SAND_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.GRAVEL), new ItemStack(PtwBlocks.GRAVEL_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.CRIMSON_NYLIUM), new ItemStack(PtwBlocks.CRIMSON_NYLIUM_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.WARPED_NYLIUM), new ItemStack(PtwBlocks.WARPED_NYLIUM_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.SOUL_SAND), new ItemStack(PtwBlocks.SOUL_SAND_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.SOUL_SOIL), new ItemStack(PtwBlocks.SOUL_SOIL_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.NETHERRACK), new ItemStack(PtwBlocks.NETHERRACK_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }
}

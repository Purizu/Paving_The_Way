package net.iso.grounded;

import net.iso.grounded.contents.blocks.GroundedBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Grounded.MOD_ID)
public class Grounded
{
    public static final String MOD_ID = "grounded";

    public Grounded(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        GroundedBlocks.ITEM.register(modEventBus);
        GroundedBlocks.BLOCKS.register(modEventBus);
        modEventBus.addListener(this::addCreative);

    }

    public void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            //Code by kapitencraft on the Kaupenhub discord server
            MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries = event.getEntries();
            entries.putAfter(new ItemStack(Blocks.DIRT), new ItemStack(GroundedBlocks.SHAVED_DIRT_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.COARSE_DIRT), new ItemStack(GroundedBlocks.COARSE_DIRT_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.MYCELIUM), new ItemStack(GroundedBlocks.MYCELIUM_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.PODZOL), new ItemStack(GroundedBlocks.PODZOL_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.MUD), new ItemStack(GroundedBlocks.MUD_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.SAND), new ItemStack(GroundedBlocks.SAND_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.RED_SAND), new ItemStack(GroundedBlocks.RED_SAND_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.GRAVEL), new ItemStack(GroundedBlocks.GRAVEL_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.CRIMSON_NYLIUM), new ItemStack(GroundedBlocks.CRIMSON_NYLIUM_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.WARPED_NYLIUM), new ItemStack(GroundedBlocks.WARPED_NYLIUM_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.SOUL_SAND), new ItemStack(GroundedBlocks.SOUL_SAND_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(new ItemStack(Blocks.SOUL_SOIL), new ItemStack(GroundedBlocks.SOUL_SOIL_PATH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}

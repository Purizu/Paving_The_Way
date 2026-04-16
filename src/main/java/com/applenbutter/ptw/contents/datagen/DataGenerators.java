package com.applenbutter.ptw.contents.datagen;

import com.applenbutter.ptw.PavingTheWay;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = PavingTheWay.MOD_ID)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        event.addProvider(new PtwBlockTagProvider(output, lookupProvider, PavingTheWay.MOD_ID, existingFileHelper));
        event.addProvider(
                new LootTableProvider(output, Set.of(), List.of(
                        new LootTableProvider.SubProviderEntry(
                                PtwBlockLoottableProvider::new,
                                LootContextParamSets.BLOCK
                        )
                ), lookupProvider)
        );
        event.addProvider(new PtwLang_EN_US_Provider(output, PavingTheWay.MOD_ID, "en_us"));
        event.addProvider(new VanillaLang_EN_US_Provider(output, "minecraft", "en_us"));
        event.getGenerator().addProvider(event.includeClient() ,new PtwBlockModelProvider(output, PavingTheWay.MOD_ID, existingFileHelper));
    }
}

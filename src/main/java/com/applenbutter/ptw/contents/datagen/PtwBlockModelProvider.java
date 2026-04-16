package com.applenbutter.ptw.contents.datagen;

import com.applenbutter.ptw.PavingTheWay;
import com.applenbutter.ptw.contents.blocks.PtwBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class PtwBlockModelProvider extends BlockStateProvider {

    public PtwBlockModelProvider(PackOutput output, String modID, ExistingFileHelper exFileHelper) {
        super(output, modID, exFileHelper);
    }

    @Override
    public void registerStatesAndModels() {
        pathBlock(PtwBlocks.SHAVED_DIRT_PATH.get(), Blocks.DIRT);
        pathBlock(PtwBlocks.COARSE_DIRT_PATH.get(), Blocks.DIRT);
        pathBlock(PtwBlocks.ROOTED_DIRT_PATH.get(), Blocks.DIRT);
        pathBlock(PtwBlocks.MYCELIUM_PATH.get(), Blocks.DIRT);
        pathBlock(PtwBlocks.PODZOL_PATH.get(), Blocks.DIRT);
        pathBlock(PtwBlocks.MUD_PATH.get(), Blocks.MUD);
        pathBlock(PtwBlocks.PACKED_MUD_PATH.get(), Blocks.PACKED_MUD);
        pathBlock(PtwBlocks.SAND_PATH.get(), Blocks.SAND);
        pathBlock(PtwBlocks.RED_SAND_PATH.get(), Blocks.RED_SAND);
        pathBlock(PtwBlocks.GRAVEL_PATH.get(), Blocks.GRAVEL);
        pathBlock(PtwBlocks.NETHERRACK_PATH.get(), Blocks.NETHERRACK);
        pathBlock(PtwBlocks.CRIMSON_NYLIUM_PATH.get(), Blocks.NETHERRACK);
        pathBlock(PtwBlocks.WARPED_NYLIUM_PATH.get(), Blocks.NETHERRACK);
        pathBlock(PtwBlocks.SOUL_SAND_PATH.get(), Blocks.SOUL_SAND);
        pathBlock(PtwBlocks.SOUL_SOIL_PATH.get(),Blocks.SOUL_SOIL);
        pathBlock(PtwBlocks.SNOW_PATH.get(), Blocks.SNOW);
        pathBlock(PtwBlocks.SNOWY_DIRT_PATH.get(), Blocks.DIRT, PtwBlocks.SNOW_PATH.get());
    }

    private void pathBlock(Block block, Block bottomBlock, Block top){
        String name = BuiltInRegistries.BLOCK.getKey(block).getPath();
        String name2 = BuiltInRegistries.BLOCK.getKey(bottomBlock).getPath();
        String name3 = BuiltInRegistries.BLOCK.getKey(top).getPath();
        ResourceLocation up    = ResourceLocation.fromNamespaceAndPath(PavingTheWay.MOD_ID, "block/" + name3);
        ResourceLocation side   = ResourceLocation.fromNamespaceAndPath(PavingTheWay.MOD_ID, "block/" + name + "_side");
        ResourceLocation bottom = ResourceLocation.fromNamespaceAndPath("minecraft", "block/" + name2);

        ModelFile model = models().getBuilder(name)
                .parent(models().getExistingFile(ResourceLocation.fromNamespaceAndPath("minecraft", "block/block")))
                .texture("particle", bottom)
                .texture("top", up)
                .texture("side", side)
                .texture("bottom", bottom)
                .element()
                .from(0, 0, 0)
                .to(16, 15, 16)
                .face(Direction.DOWN)
                .uvs(0, 0, 16, 16).texture("#bottom").cullface(Direction.DOWN).end()
                .face(Direction.UP)
                .uvs(0, 0, 16, 16).texture("#top").end()
                .face(Direction.NORTH)
                .uvs(0, 1, 16, 16).texture("#side").cullface(Direction.NORTH).end()
                .face(Direction.SOUTH)
                .uvs(0, 1, 16, 16).texture("#side").cullface(Direction.SOUTH).end()
                .face(Direction.WEST)
                .uvs(0, 1, 16, 16).texture("#side").cullface(Direction.WEST).end()
                .face(Direction.EAST)
                .uvs(0, 1, 16, 16).texture("#side").cullface(Direction.EAST).end()
                .end();
        getVariantBuilder(block)
                .partialState().addModels(
                        new ConfiguredModel(model, 0, 0,   false),
                        new ConfiguredModel(model, 0, 90,  false),
                        new ConfiguredModel(model, 0, 180, false),
                        new ConfiguredModel(model, 0, 270, false)
                );
        itemModels().withExistingParent(name, ResourceLocation.fromNamespaceAndPath(PavingTheWay.MOD_ID, "block/" + name));
    }

    private void pathBlock(Block block, Block bottomBlock) {
        String name = BuiltInRegistries.BLOCK.getKey(block).getPath();
        String name2 = BuiltInRegistries.BLOCK.getKey(bottomBlock).getPath();
        ResourceLocation top    = ResourceLocation.fromNamespaceAndPath(PavingTheWay.MOD_ID, "block/" + name);
        ResourceLocation side   = ResourceLocation.fromNamespaceAndPath(PavingTheWay.MOD_ID, "block/" + name + "_side");
        ResourceLocation bottom = ResourceLocation.fromNamespaceAndPath("minecraft", "block/" + name2);

        ModelFile model = models().getBuilder(name)
                .parent(models().getExistingFile(ResourceLocation.fromNamespaceAndPath("minecraft", "block/block")))
                .texture("particle", bottom)
                .texture("top", top)
                .texture("side", side)
                .texture("bottom", bottom)
                .element()
                .from(0, 0, 0)
                .to(16, 15, 16)
                .face(Direction.DOWN)
                .uvs(0, 0, 16, 16).texture("#bottom").cullface(Direction.DOWN).end()
                .face(Direction.UP)
                .uvs(0, 0, 16, 16).texture("#top").end()
                .face(Direction.NORTH)
                .uvs(0, 1, 16, 16).texture("#side").cullface(Direction.NORTH).end()
                .face(Direction.SOUTH)
                .uvs(0, 1, 16, 16).texture("#side").cullface(Direction.SOUTH).end()
                .face(Direction.WEST)
                .uvs(0, 1, 16, 16).texture("#side").cullface(Direction.WEST).end()
                .face(Direction.EAST)
                .uvs(0, 1, 16, 16).texture("#side").cullface(Direction.EAST).end()
                .end();
        getVariantBuilder(block)
                .partialState().addModels(
                        new ConfiguredModel(model, 0, 0,   false),
                        new ConfiguredModel(model, 0, 90,  false),
                        new ConfiguredModel(model, 0, 180, false),
                        new ConfiguredModel(model, 0, 270, false)
                );
        itemModels().withExistingParent(name, ResourceLocation.fromNamespaceAndPath(PavingTheWay.MOD_ID, "block/" + name));
    }

}

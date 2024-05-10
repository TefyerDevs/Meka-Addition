package org.tefyer.ma.generators.gens;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.tefyer.ma.MekaAddition;
import org.tefyer.ma.block.BlockRegistry;

public class BlockStateGenerator extends BlockStateProvider {

    public static final String MACHINE_PARENT = "mekanism:block/machine";
    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }


    public BlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MekaAddition.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BlockRegistry.ANTIUBECIS_MINING_CASING);
        blockItemWithRenderLayer(BlockRegistry.ANTIUBECIS_MINING_GLASS,"minecraft:translucent");

        blockWithItem(BlockRegistry.SUPERMINING_ELEMENT);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }



    private void blockItemWithRenderLayer(RegistryObject<Block> blockRegistryObject,String renderType) {
        blockWithRenderLayer(blockRegistryObject.get(),renderType);
        simpleBlockItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    public void blockWithRenderLayer(Block block,String renderType) {
        simpleBlock(block,
                cubeAAll(block,renderType));
    }
    public ModelFile cubeAAll(Block block,String renderType) {
        return models().cubeAll(name(block), blockTexture(block)).renderType(renderType);
    }


}
